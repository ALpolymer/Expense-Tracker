package dev.alexpol.expenseTracker.repository;

import dev.alexpol.expenseTracker.model.Category;
import dev.alexpol.expenseTracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransactionRepository extends JpaRepository<Transaction, Long>,
        JpaSpecificationExecutor<Category> {

}
