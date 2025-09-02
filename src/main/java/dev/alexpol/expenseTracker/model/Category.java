package dev.alexpol.expenseTracker.model;

import dev.alexpol.expenseTracker.core.enums.TransactionTypeEnum;
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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "title of category is required")
    @Size(max = 50, message = "category title  must not exceed 50 characters")
    private String title;

    private String icon;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionTypeEnum tx_type;

}
