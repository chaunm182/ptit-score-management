package com.minhchauptit.scoremanagement.serviceimpl;

import com.minhchauptit.scoremanagement.entity.Student;
import com.minhchauptit.scoremanagement.repository.CustomizeStudentRepository;
import com.minhchauptit.scoremanagement.repository.StudentRespository;
import com.minhchauptit.scoremanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRespository studentRespository;

    @Autowired
    private CustomizeStudentRepository customizeStudentRepository;

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
//    @CacheEvict(value = "students", allEntries = true)
    public Student save(Student student) {
        return studentRespository.save(student);

    }

    @Override
    public void delete(Integer studentId) {
        studentRespository.deleteById(studentId);
    }

    @Override
    public void deleteAll() {
        studentRespository.deleteAll();
    }

    @Override
    public Student findByStudentId(String studentId) {
        Optional<Student> optionalStudent = studentRespository.findByStudentId(studentId);
        if(optionalStudent.isPresent()) return optionalStudent.get();
        return null;

    }

    @Override
    @Transactional
//    @Cacheable(value = "students", condition = "#param.length() <=8")
    public List<Student> findStudentsByStudentIdLikeOrFullNameLike(String param) {
        return customizeStudentRepository.findStudentsByStudentIdLikeOrFullNameLike(param);
    }

    @Override
    public Student findSByAccountUsername(String username) {
        Optional<Student> studentOptional = studentRespository.findByAccount_Username(username);
        if(studentOptional.isPresent()) return studentOptional.get();
        return null;
    }
}
