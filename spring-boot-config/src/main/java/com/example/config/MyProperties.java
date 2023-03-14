package com.example.config;


import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration//标注此类为配置类
@PropertySource("classpath:my.properties")//指定自定义配置文件的路径和名称
@ConfigurationProperties(prefix = "my")//需要指定前缀，此注解需要setter方法
@Setter
@ToString
public class MyProperties {
    private String username;
    private String url;
    private String password;
}
