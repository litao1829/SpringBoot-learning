package com.example.mapper;

import com.example.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TeacherMapper {
    Teacher selectOneByOne(Integer teacherId);

    //新增老师
    @Insert("INSERT INTO t_teacher values (#{teacherId},#{teacherName},#{clazzId})")
    int insetTeacher(Teacher teacher);

    //根据teacherId修删除教师
    @Delete("DELETE FROM t_teacher where teacher_id=#{teacherId}")
    int deleteTeacher(Integer teacherId);

    //修改教师信息
    @Update("UPDATE t_teacher SET teacher_name=#{teacherName},clazz_id=#{clazzId} WHERE teacher_id=#{teacherId}")
    int updateTeacher(Teacher teacher);

    //根据teacherId查找老师
    @Select("SELECT * FROM t_teacher WHERE teacher_id=#{teacherId}")
    Teacher selectByTeacherId(int teacherId);
}
