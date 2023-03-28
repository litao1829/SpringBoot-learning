package com.example.exception;

import com.example.enums.ExceptionType;

public class CustomException extends RuntimeException{

    private int code;
    private String message;

    public CustomException(){

    }


    public CustomException(ExceptionType exceptionType){
            this.code=exceptionType.getCode();
            this.message=exceptionType.getMessage();
    }

    public CustomException(ExceptionType exceptionType,String message){
        this.code=exceptionType.getCode();
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
