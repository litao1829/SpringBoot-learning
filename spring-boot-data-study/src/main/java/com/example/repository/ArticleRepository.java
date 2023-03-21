package com.example.repository;

import com.example.domain.Article;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


public interface ArticleRepository extends Repository<Article,Integer> {
    List<Article> findByContentNotNull();
    Optional<Article> findById(Integer id);
}
