package com.example.template.support;

import lombok.Data;

/**
 * @description: 统一返回结果类
 * @author: zlf
 * @create: 2021-12-21 15:30
 */

@Data
public class RestResult {
    private boolean state;
    private String code;
    private Object data;
    private long timestamp;
}
