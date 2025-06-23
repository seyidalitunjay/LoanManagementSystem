package org.example.loanms.Service;

import org.example.loanms.Enum.LoanStatus;
import org.example.loanms.Exceptions.LoanNotFoundException;
import org.example.loanms.Model.Loan;
import org.example.loanms.Repo.LoanRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {
    private static final int PENDING_EXPIRATION_DAYS = 7;

    private final LoanRepo repo;

    public LoanService(LoanRepo repo) {
        this.repo = repo;
    }

    private void validateLoan(Loan loan) {
        if (loan.getAmount() <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than 0");
        }
    }

    public Loan createLoan(Loan loan) {
        validateLoan(loan);
        loan.setStatus(LoanStatus.PENDING);
        loan.setApplicationDate(LocalDate.now());
        return repo.save(loan);
    }

    public List<Loan> getAllLoans() {
        return repo.findAll();
    }

    public Loan getLoanById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan with ID " + id + " not found"));
    }

    public Loan updateLoanStatus(Long id, LoanStatus newStatus) {
        Loan loan = getLoanById(id);

        if (!LoanStatus.isValidTransition(loan.getStatus(), newStatus)) {
            throw new IllegalStateException("Invalid status transition from " +
                    loan.getStatus() + " to " + newStatus);
        }

        loan.setStatus(newStatus);
        return repo.save(loan);
    }

    @Scheduled(cron = "0 0 0 * * *") // Runs daily at midnight
    public void processPendingLoanExpirations() {
        LocalDate expirationThreshold = LocalDate.now().minusDays(PENDING_EXPIRATION_DAYS);

        repo.findAllByStatusAndApplicationDateBefore(LoanStatus.PENDING, expirationThreshold)
                .forEach(loan -> {
                    loan.setStatus(LoanStatus.EXPIRED);
                    repo.save(loan);
                    // In production, you might want to add logging here
                });
    }
}