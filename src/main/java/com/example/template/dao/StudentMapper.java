package com.example.template.dao;

import com.example.template.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface StudentMapper {
    void insertStudent(Student student);
    void deleteStudentById(Student student);
    void updateStudentById(Student student);
    Student queryStudentById(Student student);
    void insertBatchStudent(List<Student> students);
}
