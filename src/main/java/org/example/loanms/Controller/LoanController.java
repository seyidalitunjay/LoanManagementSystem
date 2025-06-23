package org.example.loanms.Controller;

import org.example.loanms.Enum.LoanStatus;
import org.example.loanms.Model.Loan;
import org.example.loanms.Service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return service.createLoan(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return service.getLoanById(id);
    }

    @PutMapping("/{id}/status")
    public Loan updateLoanStatus(@PathVariable Long id, @RequestParam LoanStatus status) {
        return service.updateLoanStatus(id, status);
    }
}
