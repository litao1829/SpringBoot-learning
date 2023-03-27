package com.example.controller;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Controller
@RequestMapping("api")
public class ServletController {

    @GetMapping("/request")
    public void testRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info("controller:"+ request.getRequestURI());
        request.setAttribute("name","张三");
        request.setAttribute("name","李四");
        request.removeAttribute("name");
    }

    @GetMapping("/login")
    public String login(ModelMap map){
        map.put("msg","interceptor");
        return "login";
    }

    @GetMapping("/hello")
    public String hello(ModelMap map){
        map.put("msg","helloword");
        return "index";
    }
}
