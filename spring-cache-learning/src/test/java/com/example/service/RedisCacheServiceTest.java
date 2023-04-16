package com.example.service;

import com.example.entity.User;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class RedisCacheServiceTest {

    @Resource
    private RedisCacheService service;

    @Test
    void getName(){
        String s1 = service.getName(1);
        String s2 = service.getName(1);
        String s3 = service.getName(1);
        log.info(String.valueOf(s1==s2));
        log.info(String.valueOf(s2==s3));
    }

    @Test
    void getUser(){
        User user1 = service.getUser(1);
        User user2 =service.getUser(1);
        User user3 =service.getUser(1);
        log.info(String.valueOf(user1==user2));
        log.info(String.valueOf(user2==user3));
    }
}