package com.example.handler;

import com.example.enums.ExceptionType;
import com.example.exception.CustomException;
import com.example.util.AjaxResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebExveptionHandler {


    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse handlerException(CustomException e){
        if(e.getCode()== ExceptionType.SYSTEM_ERROR.getCode()){

        }
        return AjaxResponse.error(e);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResponse handlerBinException(MethodArgumentNotValidException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError!=null;

        return AjaxResponse.error(ExceptionType.PARAM_ERROT,fieldError.getDefaultMessage());
    }

}
