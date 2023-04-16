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
class AnnotationUserServiceTest {

    @Resource
    private AnnotationUserService annotationservice;

    @Test
    void test1(){
        User user1 = annotationservice.getById(1);
        User user2 = annotationservice.getById(1);

        log.info(String.valueOf(user1==user2));
    }

    @Test
    void testUpdate(){
        User user1 = annotationservice.getById(1);
        user1.setName("mybatis test");
        annotationservice.update(user1);
        User user2 = annotationservice.getById(1);
        log.info(String.valueOf(user1 == user2));
    }


    @Test
    void testDelete(){
        User user1 = annotationservice.getById(1);
        User user2 = annotationservice.getById(1);
        log.info(String.valueOf(user1 == user2));
        annotationservice.deleteById(1);
        User user3 = annotationservice.getById(1);
        log.info(String.valueOf(user1 == user3));
    }

    @Test
    void testDeleteAll(){
        List<User> list1 = annotationservice.findAll();
        List<User> list2 = annotationservice.findAll();
        log.info(String.valueOf(list1 == list2));
        annotationservice.deleteAll();
        List<User> list3 = annotationservice.findAll();
        log.info(String.valueOf(list1 == list3));
    }
}