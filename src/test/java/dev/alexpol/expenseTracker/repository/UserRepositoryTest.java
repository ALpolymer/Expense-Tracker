package dev.alexpol.expenseTracker.repository;

import dev.alexpol.expenseTracker.core.enums.RolesEnum;
import dev.alexpol.expenseTracker.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Autowired
    UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User existingUser = new User();

    @BeforeEach
    public void setup(){
        createDummyData();
    }

    @Test
    void persistAndGetUser(){
        User user = new User();
        user.setUsername("NewUser123");  // ← ΔΙΑΦΟΡΕΤΙΚΟ username
        user.setEmail("newuser@gmail.com");  // ← ΔΙΑΦΟΡΕΤΙΚΟ email
        user.setPassword("secret");
        user.setFirstname("Κώστας");
        user.setLastname("Παπαδόπουλος");
        user.setRole(RolesEnum.USER);
        user.setActive(true);
        userRepository.save(user);

        Optional<User> savedUser = userRepository.findByUsername("NewUser123");
        assertTrue(savedUser.isPresent());
        assertEquals("NewUser123", savedUser.get().getUsername());
        assertEquals("newuser@gmail.com", savedUser.get().getEmail());
    }

    @Test
    void updateUser(){
        User userToUpdate = userRepository.findById(existingUser.getId()).orElseThrow();

        userToUpdate.setFirstname("Νίκος");
        userToUpdate.setActive(false);

        userRepository.save(userToUpdate);

        User updatedUser = userRepository.findById(existingUser.getId()).orElseThrow();

        assertEquals("Νίκος", updatedUser.getFirstname());
        assertFalse(updatedUser.getActive());
    }

    @Test
    void deleteUser(){
        userRepository.deleteById(existingUser.getId());

        Optional<User> deletedUser = userRepository.findById(existingUser.getId());

        assertTrue(deletedUser.isEmpty());
    }


    @Test
    void getUserByIdPositive(){
        User user = userRepository.findById(existingUser.getId()).orElse(null);
        assertNotNull(user);
        assertEquals("Παπαδόπουλος", user.getLastname());
    }

    @Test
    void getUserByIdNegative(){
        User user = userRepository.findById(888L).orElse(null);
        assertNull(user);
    }

    private void createDummyData(){
        existingUser = new User();
        existingUser.setUsername("Elalek");
        existingUser.setEmail("Kosta12@gmail.com");
        existingUser.setPassword("secret");
        existingUser.setFirstname("Κώστας");
        existingUser.setLastname("Παπαδόπουλος");
        existingUser.setRole(RolesEnum.USER);
        existingUser.setActive(true);
        userRepository.save(existingUser);
    }

}