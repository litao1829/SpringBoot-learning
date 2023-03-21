package com.example.mapper;

import com.example.domain.Teacher;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherMapperTest {

    @Resource
    private TeacherMapper teamapper;

    @Test
    void selectOneByOne() {
        Teacher teacher = teamapper.selectOneByOne(1);
        System.out.println(teacher);
    }

    @Test
    void insetTeacher(){
        Teacher teacher=Teacher.builder()
                .teacherId(3)
                .teacherName("张三")
                .clazzId(3).build();
        int i = teamapper.insetTeacher(teacher);
        System.out.println(i);
    }

    @Test
    void deleteTeacher() {
        int i = teamapper.deleteTeacher(3);
        System.out.println(i);
    }

    @Test
    void updateTeacher() {
        Teacher teacher=Teacher.builder()
                .teacherId(3)
                .teacherName("李四")
                .clazzId(3).build();
        int i = teamapper.updateTeacher(teacher);
        System.out.println(i);
    }

    @Test
    void selectByTeacherId() {
        Teacher teacher = teamapper.selectByTeacherId(3);
        System.out.println(teacher);
    }
}