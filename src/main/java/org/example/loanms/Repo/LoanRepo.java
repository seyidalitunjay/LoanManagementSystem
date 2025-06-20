package org.example.loanms.Repo;

import org.example.loanms.Enum.LoanStatus;
import org.example.loanms.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepo extends JpaRepository<Loan, Long> {
    List<Loan> findAllByStatusAndApplicationDateBefore(LoanStatus status, LocalDate date);
}
