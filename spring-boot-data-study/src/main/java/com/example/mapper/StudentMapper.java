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


        //模糊查询使用concat
        List<Student> queryLike(Student student);


        //choose标签：choose标签搭配when和otherwise标签使用
        //当一个when中的条件满足时，choose结束，如果没有满足的则执行otherwise中的。
        //当多条when满足时，从上到下选择一个。
        List<Student> getStudentListChoose(Student student);

        //插入对象的生成主键,生成的主键会自动给传入的参数对象中
        void createStudentAutoKey(Student student);


        List<Student> getStudentListIf(Student student);

}
