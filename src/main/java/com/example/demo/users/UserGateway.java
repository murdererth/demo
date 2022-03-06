package com.example.demo.users;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {

    private RestTemplate restTemplate;

    public UserGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserResponse getUserById(int id) {
        UserResponse response = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/users/"+id,
                UserResponse.class);
        return response;
    }

}
