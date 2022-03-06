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

    public void callRepository() {
        step1();
        step2();
        processLongRunning();
    }

    private void processLongRunning() {
    }

    @Transactional
    public void step1() {
        User user1 = new User("User 1");
        User user2 = new User("User 2");
        User user3 = new User("User 3");

        // transaction 1
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);


    }

    @Transactional
    public void step2() {
        User user3 = new User("User 3");

        // transaction 2
        userRepository.save(user3);
        userRepository.save(user3);
        userRepository.save(user3);
    }
}
