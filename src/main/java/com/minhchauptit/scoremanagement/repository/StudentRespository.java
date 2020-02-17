package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRespository extends JpaRepository<Student,Integer> {
    Optional<Student> findByStudentId(String studentId);


}
