package dev.alexpol.expenseTracker.repository;

import dev.alexpol.expenseTracker.core.enums.CurrenciesEnum;
import dev.alexpol.expenseTracker.core.enums.RolesEnum;
import dev.alexpol.expenseTracker.model.Budget;
import dev.alexpol.expenseTracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BudgetRepositoryTest {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private UserRepository userRepository;

    private User testUser;
    private Budget existingBudget;


    private void createTestData(){
        testUser = new User();
        testUser.setUsername("test_user");
        testUser.setEmail("test@example.com");
        testUser.setPassword("secret");
        testUser.setFirstname("Γιάννης");
        testUser.setLastname("Παπαδόπουλος");
        testUser.setRole(RolesEnum.USER);
        testUser.setActive(true);
        userRepository.save(testUser);

        existingBudget = new Budget();
        existingBudget.setTitle("Monthly Budget");
        existingBudget.setCurrency(CurrenciesEnum.EUR);
    }
}