package com.minhchauptit.scoremanagement.util.bean;

import com.minhchauptit.scoremanagement.dto.SubjectDTO;
import com.minhchauptit.scoremanagement.entity.Subject;

public class SubjectBeanUtil {
    public static Subject dto2Entity(SubjectDTO dto){
        Subject subject = new Subject();
        subject.setId(dto.getId());
        subject.setName(dto.getName());
        subject.setCreatedAt(dto.getCreatedAt());
        subject.setUpdatedAt(dto.getUpdatedAt());
        subject.setSubjectDetail(SubjectDetailBeanUtil.dto2Entity(dto.getSubjectDetailDTO()));
        return subject;
    }

    public static SubjectDTO entity2DTO(Subject subject){
        SubjectDTO dto = new SubjectDTO();
        dto.setId(subject.getId());
        dto.setName(subject.getName());
        dto.setCreatedAt(subject.getCreatedAt());
        dto.setUpdatedAt(subject.getUpdatedAt());
        dto.setSubjectDetailDTO(SubjectDetailBeanUtil.entity2Dto(subject.getSubjectDetail()));
        return dto;
    }
}
