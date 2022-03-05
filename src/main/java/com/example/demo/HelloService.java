package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {

    private UserRepository userRepository;

    public HelloService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String concatData(String name) {
        Optional<User> user = userRepository.findByName(name);

        if(user.isEmpty()){
            return "Hello, Who are you?";
        }

        return "Hello " + user.get().getName();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public String searchUserJPQL(int userId) {
        Optional<User> user = userRepository.searchUserByIdJPQL(userId);

        if(user.isEmpty()){
            return "Hello, Who are you?";
        }

        return "Hello id - " + user.get().getId();
    }

    public String searchUserNative(String userId) {
        Optional<User> user = userRepository.searchUserByIdNative(userId);

        if(user.isEmpty()){
            return "Hello, Who are you?";
        }

        return "Hello id:" + user.get().getId();
    }
}
