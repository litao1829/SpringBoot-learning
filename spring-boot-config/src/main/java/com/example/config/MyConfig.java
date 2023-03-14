package com.example.config;


//使用@Configration编写zi'ding'yi配置类

import com.example.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {


    //将该方法的返回值作为一个值，作为一个Bean，添加到Spring容器中,该bean的id就是方法名
    @Bean
    public MyService myService(){
        return new MyService();
    }
}
