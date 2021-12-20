package com.example.template.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private int id;
    private String stName;
    private int age;
    private String grade;
    private int classId;
}
