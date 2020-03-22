package com.minhchauptit.scoremanagement.service;

import com.minhchauptit.scoremanagement.entity.Subject;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();

    Page<Subject> findAllWithPagingAndSorting(Integer page, Integer size, String sortExpression, String sortDirection);

    Subject save(Subject subject);

    Subject findById(Integer id);

    long calculateTotalPages(Integer size);

    void deleteById(Integer id);

    Subject findBySubjectId(String subjectId);

    List<Subject> findTop3WithUpdateTime();
}
