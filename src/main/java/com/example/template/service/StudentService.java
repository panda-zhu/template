package com.example.template.service;

import com.example.template.entity.Student;

import java.util.List;

public interface StudentService {
    void insertBatchStudent(List<Student> students);
    void insertStudent(Student student);
    void deleteStudentById(Student student);
    void updateStudentById(Student student);
    Student queryStudentById(Student student);
    String testException();
}
