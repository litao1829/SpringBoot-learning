package com.example.mapper;

import com.example.domain.Clazz;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClazzMapperTest {

    @Resource
    private ClazzMapper clazzMapper;
    @Test
    void selectOneToMany() {
        Clazz clazz = clazzMapper.selectOneToMany(1);
        System.out.println(clazz);
    }

    @Test
    void selectOneToOne() {
        Clazz clazz = clazzMapper.selectOneToOne(1);
        System.out.println(clazz);
    }
}