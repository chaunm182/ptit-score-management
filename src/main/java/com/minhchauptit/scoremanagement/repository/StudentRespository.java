package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRespository extends JpaRepository<Student,Integer> {
    Optional<Student> findByStudentId(String studentId);

    @Query(value = "FROM Student s WHERE s.studentId LIKE %:param% OR CONCAT(s.firstName,' ',s.lastName) LIKE %:param%")
    List<Student> findStudentsByStudentIdLikeOrFullNameLike(@Param("param") String param);

}
