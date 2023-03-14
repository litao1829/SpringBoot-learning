package com.example.config;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DBDevConfig implements DBConfig{
    @Override
    public String configure() {
        return "dev环境部署";
    }
}
