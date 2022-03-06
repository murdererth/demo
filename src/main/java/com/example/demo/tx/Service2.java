package com.example.demo.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Service2 {

    private Service3 service3;

    public Service2(Service3 service3) {
        this.service3 = service3;
    }

    @Transactional
    public void doSth() {
        service3.doSth();
    }
}
