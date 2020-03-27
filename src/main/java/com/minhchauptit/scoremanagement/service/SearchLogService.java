package com.minhchauptit.scoremanagement.service;

import com.minhchauptit.scoremanagement.entity.SearchLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchLogService {
    void save(SearchLog searchLog);
    Page<SearchLog> findAll(Pageable pageable);
    long count();
}
