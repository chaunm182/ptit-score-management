package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRespository extends JpaRepository<Student,Integer> {
    Optional<Student> findByStudentId(String studentId);
    Optional<Student> findByAccount_Username(String username);
}
