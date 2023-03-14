package com.example.config;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class DBTestConfig implements DBConfig{
    @Override
    public String configure() {
        return "test环境部署";
    }
}
