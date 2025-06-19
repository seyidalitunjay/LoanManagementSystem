package org.example.loanms.Repo;

import org.example.loanms.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo extends JpaRepository<Loan, Long> {
}
