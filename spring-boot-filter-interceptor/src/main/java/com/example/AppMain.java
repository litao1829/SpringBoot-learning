package com.example;


import com.example.event.MyEvent;
import com.example.listener.MyListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ServletComponentScan
public class AppMain {


    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AppMain.class, args);
        //装载监听
        applicationContext.addApplicationListener(new MyListener1());
        applicationContext.publishEvent(new MyEvent("MyEvent事件"));
    }
}