package com.example.template.controller;

import com.example.template.entity.ValidationTestVo;
import com.example.template.exception.BusinessException;
import com.example.template.service.StudentService;
import com.example.template.support.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: 测试HibernateValidator
 * @author: zlf
 * @create: 2021-12-20 14:23
 */
@RestController
@RequestMapping(value ="/hibernate")
@Slf4j
public class HibernateValidatorController {
    @Resource
    private StudentService studentService;


    @PostMapping(value ="/test1")
    @ResponseBody
    public ValidationTestVo testValidation(@Validated @RequestBody ValidationTestVo validationTestVo){
        return validationTestVo;
    }

    @PostMapping(value ="/test2")
    @ResponseBody
    public ResponseEntity testValidation2(@RequestBody ValidationTestVo validationTestVo){
        return ResponseHelper.successful();
    }
    @PostMapping(value ="/test3")
    @ResponseBody
    public ResponseEntity testValidation3(@RequestBody ValidationTestVo validationTestVo){
        return ResponseHelper.successful(validationTestVo);
    }
    @PostMapping(value ="/test4")
    @ResponseBody
    public ResponseEntity testValidation4(@RequestBody ValidationTestVo validationTestVo){
        studentService.testException();
        return ResponseHelper.failed("访问失败");
    }
    @PostMapping(value ="/test5")
    @ResponseBody
    public ResponseEntity testValidation5(@Validated @RequestBody ValidationTestVo validationTestVo){
        System.out.println(validationTestVo.toString());
        return ResponseHelper.failed("-1","访问出现问题", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value ="/test6")
    @ResponseBody
    public ResponseEntity testValidation6(){
        log.trace("trace~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.debug("debug~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("info~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.warn("warn~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.error("error~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return ResponseHelper.successful();
    }
}
