package com.example.demo.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private UserGateway userGateway;

    public DemoController(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @GetMapping("/call/{id}")
    public UserResponse callUserAPI(@PathVariable("id") int userId) {
        return userGateway.getUserById(userId);
    }
}
