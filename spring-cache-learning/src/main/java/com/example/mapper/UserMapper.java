package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from tb_user where id=#{value}")
    User getById(Integer id);

    @Select("select * from tb_user")
    List<User> findAll();

    @Select("select * from tb_user where name like concat('%',#{name},'%')")
    List<User> findAllByNameLike(@Param("name")String name);

    @Update("UPDATE tb_user SET name = #{name} WHERE id = #{id}")
    void updateById(User user);

    @Delete("delete from tb_user where id=#{id}}")
    void deleteById(Integer id);

    @Delete("delete  from tb_user")
    void deleteAll();
}
