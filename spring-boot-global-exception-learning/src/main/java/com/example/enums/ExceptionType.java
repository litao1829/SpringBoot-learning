package com.example.enums;

import com.example.consts.MsgConsts;

import java.awt.*;

public enum ExceptionType {


    PARAM_ERROT(MsgConsts.CODE_400,MsgConsts.PARAM_ERROT),

    UNAUTHORIZED_ERROR(MsgConsts.CODE_401,MsgConsts.UNAUTHORIZED_ERROR),

    FORBIDDEN_ERROR(MsgConsts.CODE_403,MsgConsts.FORBIDDEN_ERROR),

    SYSTEM_ERROR(MsgConsts.CODE_500,MsgConsts.SYSTEM_ERROR),

    OTHER_ERROR(MsgConsts.CODE_999,MsgConsts.OTHER_ERROR);



    ExceptionType(int code,String desc)
    {
        this.code=code;
        this.message=desc;
    }
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
