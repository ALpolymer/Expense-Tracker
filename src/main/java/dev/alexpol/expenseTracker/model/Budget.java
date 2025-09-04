package dev.alexpol.expenseTracker.model;
import dev.alexpol.expenseTracker.core.enums.CurrenciesEnum;
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
@Table(name = "budgets")
public class Budget extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private CurrenciesEnum currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User user;

    @Getter(AccessLevel.PROTECTED)
    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL)
    private Set<Transaction> transactions = new HashSet<>();

    @Getter(AccessLevel.PROTECTED)
    @OneToMany(mappedBy = "budget")
    private Set<Category> categories = new HashSet<>();


    public Set<Transaction> getAllTransactions(){
        return Collections.unmodifiableSet(transactions);
    }

    public void addTransaction(Transaction transaction){
        if(transactions== null) transactions = new HashSet<>();
        transactions.add(transaction);
        transaction.setBudget(this);
    }

    public void removeTransaction(Transaction transaction){
        if(transactions == null) return;
        transactions.remove(transaction);
        transaction.setBudget(null);
    }

        public Set<Category> getAllCategories(){
        return Collections.unmodifiableSet(categories);
    }

    public void addCategory(Category category){
        if(categories == null)  categories = new HashSet<>();
        categories.add(category);
        category.setBudget(this);
    }

    public void removeCategory(Category category){
        if(categories == null) return;
        categories.remove(category);
        category.setBudget(null);
    }
}


