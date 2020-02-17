package com.minhchauptit.scoremanagement.service;

import com.minhchauptit.scoremanagement.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Integer studentId);
    Student save(Student student);
    void delete(Integer studentId);
    void deleteAll();
    Student findByStudentId(String studentId);
}
