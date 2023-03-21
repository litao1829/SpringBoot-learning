package com.example.controller;


import com.example.domain.Article;
import com.example.repository.ArticleRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Resource
    private ArticleRepository articleRepository;

    @GetMapping("/article")
    public String article(ModelMap map)
    {
        List<Article> byContentNotNull = articleRepository.findByContentNotNull();
        map.put("articles",byContentNotNull);
        return "index";
    }
}
