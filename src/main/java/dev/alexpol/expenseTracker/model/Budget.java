package dev.alexpol.expenseTracker.model;

import dev.alexpol.expenseTracker.core.enums.CurrenciesEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "budget")
public class Budget extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Budget title is required")
    @Size(max = 50, message = "Budget title  must not exceed 50 characters")
    private String title;

    @Enumerated(EnumType.STRING)
    private CurrenciesEnum currency;

}
