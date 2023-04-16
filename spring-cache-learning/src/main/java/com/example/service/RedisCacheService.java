package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisCacheService {

    @Resource
    private UserMapper mapper;

    @Cacheable(value = "getName")
    public String getName(Integer i){
        log.info("getName invoke.....");
        return "name"+i;
    }

    @Cacheable(value = "getUser",cacheManager = "userCacheManager")
    public User getUser(Integer id){
        return mapper.getById(id);
    }
}
