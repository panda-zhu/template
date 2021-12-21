package com.example.template.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @description: 测试校验实体
 * @author: zlf
 * @create: 2021-12-20 14:25
 */
@Data
@ToString
public class ValidationTestVo implements Serializable {
    @NotNull(message ="【用户ID】不能为空" )
    @Size(min = 1,max = 5,message = "用户ID长度必须在1-5之间")
    private String userId;

    @Range(min = 0,max = 200,message = "年龄需要在0-200中间")
    @NotNull(message = "【年龄】不能为空")
    private int age;

    @Pattern(regexp = "^([\\u4e00-\\u9fa5]{1,20}|[a-zA-Z\\.\\s]{1,20})$",message = "名字只能输入中文、英文，且在20个字符以内")
    @NotEmpty(message = "【姓名】不能为空")
    private String userName;
    @Email(message = "【邮箱】格式不规范")
    private String email;
    @Past
    private Date birthday;

}
