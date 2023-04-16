package com.example.service;

import com.example.custom.UserKeyGenerator;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AnnotationUserService {
    @Resource
    private UserMapper usermapper;
    @Resource
    private UserKeyGenerator userKeyGenerator;

//      方式一：默认key，id为key
//    @Cacheable("user.get")
//    public User getById(Integer id){
//        return  usermapper.getById(id);
//    }

    //方式二：methodName & method引用方法名或者方法信息，#root.methodName 和 #root.method.name
//    @Cacheable(value="user.get",key = "#root.methodName")
//    public User getById(Integer id){
//        return  usermapper.getById(id);
//    }

    //方式三：target & targetClass当前对象和当前类的信息，"#root.targetClass.simpleName
    @Cacheable(value="user.get",key = "#root.targetClass.simpleName")
    public User getById(Integer id){

        return  usermapper.getById(id);
    }


    //方式四：args & arg name引用参数列表的某一个或某几个参数作为 key ，#root.args[0]
//    @Cacheable(value="user.get",key = "#root.args[0]")
//    public User getById(Integer id){
//
//        return  usermapper.getById(id);
//    }

    //方式五：caches引用某一个 cache 的名称为key，#root.caches[1]
//    @Cacheable(value= {"user.get", "user.find"},key = "#root.caches[1]")
//    public User getById(Integer id){
//
//        return  usermapper.getById(id);
//    }

    //方式六：自定义key，#root.caches[1]
//    @Cacheable(value= "user.get",keyGenerator="userKeyGenerator")
//    public User getById(Integer id){
//
//        return  usermapper.getById(id);
//    }

    //@Cacheable中的其他属性，condition可以指定符合什么条件的数据参与缓存
//    @Cacheable(value = "user.get", key = "#id", condition = "#id % 2 == 1")
//    public User getById(Integer id) {
//        return usermapper.getById(id);
//    }

    //@Cacheable中的其他属性，unless哪些数据不参与缓存
//   @Cacheable(value = "user.get", key = "#id", unless = "#result.name.contains('张')")
//    public User getById(Integer id) {
//        return usermapper.getById(id);
//    }

    //@Cacheable中的其他属性，unless哪些数据不参与缓存
//    @Cacheable(value = "user.get", key = "#id",sync = true)
//    public User getById(Integer id) {
//        return usermapper.getById(id);
//    }

    @Cacheable(value = "users.get")
    public List<User> findAll(){
        return  usermapper.findAll();
    }

    public List<User>  findAllByNameLike(String name){
        return  usermapper.findAllByNameLike(name);
    }

    @CachePut(value = "user.get", key = "#user.id")
    public User update(User user) {
        usermapper.updateById(user);
        return user;
    }


    @CacheEvict(value = "user.get", key = "#id")
    public void deleteById(Integer id) {
         //usermapper.deleteById(id);
        log.info("deleteById invoke ......");
    }

    @CacheEvict(value = "users.get",allEntries = true)
    public void deleteAll(){
        //usermapper.deleteAll();
        log.info("deleteAll invoke ......");
    }

}
