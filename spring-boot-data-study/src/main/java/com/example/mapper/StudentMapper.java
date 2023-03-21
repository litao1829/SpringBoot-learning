package com.example.mapper;

import com.example.domain.Student;
import com.example.domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
        List<Student> selectByClazzId(int clazzId);

        Student ManyToMany(int studentId);



        //新增学生
        @Insert("INSERT INTO t_student values (#{studentId},#{clazzId},#{studentName},#{hometown},#{birthday})")
        int insetStudent(Student student);

        //根据studentId修删除学生
        @Delete("DELETE FROM t_student where student_id=#{studentId}")
        int deleteStudent(Integer studentId);

        //修改学生信息
        @Update("UPDATE t_student SET student_name=#{studentName},clazz_id=#{clazzId}," +
                " hometown=#{hometown},birthday=#{birthday} WHERE student_id=#{studentId}")
        int updateStudent(Student student);

        //根据studentId查找学生
        @Select("SELECT * FROM t_student WHERE student_id=#{studentId}")
        Student selectByStudentId(int studentId);

        //批量注入学生
        int batchInsert(@Param("students") List<Student> students);


        //批量修改学生
        int batchUpdate(@Param("students") List<Student> students);



        //批量删除学生
        int batchDelet(@Param("studentIds") List<Integer> studentIds);



        //动态查询
        List<Student> dynamicSelect(Student student);
}
