package com.example.service;


import com.example.config.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBConfigService {
    @Autowired
    private DBConfig dbConfig;
    @GetMapping("/hello")
    @ResponseBody
    public String say(){
        return dbConfig.configure();
    }
}
