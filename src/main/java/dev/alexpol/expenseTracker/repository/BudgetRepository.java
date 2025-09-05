package dev.alexpol.expenseTracker.repository;
import dev.alexpol.expenseTracker.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Optional;


public interface BudgetRepository extends JpaRepository<Budget, Long >,
        JpaSpecificationExecutor<Budget> {
    Optional<Budget> findByTitle(String title);
}
