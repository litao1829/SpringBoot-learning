package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CachedUserService implements InitializingBean {

    @Resource
    private CacheManager cacheManager;

    @Resource
    private UserMapper usermapper;

    private Cache cache;

    public User getById(Integer id){
        //1.通过CacheManager拿到名为user的缓存对象Cache
//        Cache cache = cacheManager.getCache("user");
//        assert cache!=null;
//
//      //2.从Cache中获取一个指定key为id的User类型的对象
        User user = cache.get(id, User.class);
        //3.如果对象存在直接返回
        if(user!=null){
            return  user;
        }

        //4.如果对象不存在，则在数据库中找出，放入cache中
        User user1 = usermapper.getById(id);
        cache.put(id,user1);

        return user1;
    }

    public List<User> findAll(){
        Cache cache1 = cacheManager.getCache("users");
        assert cache1!=null;
        List<User> users=cache1.get("users",List.class);
        if(users!=null){
            return users;
        }

        List<User> all = usermapper.findAll();
        cache1.put("users",all);

        return all;
    }

    public List<User>  findAllByNameLike(String name){

        return  cache.get(name,()->usermapper.findAllByNameLike(name));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.cache=cacheManager.getCache("user");
    }
}
