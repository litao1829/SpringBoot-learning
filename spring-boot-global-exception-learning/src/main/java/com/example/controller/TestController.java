package com.example.controller;

import com.example.auth.CheckAuth;
import com.example.domain.Article;
import com.example.service.ExceptionService;
import com.example.util.AjaxResponse;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @Resource
    private ExceptionService service;

    @GetMapping("/article/{id}")
    @CheckAuth("Admin123")
    public AjaxResponse getArticle(@PathVariable("id") int id){

        return AjaxResponse.success(service.findById(id));
    }


    @GetMapping("/articles")
    public AjaxResponse saveArticle(@Valid @RequestBody Article article){

        return AjaxResponse.success(article);
    }

}
