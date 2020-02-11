package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespository extends JpaRepository<Student,Integer> {

}
