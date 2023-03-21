package com.example.controller;

import com.example.domain.Student;
import com.example.mapper.StudentMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Resource
    private StudentMapper studentMapper;

    @GetMapping("/student")
    public Student getStudent(Integer id){
        Student student = studentMapper.ManyToMany(id);
        return student;
    }
}
