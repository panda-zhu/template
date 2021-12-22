package com.example.template.enums;

import com.example.template.exception.IExceptionCode;


public enum BusinessExCode implements IExceptionCode {
    DATABASE_NOT_FOUND("000001", "未在数据库中找到指定数据");


    private String code;
    private String error;

    BusinessExCode(String code, String error) {
        this.code = code;
        this.error = error;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
