package org.example.loanms.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.loanms.Enum.LoanStatus;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String applicantName;
    private long amount;
    private int termMonth;
    private String purpose;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    private LocalDate applicationDate;
}
