package com.example.mapper;

import com.example.domain.Student;
import com.example.domain.Teacher;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentMapperTest {

    @Resource
    private StudentMapper studentMapper;
    @Test
    void selectByClazzId() {
        List<Student> students = studentMapper.selectByClazzId(1);
        students.forEach(System.out::println);
    }

    @Test
    void batchInsert() {
        List<Student> students=new ArrayList<>();
        for (int i=0;i<100;i++)
        {
            Student student=Student.builder()
                    .studentId(3000+i)
                    .studentName("测试"+i)
                    .clazzId(1)
                    .hometown("南京")
                    .birthday(LocalDate.of(2002,10,10)).build();
            students.add(student);
        }
        int count = studentMapper.batchInsert(students);
        System.out.println(count);
    }

    @Test
    void batchUpdate() {
        List<Student> students=new ArrayList<>();
        for (int i=0;i<50;i++)
        {
            Student student=Student.builder()
                    .studentId(3000+i)
                    .studentName("在修改"+i)
                    .clazzId(1)
                    .hometown("苏州").build();
            students.add(student);
        }
        System.out.println(students.size());
        int i = studentMapper.batchUpdate(students);
        System.out.println(i);
    }

    @Test
    void insetStudent() {
        Student student=Student.builder()
                .studentId(100)
                .clazzId(1)
                .studentName("李四")
                .hometown("无锡")
                .birthday(LocalDate.of(2001,07,12))
                .build();
        int i = studentMapper.insetStudent(student);
        System.out.println(i);
    }

    @Test
    void deleteStudent() {
        int i = studentMapper.deleteStudent(100);
        System.out.println(i);
    }

    @Test
    void updateStudent() {
        Student student=Student.builder()
                .studentId(100)
                .clazzId(1)
                .studentName("李四111")
                .hometown("无锡")
                .birthday(LocalDate.of(2001,07,12))
                .build();
        int i = studentMapper.updateStudent(student);
        System.out.println(i);
    }

    @Test
    void selectByStudentId() {
        Student student = studentMapper.selectByStudentId(100);
        System.out.println(student);
    }

    @Test
    void batchDelet() {
        List<Integer> idList=List.of(3000,3001,3002,3003);
        int i = studentMapper.batchDelet(idList);
        System.out.println(i);
    }

    @Test
    void dynamicSelect() {
        Student student=Student.builder()
                .hometown("州")
                .build();
        List<Student> students = studentMapper.dynamicSelect(student);
        students.forEach(s->{
            System.out.println(s.getClazzId()+","+s.getStudentName()+","+s.getHometown()+","+
                    s.getBirthday());
        });
    }

    @Test
    void manyToMany() {
        Student student = studentMapper.ManyToMany(1001);
        System.out.println(student);
        Teacher teacher = student.getClazz().getTeacher();
        System.out.println(teacher);
    }
}