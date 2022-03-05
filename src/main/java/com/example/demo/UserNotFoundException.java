package com.example.demo;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String name) {
        super(name);
    }
}
