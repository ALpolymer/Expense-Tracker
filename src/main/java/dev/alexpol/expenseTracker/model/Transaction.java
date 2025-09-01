package dev.alexpol.expenseTracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "budget")
public class Transaction extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, precision = 19, scale = 2)
    @NotNull(message = "Total amount is required")
    @Positive(message = "Total amount must be positive")
    @DecimalMin(value = "0.01", message = "Total amount must be at least 0.01")
    private BigDecimal amount;

    private String note;
}
