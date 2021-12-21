package com.example.template.controller;

import com.example.template.entity.ValidationTestVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 测试HibernateValidator
 * @author: zlf
 * @create: 2021-12-20 14:23
 */
@RestController
@RequestMapping(value ="/hibernate")
public class HibernateValidatorController {
    @PostMapping(value ="/test1")
    @ResponseBody
    public ValidationTestVo testValidation(@Validated @RequestBody ValidationTestVo validationTestVo){
        return validationTestVo;
    }
}
