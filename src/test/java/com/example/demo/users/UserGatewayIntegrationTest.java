package com.example.demo.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserGatewayIntegrationTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    void getUserById() {
        // Act
        UserResponse result = userGateway.getUserById(9);

        // Assert
        assertEquals(9,result.getId());
        assertEquals("Glenna Reichert",result.getName());
    }
}