package com.example.repository;

import com.example.domain.Article;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ArticleRepositoryTest {


    @Resource
    private ArticleRepository repository;
    @Test
    void findByContentNotNull() {
        List<Article> byContentNotNull = repository.findByContentNotNull();
        byContentNotNull.forEach(System.out::println);
    }
}