package org.example.loanms.Enum;

public enum LoanStatus {
    PENDING("Pending approval"),
    APPROVED("Loan approved"),
    REJECTED("Loan rejected"),
    EXPIRED("Loan expired (pending too long)"),
    ACTIVE("Loan is active and being paid"),
    COMPLETED("Loan fully repaid"),
    DEFAULTED("Loan payments not made");

    private final String description;

    LoanStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isTerminalStatus() {
        return this == REJECTED || this == EXPIRED || this == COMPLETED || this == DEFAULTED;
    }

    public static boolean isPending(LoanStatus status) {
        return status == PENDING;
    }

    public static boolean isValidTransition(LoanStatus current, LoanStatus newStatus) {
        if (current == null) return true; // initial status
        if (current.isTerminalStatus()) return false; // can't change from terminal statuses

        switch (current) {
            case PENDING:
                return newStatus == APPROVED || newStatus == REJECTED || newStatus == EXPIRED;
            case APPROVED:
                return newStatus == ACTIVE || newStatus == REJECTED;
            case ACTIVE:
                return newStatus == COMPLETED || newStatus == DEFAULTED;
            default:
                return false;
        }
    }
}