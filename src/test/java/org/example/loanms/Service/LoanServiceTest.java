package org.example.loanms.Service;

import org.example.loanms.Exceptions.LoanNotFoundException;
import org.example.loanms.Model.Loan;
import org.example.loanms.Repo.LoanRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoanServiceTest {

    @Mock
    private LoanRepo loanRepo;

    @InjectMocks
    private LoanService loanService;

    private Loan loan;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        loan = new Loan(1L, "John Doe", 10000L, 12, "Car", "PENDING", LocalDate.now().minusDays(10));
    }

    @Test
    public void testCreateLoan_Valid() {
        when(loanRepo.save(any(Loan.class))).thenReturn(loan);

        Loan createdLoan = loanService.createLoan(loan);

        assertNotNull(createdLoan);
        assertEquals("PENDING", createdLoan.getStatus());
        verify(loanRepo, times(1)).save(any(Loan.class));
    }

    @Test
    public void testCreateLoan_InvalidAmount() {
        loan.setAmount(-100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> loanService.createLoan(loan));
        assertEquals("Amount must be greater than 0", exception.getMessage());
    }

    @Test
    public void testGetAllLoans() {
        when(loanRepo.findAll()).thenReturn(Arrays.asList(loan));
        List<Loan> loans = loanService.getAllLoans();

        assertEquals(1, loans.size());
        verify(loanRepo).findAll();
    }

    @Test
    public void testGetLoanById_Found() {
        when(loanRepo.findById(1L)).thenReturn(Optional.of(loan));
        Loan foundLoan = loanService.getLoanById(1L);
        assertNotNull(foundLoan);
        assertEquals("John Doe", foundLoan.getApplicantName());
    }

    @Test
    public void testGetLoanById_NotFound() {
        when(loanRepo.findById(1L)).thenReturn(Optional.empty());
        assertThrows(LoanNotFoundException.class, () -> loanService.getLoanById(1L));
    }

    @Test
    public void testUpdateLoanStatus() {
        when(loanRepo.findById(1L)).thenReturn(Optional.of(loan));
        when(loanRepo.save(any(Loan.class))).thenReturn(loan);

        Loan updatedLoan = loanService.updateLoanStatus(1L, "APPROVED");

        assertEquals("APPROVED", updatedLoan.getStatus());
        verify(loanRepo).save(any(Loan.class));
    }

    @Test
    public void testExpireOldPendingLoans() {
        Loan loanOld = new Loan(2L, "Jane Doe", 5000L, 6, "Home", "PENDING", LocalDate.now().minusDays(8));
        when(loanRepo.findAll()).thenReturn(Arrays.asList(loan, loanOld));

        loanService.expireOldPendingLoans();

        verify(loanRepo, times(1)).save(loanOld);
        assertEquals("EXPIRED", loanOld.getStatus());
    }
}