package com.example.template.service.impl;

import com.example.template.dao.StudentMapper;
import com.example.template.entity.Student;
import com.example.template.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public void insertBatchStudent(List<Student> students) {
        studentMapper.insertBatchStudent(students);
    }

    @Override
    public void insertStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public void deleteStudentById(Student student) {
        studentMapper.deleteStudentById(student);
    }

    @Override
    public void updateStudentById(Student student) {
        studentMapper.updateStudentById(student);
    }

    @Override
    public Student queryStudentById(Student student) {
        log.info("开始查询学生信息{}",student);
        return studentMapper.queryStudentById(student);
    }
}
