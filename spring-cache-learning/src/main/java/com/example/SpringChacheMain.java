package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper"})
@EnableCaching
public class SpringChacheMain {
    public static void main(String[] args) {

        SpringApplication.run(SpringChacheMain.class,args);
    }
}