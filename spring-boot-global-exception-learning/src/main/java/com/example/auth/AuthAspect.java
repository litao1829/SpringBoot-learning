package com.example.auth;

import com.example.enums.ExceptionType;
import com.example.exception.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
@Aspect
public class AuthAspect {

    private HttpServletRequest getHttpServletRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    @Around("@annotation(com.example.auth.CheckAuth)")
    public Object checkAuth(ProceedingJoinPoint point) throws Throwable {
        //获取请求对象
        HttpServletRequest request = getHttpServletRequest();
        //获取请求头
        String token =request.getHeader("Authorization");
        if(token==null){
            throw new CustomException(ExceptionType.UNAUTHORIZED_ERROR);
        }

        //获取@CheckAuth注解里的值
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        CheckAuth annotation = method.getAnnotation(CheckAuth.class);
        String value=annotation.value();
        if(!(value.equals(token))){
            throw  new CustomException(ExceptionType.UNAUTHORIZED_ERROR);
        }
        return point.proceed();
    }
}
