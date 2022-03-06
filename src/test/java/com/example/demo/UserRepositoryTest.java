package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("find by name with success")
    void findByName_case1() {
        // Arrange
        userRepository.save(new User("toto"));

        // Act
        Optional<User> result = userRepository.findByName("toto");
        // Assert
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("find by name with failure")
    void findByName_case2() {
        // Act
        Optional<User> result = userRepository.findByName("toto");
        // Assert
        assertTrue(result.isPresent());
    }

    @Test
    void searchUserByIdJPQL() {
    }

    @Test
    void searchUserByIdNative() {
    }
}