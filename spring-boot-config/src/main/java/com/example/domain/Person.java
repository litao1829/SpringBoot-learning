package com.example.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

//这个注解会类让容器帮助我们注入
@Component
@ConfigurationProperties(prefix = "person")
//@ConfigurationProperties：批量注入
@Data
public class Person {
    private Integer id;
    private String name;
    private List<String> hobby;

    private String[] family;

    private Map<String, Object> map;

    private Pet pet;
}
