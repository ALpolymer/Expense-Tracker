package dev.alexpol.expenseTracker.model;
import dev.alexpol.expenseTracker.core.enums.TransactionTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "categories")
public class Category extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String icon;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionTypeEnum tx_type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @Getter(AccessLevel.PROTECTED)
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Transaction> transactions = new HashSet<>();

    public Set<Transaction> getAllTransactions(){
        return Collections.unmodifiableSet(transactions);
    }

    public void addTransaction(Transaction transaction){
        if(transactions == null) transactions = new HashSet<>();
        transactions.add(transaction);
        transaction.setCategory(this);
    }

    public void removeTransaction(Transaction transaction){
        if(transactions == null) return;
        transactions.remove(transaction);
        transaction.setCategory(null);
    }

}
