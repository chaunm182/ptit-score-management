package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    Optional<Subject> findBySubjectId(String subjectId);

}
