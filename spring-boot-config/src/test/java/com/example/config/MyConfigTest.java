package com.example.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MyConfigTest {

    @Autowired
    private MyConfig myConfig;

    @Test
    public void myconfigtest(){
        myConfig.myService().say();
    }
}