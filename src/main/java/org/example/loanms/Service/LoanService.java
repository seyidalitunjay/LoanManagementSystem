package org.example.loanms.Service;

import org.example.loanms.Exceptions.LoanNotFoundException;
import org.example.loanms.Model.Loan;
import org.example.loanms.Repo.LoanRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepo repo;

    public LoanService(LoanRepo repo) {
        this.repo = repo;
    }

    private void validateLoan(Loan loan) {
        if (loan.getAmount() < 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }

    public Loan createLoan(Loan loan) {
        validateLoan(loan);
        loan.setStatus("PENDING");
        return repo.save(loan);
    }

    public List<Loan> getAllLoans(){
        return repo.findAll();
    }

    public Loan getLoanById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan with ID " + id + " not found"));
    }

    public Loan updateLoanStatus(Long id, String Status){
        Loan loan = getLoanById(id);
        loan.setStatus(Status);
        return repo.save(loan);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void expireOldPendingLoans() {
        System.out.println("[SCHEDULER] Running scheduled check...");

        List<Loan> allLoans = repo.findAll();
        LocalDate now = LocalDate.now();

        for (Loan loan : allLoans) {
            if ("PENDING".equalsIgnoreCase(loan.getStatus()) &&
                    loan.getApplicationDate() != null &&
                    loan.getApplicationDate().isBefore(now.minusDays(7))) {

                loan.setStatus("EXPIRED");
                repo.save(loan);
                System.out.println("[SCHEDULER] Loan ID " + loan.getId() + " marked as EXPIRED.");
            }
        }
    }

}
