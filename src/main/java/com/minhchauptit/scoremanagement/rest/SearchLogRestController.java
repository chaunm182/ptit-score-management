package com.minhchauptit.scoremanagement.rest;

import com.minhchauptit.scoremanagement.dto.SearchLogDTO;
import com.minhchauptit.scoremanagement.entity.SearchLog;
import com.minhchauptit.scoremanagement.service.SearchLogService;
import com.minhchauptit.scoremanagement.util.bean.SearchLogBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchLogRestController {

    @Autowired
    private SearchLogService searchLogService;

    @GetMapping("/searchlogs/{page},{size}")
    public List<SearchLogDTO> findAll(
            @PathVariable(name = "page") Integer page,
            @PathVariable(name = "size") Integer size
    ){
        Sort sort = Sort.by("createdAt");
        sort = sort.descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<SearchLog> searchLogPage = searchLogService.findAll(pageable);
        List<SearchLog> searchLogs = searchLogPage.getContent();
        List<SearchLogDTO> result = new ArrayList<>();
        for(SearchLog searchLog: searchLogs){
            result.add(SearchLogBeanUtil.entity2DTO(searchLog));
        }
        return result;
    }
}
