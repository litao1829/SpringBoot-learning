package com.example.service;

import com.example.entity.User;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class CachedUserServiceTest {

    @Resource
    private UserService userService;
    @Resource
    private CachedUserService cacheservice;


    @Test
    void test1() {
        User user1 = userService.getById(1);
        User user2 = userService.getById(1);
        log.info(String.valueOf(user1==user2));
    }

    @Test
    void test2(){
        User user1 = cacheservice.getById(1);
        User user2 = cacheservice.getById(1);
        log.info(String.valueOf(user1==user2));
    }

    @Test
    void test3(){
        List<User> list1 = cacheservice.findAll();
        List<User> list2 = cacheservice.findAll();
        log.info(String.valueOf(list1==list2));
    }


    @Test
    void test4(){
        List<User> list1 = cacheservice.findAllByNameLike("张");
        List<User> list2 = cacheservice.findAllByNameLike("张");
        log.info(String.valueOf(list1==list2));
    }
}