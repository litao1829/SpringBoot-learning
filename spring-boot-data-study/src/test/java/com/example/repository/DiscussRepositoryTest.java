package com.example.repository;

import com.example.domain.Discuss;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiscussRepositoryTest {


    @Resource
    private DiscussRepository discussRepository;
    @Test
    void findByAuthorNotNull() {
        List<Discuss> authorNotNull = discussRepository.findByAuthorNotNull();
        authorNotNull.forEach(System.out::println);
    }

    @Test
    void findByAuthorEquals() {
        List<Discuss> discuss = discussRepository.findByAuthorEquals("张三");
        discuss.forEach(System.out::println);
    }

    @Test
    public void test1(){
        Optional<Discuss> byId = discussRepository.findById(1);
        byId.ifPresent(System.out::println);
    }

    @Test
    void getDiscussByPage() {
        Pageable pageable= PageRequest.of(1,2);
        List<Discuss> discussByPage = discussRepository.getDiscussByPage(pageable);
        discussByPage.forEach(System.out::println);
    }

    @Test
    void findByAIdEquals() {
        List<Discuss> byAIdEquals = discussRepository.findByAIdEquals(1);
        byAIdEquals.forEach(System.out::println);
    }


}