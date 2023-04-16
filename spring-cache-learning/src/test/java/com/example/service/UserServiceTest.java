package com.example.service;

import com.example.entity.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Resource
    private  UserService service;

    @Test
    void getById() {
        System.out.println(service.getById(1));
    }

    @Test
    void findAll() {
        List<User> all = service.findAll();

        all.forEach(System.out::println);
    }

    @Test
    void findAllByNameLike() {
        List<User> list = service.findAllByNameLike("丰");
        list.forEach(System.out::println);
    }
}