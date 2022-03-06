package com.example.demo.tx;

import com.example.demo.User;
import com.example.demo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoTxService {

    private UserRepository userRepository;

    public DemoTxService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void callRepository() {

        User user1 = new User("User 1");
        User user2 = new User("User 2");
        User user3 = new User("User 3");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
