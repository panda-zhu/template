package com.example.template.controller;

import com.example.template.entity.Student;
import com.example.template.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    StudentService studentService;

    @PostMapping("/insert")
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }

    @PostMapping("/delete")
    public void deleteStudentById(@RequestBody Student student){
        studentService.deleteStudentById(student);
    }

    @PostMapping("/update")
    public void updateStudentById(@RequestBody Student student){
        studentService.updateStudentById(student);
    }

    @ResponseBody
    @GetMapping("/query")
    public Student queryStudentById(@RequestBody Student student){
        return studentService.queryStudentById(student);
    }


    @PostMapping("/query")
    public void insertBatchStudent(@RequestBody List<Student> students){
        studentService.insertBatchStudent(students);
    }

}
