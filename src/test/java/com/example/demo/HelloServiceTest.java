package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void concatData() {
        // Arrange
        User user = new User("testing");
        when(userRepository.findByName("testing")).thenReturn(Optional.of(user));

        // Act
        HelloService helloService = new HelloService();
        helloService.setUserRepository(userRepository);
        String result = helloService.concatData("testing");

        // Assert
        assertEquals("Hello testing", result);
    }

    @Test
    void saveUser() {
    }

    @Test
    void searchUserJPQL() {
    }

    @Test
    void searchUserNative() {
    }
}