package org.example.loanms.Controller;

import org.example.loanms.Enum.LoanStatus;
import org.example.loanms.Model.Loan;
import org.example.loanms.Service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        return ResponseEntity.ok(loanService.createLoan(loan));
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.getLoanById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Loan> updateLoanStatus(
            @PathVariable Long id,
            @RequestParam LoanStatus status) {
        return ResponseEntity.ok(loanService.updateLoanStatus(id, status));
    }
}