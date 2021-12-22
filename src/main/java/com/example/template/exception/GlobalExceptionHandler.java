package com.example.template.exception;

import com.example.template.support.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: 全局异常处理类
 * @author: zlf
 * @create: 2021-12-21 16:11
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理自定义的业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseEntity businessExceptionHandler(BusinessException e){
        log.error("发生业务异常！原因是：{}",e.getMessage());
        return ResponseHelper.failed(e.getMessage());
    }


    /**
     * 处理参数校验失败异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity exceptionHandler(MethodArgumentNotValidException e){
        // 1.校验
        Boolean fieldErrorUnobtainable = (e == null || e.getBindingResult() == null
                || CollectionUtils.isEmpty(e.getBindingResult().getAllErrors()) || e.getBindingResult().getAllErrors().get(0) == null);
        if (fieldErrorUnobtainable) {
            return ResponseHelper.successful();
        }

        // 2.错误信息
        StringBuilder sb = new StringBuilder();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(allErrors)){
            for (Object fieldError_temp:allErrors) {
                FieldError fieldError = (FieldError) fieldError_temp;
                String objectName = fieldError.getObjectName();
                String field = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();
                sb.append(objectName).append(".").append(field).append(":").append(defaultMessage).append(";");
            }
        }
        // 3.return
        log.error("参数校验失败！原因是:{}",sb.toString());
        return ResponseHelper.failed(sb.toString());
    }

    /**
     * 处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResponseEntity exceptionHandler(Exception e){
        log.error("未知异常！原因是:",e);
        return ResponseHelper.failed(e.getMessage());
    }

}
