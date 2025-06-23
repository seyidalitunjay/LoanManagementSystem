package org.example.loanms.Service;

import org.example.loanms.Enum.LoanStatus;
import org.example.loanms.Exceptions.LoanNotFoundException;
import org.example.loanms.Exceptions.LoanValidationException;
import org.example.loanms.Model.Loan;
import org.example.loanms.Repo.LoanRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {
    private static final int PENDING_EXPIRATION_DAYS = 7;
    private static final long MIN_LOAN_AMOUNT = 1000L;
    private static final int MIN_LOAN_TERM = 1;
    private static final int MAX_LOAN_TERM = 60;

    private final LoanRepo loanRepo;
    private final LoanValidator loanValidator;

    public LoanService(LoanRepo loanRepo, LoanValidator loanValidator) {
        this.loanRepo = loanRepo;
        this.loanValidator = loanValidator;
    }

    @Transactional
    public Loan createLoan(Loan loan) {
        loanValidator.validateLoanCreation(loan);
        loan.setStatus(LoanStatus.PENDING);
        loan.setApplicationDate(LocalDate.now());
        return loanRepo.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepo.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan with ID " + id + " not found"));
    }

    @Transactional
    public Loan updateLoanStatus(Long id, LoanStatus newStatus) {
        Loan loan = getLoanById(id);
        loanValidator.validateStatusTransition(loan.getStatus(), newStatus);

        loan.setStatus(newStatus);
        return loanRepo.save(loan);
    }

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void processPendingLoanExpirations() {
        LocalDate expirationThreshold = LocalDate.now().minusDays(PENDING_EXPIRATION_DAYS);
        List<Loan> expiredLoans = loanRepo.findAllByStatusAndApplicationDateBefore(
                LoanStatus.PENDING, expirationThreshold);

        expiredLoans.forEach(loan -> {
            loan.setStatus(LoanStatus.EXPIRED);
            loanRepo.save(loan);
        });
    }
}