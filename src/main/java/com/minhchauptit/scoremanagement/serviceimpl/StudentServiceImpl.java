package com.minhchauptit.scoremanagement.serviceimpl;

import com.minhchauptit.scoremanagement.entity.Student;
import com.minhchauptit.scoremanagement.repository.StudentRespository;
import com.minhchauptit.scoremanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRespository studentRespository;

    @Override
    public List<Student> findAll() {
        return studentRespository.findAll();
    }

    @Override
    public Student findById(Integer studentId) {
        Optional<Student> optionalStudent =  studentRespository.findById(studentId);
        if(optionalStudent.isPresent()) return optionalStudent.get();
        return null;
    }

    @Override
    public Student save(Student student) {
        return studentRespository.save(student);

    }

    @Override
    public void delete(Integer studentId) {
        studentRespository.deleteById(studentId);
    }

    @Override
    public Student findByStudentId(String studentId) {
        Optional<Student> optionalStudent = studentRespository.findByStudentId(studentId);
        if(optionalStudent.isPresent()) return optionalStudent.get();
        return null;

    }
}
