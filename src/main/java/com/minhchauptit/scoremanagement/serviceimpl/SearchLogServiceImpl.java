package com.minhchauptit.scoremanagement.serviceimpl;

import com.minhchauptit.scoremanagement.entity.SearchLog;
import com.minhchauptit.scoremanagement.repository.SearchLogRepository;
import com.minhchauptit.scoremanagement.service.SearchLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchLogServiceImpl implements SearchLogService {

    @Autowired
    private SearchLogRepository searchLogRepository;
    @Override
    public void save(SearchLog searchLog) {
        searchLogRepository.save(searchLog);
    }

    @Override
    public Page<SearchLog> findAll(Pageable pageable) {
        return searchLogRepository.findAll(pageable);
    }

    @Override
    public long count() {

        return searchLogRepository.count();
    }
}
