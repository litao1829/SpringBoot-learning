package com.example.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyPropertiesTest {


    @Autowired
    private MyProperties myProperties;

    @Test
    public void mytest(){
        System.out.println(myProperties);
    }
}