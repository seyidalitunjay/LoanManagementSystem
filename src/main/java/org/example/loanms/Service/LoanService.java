package org.example.loanms.Service;

import org.example.loanms.Model.Loan;
import org.example.loanms.Repo.LoanRepo;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new RuntimeException("Loan Not Found"));
    }

    public Loan updateLoanStatus(Long id, String Status){
        Loan loan = getLoanById(id);
        loan.setStatus(Status);
        return repo.save(loan);
    }

}
