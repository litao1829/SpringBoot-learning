package com.example.service;

import com.example.domain.Article;
import com.example.enums.ExceptionType;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExceptionService {

    public Article findById(int id){
        List<Article> articles = List.of(
                new Article(0, "Spring从入门到精通","大佬", LocalDateTime.of(2023,03,29,22,30,23)),
                new Article(1, "Vue从入门到精通","大牛", LocalDateTime.of(2023,03,29,22,30,23)),
                new Article(2, "java从入门到精通","大神", LocalDateTime.of(2023,03,20,22,30,23)));
       if(id>2){
           throw new CustomException(ExceptionType.SYSTEM_ERROR);
       }
       else if(id<0){
           throw new CustomException(ExceptionType.PARAM_ERROT);
       }
       Article article1 = articles.stream().filter(article -> article.getId() == id).toList().get(0);
       return article1;
    }
}
