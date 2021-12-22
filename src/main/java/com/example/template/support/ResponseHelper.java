package com.example.template.support;

import com.example.template.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @description: 给统一返回对象添加一个便捷访问的类
 * @author: zlf
 * @create: 2021-12-21 15:34
 */
public abstract class ResponseHelper {
    public static ResponseEntity<RestResult> successful() {
        return successful((Object) null);
    }

    public static ResponseEntity<RestResult> successful(Object data) {
        RestResult result = new RestResult();
        result.setState(true);
        result.setData(data);
        result.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<RestResult> failed(String code, String message, HttpStatus httpStatus) {
        RestResult result = new RestResult();
        result.setState(false);
        result.setCode(code);
        result.setData(message);
        result.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity(result, httpStatus);
    }

    public static ResponseEntity<RestResult> failed(String message) {
        return failed("-1", message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public static ResponseEntity<RestResult> failed(BusinessException ex) {
        return failed(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public static ResponseEntity<RestResult> failed(BusinessException ex, HttpStatus httpStatus) {
        RestResult result = new RestResult();
        result.setState(false);
        if (ex.getExCode() != null) {
            result.setCode(ex.getExCode().getCode());
        }
        result.setData(ex.getMessage());
        result.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity(result, httpStatus);
    }
}

