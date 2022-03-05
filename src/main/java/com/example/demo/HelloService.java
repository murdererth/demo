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

        if(user.isPresent()){
            return "Hello " + user.get().getName();
        }

        throw new UserNotFoundException(name);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public String searchUserJPQL(int userId) {
        Optional<User> user = userRepository.searchUserByIdJPQL(userId);

        if(user.isPresent()){
            return "Hello id:" + user.get().getId();
        }

        throw new UserNotFoundException(String.valueOf(userId));
    }

    public String searchUserNative(String userId) {
        Optional<User> user = userRepository.searchUserByIdNative(userId);

        if(user.isPresent()){
            return "Hello id:" + user.get().getId();
        }

        throw new UserNotFoundException(userId);
    }
}
