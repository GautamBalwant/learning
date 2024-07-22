package com.example.practice.learning.di.autowire;

import org.springframework.stereotype.Component;

@Component
public class TestingAutowireWithQualifier2 implements Autowire{
    @Override
    public void test() {
        System.out.println("TestingAutowireWithQualifier2");
    }
}
