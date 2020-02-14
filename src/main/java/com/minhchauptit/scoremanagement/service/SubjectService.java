package com.minhchauptit.scoremanagement.service;

import com.minhchauptit.scoremanagement.entity.Subject;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();

    Page<Subject> findAllWithPagingAndSorting(Integer page, Integer size, String sortExpression, String sortDirection);

    Subject save(Subject subject);

    long calculateTotalPages(Integer size);
}
