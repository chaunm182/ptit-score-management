package com.minhchauptit.scoremanagement.util.bean;

import com.minhchauptit.scoremanagement.dto.SubjectDetailDTO;
import com.minhchauptit.scoremanagement.entity.SubjectDetail;

public class SubjectDetailBeanUtil {
    public static SubjectDetail dto2Entity(SubjectDetailDTO dto){
        SubjectDetail subjectDetail = new SubjectDetail();
        subjectDetail.setId(dto.getId());
        subjectDetail.setAttendanceWeight(dto.getAttendanceWeight());
        subjectDetail.setMidTermExamWeight(dto.getMidTermExamWeight());
        subjectDetail.setPracticeWeight(dto.getPracticeWeight());
        subjectDetail.setAssignmentWeight(dto.getAssignmentWeight());
        return subjectDetail;
    }

    public static SubjectDetailDTO entity2Dto(SubjectDetail subjectDetail){
        SubjectDetailDTO dto = new SubjectDetailDTO();
        dto.setId(subjectDetail.getId());
        dto.setAttendanceWeight(subjectDetail.getAttendanceWeight());
        dto.setMidTermExamWeight(subjectDetail.getMidTermExamWeight());
        dto.setPracticeWeight(subjectDetail.getPracticeWeight());
        dto.setAssignmentWeight(subjectDetail.getAssignmentWeight());
        return dto;
    }
}
