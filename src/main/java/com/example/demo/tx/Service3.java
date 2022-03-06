package com.example.demo.tx;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class Service3 {

    @Transactional
    public void doSth() {

    }
}
