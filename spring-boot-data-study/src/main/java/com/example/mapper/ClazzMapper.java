package com.example.mapper;

import com.example.domain.Clazz;

import java.util.List;

public interface ClazzMapper {
    Clazz selectOneToMany(int clazzId);

    Clazz selectOneToOne(int clazzid);
}
