package com.example.practice.learning.di;

import com.example.practice.learning.di.autowire.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TestDI {

  @Autowired
  TestDIViaInjection testDIViaInjection;

  @Autowired
  TestAutoWire autoWire;

  @Autowired
  @Qualifier("testingAutowireWithQualifier1")
    Autowire autowire;

    public void testing(){
        autowire.test();
        autoWire.test();

        testDIViaInjection.inject();

        System.out.println("Testing DI");
    }


}
