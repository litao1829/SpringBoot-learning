package com.example.service;


import com.example.entity.User;
import com.example.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper usermapper;

    public User getById(Integer id){
        return  usermapper.getById(id);
    }

    public List<User> findAll(){
        return  usermapper.findAll();
    }

    public List<User>  findAllByNameLike(String name){
        return  usermapper.findAllByNameLike(name);
    }
}
