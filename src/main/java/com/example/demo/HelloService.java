package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String concatData(String name) {
        return "Hello " + name;
    }
}
