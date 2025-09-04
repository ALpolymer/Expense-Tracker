package dev.alexpol.expenseTracker.model;
import dev.alexpol.expenseTracker.core.enums.RolesEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Enumerated(EnumType.STRING)
    private RolesEnum role;

    @ColumnDefault("true")
    private Boolean active = true;

    @Getter(AccessLevel.PROTECTED)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Budget> budgets = new HashSet<>();

    public Set<Budget> getAllBudgets(){
        return Collections.unmodifiableSet(budgets);
    }

    public void addBudget(Budget budget){
        if(budgets == null) budgets = new HashSet<>();
        budgets.add(budget);
        budget.setUser(this);
    }

    public void removeBudget(Budget budget){
        if(budgets==null) return;
        budgets.remove(budget);
        budget.setUser(null);
    }
}
