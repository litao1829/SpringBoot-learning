package com.example.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonTest {
@Autowired
    private Person person;



@Test
    public void testperson(){
    System.out.println(person);

}

}