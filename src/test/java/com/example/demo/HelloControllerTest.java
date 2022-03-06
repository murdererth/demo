package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// จะไม่ชน 8080
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("send name = B1 & message should be Hello B1")
    void sayHi_case01() {
        // Arrange
        User user = new User("testing");
        when(userRepository.findByName("testing")).thenReturn(Optional.of(user));

        // Act
        HelloResponse result = testRestTemplate.getForObject("/hello/testing",
                HelloResponse.class);

        // Assert, Verify
        assertEquals("Hello testing", result.getMessage());
    }

//    @Test
//    @DisplayName("send name = other & message should be User other not found")
//    void sayHi_case02() {
//        // Act
//        HelloResponse result = testRestTemplate.getForObject("/hello/other",
//                HelloResponse.class);
//
//        // Assert, Verify
//        assertEquals("User other not found!", result.getMessage());
//    }

    @Test
    void sayHi2() {
    }

    @Test
    void sayHi3() {
    }
}
