package com.example.demo.users;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {

    private RestTemplate restTemplate;

    @Value("${base_url}")
    private String baseUrl;

    public UserGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserResponse getUserById(int id) {
        UserResponse response = restTemplate.getForObject(
                baseUrl+"users/"+id,
                UserResponse.class);
        return response;
    }

}
