package org.example.loanms.Service;

import org.example.loanms.Enum.LoanStatus;
import org.example.loanms.Exceptions.LoanValidationException;
import org.example.loanms.Model.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanValidator {

    private static final long MIN_LOAN_AMOUNT = 1000L;
    private static final int MIN_LOAN_TERM = 1;
    private static final int MAX_LOAN_TERM = 60;

    public void validateLoanCreation(Loan loan) {
        if (loan.getAmount() < MIN_LOAN_AMOUNT) {
            throw new LoanValidationException(
                    "Loan amount must be at least " + MIN_LOAN_AMOUNT);
        }

        if (loan.getTermMonth() < MIN_LOAN_TERM || loan.getTermMonth() > MAX_LOAN_TERM) {
            throw new LoanValidationException(
                    "Loan term must be between " + MIN_LOAN_TERM + " and " + MAX_LOAN_TERM + " months");
        }

        if (loan.getApplicantName() == null || loan.getApplicantName().trim().isEmpty()) {
            throw new LoanValidationException("Applicant name is required");
        }

        if (loan.getPurpose() == null || loan.getPurpose().trim().isEmpty()) {
            throw new LoanValidationException("Loan purpose is required");
        }
    }

    public void validateStatusTransition(LoanStatus currentStatus, LoanStatus newStatus) {
        if (currentStatus == null) {
            throw new LoanValidationException("Current status cannot be null");
        }

        if (currentStatus.isTerminalStatus()) {
            throw new LoanValidationException(
                    "Cannot change status from terminal status: " + currentStatus);
        }

        if (!LoanStatus.isValidTransition(currentStatus, newStatus)) {
            throw new LoanValidationException(
                    "Invalid status transition from " + currentStatus + " to " + newStatus);
        }
    }
}
