package com.example.util;

import com.example.enums.ExceptionType;
import com.example.exception.CustomException;

public class AjaxResponse {

    private int code;
    private String message;
    private Object obj;

    public AjaxResponse() {
    }

    public static AjaxResponse error(CustomException e){
        AjaxResponse response=new AjaxResponse();
        response.setCode(e.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    public static AjaxResponse error(CustomException e,String message){
        AjaxResponse response=new AjaxResponse();
        response.setCode(e.getCode());
        response.setMessage(message);
        return response;
    }

    public static AjaxResponse error(ExceptionType e){
        AjaxResponse response=new AjaxResponse();
        response.setCode(e.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    public static AjaxResponse error(ExceptionType e,String message){
        AjaxResponse response=new AjaxResponse();
        response.setCode(e.getCode());
        response.setMessage(message);
        return response;
    }
    public static AjaxResponse success(Object obj){
        AjaxResponse response=new AjaxResponse();
        response.setCode(200);
        response.setMessage("请求成功");
        response.setObj(obj);
        return response;
    }

    public static AjaxResponse success(Object obj,String message){
        AjaxResponse response=new AjaxResponse();
        response.setCode(200);
        response.setMessage(message);
        response.setObj(obj);
        return response;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
