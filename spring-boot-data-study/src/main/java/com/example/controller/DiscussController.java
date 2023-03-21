package com.example.controller;


import com.example.domain.Article;
import com.example.domain.Discuss;
import com.example.repository.ArticleRepository;
import com.example.repository.DiscussRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class DiscussController {

    @Resource
    private DiscussRepository discussRepository;

    @Resource
    private ArticleRepository articleRepository;
//    返回页面
    @GetMapping("/discuss")
    public String getDiscuss(Integer id,ModelMap map){
        List<Discuss> byAIdEquals = discussRepository.findByAIdEquals(id);
        Article article = articleRepository.findById(id).get();
        map.put("discusses",byAIdEquals);
        map.put("article",article);
        return "discuss";
    }
}
