package com.minhchauptit.scoremanagement.util.bean;

import com.minhchauptit.scoremanagement.dto.SearchLogDTO;
import com.minhchauptit.scoremanagement.entity.SearchLog;

public class SearchLogBeanUtil {
    public static SearchLogDTO entity2DTO(SearchLog searchLog){
        SearchLogDTO searchLogDTO = new SearchLogDTO();
        searchLogDTO.setId(searchLog.getId());
        searchLogDTO.setIpDTO(IpBeanUtil.entity2DTO(searchLog.getIp()));
        searchLogDTO.setStudentDTO(StudentBeanUtil.entity2DTO(searchLog.getStudent()));
        searchLogDTO.setCreatedAt(searchLog.getCreatedAt());
        return searchLogDTO;
    }
}
