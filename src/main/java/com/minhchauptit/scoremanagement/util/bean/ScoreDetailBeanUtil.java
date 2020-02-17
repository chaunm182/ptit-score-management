package com.minhchauptit.scoremanagement.util.bean;

import com.minhchauptit.scoremanagement.dto.ScoreDetailDTO;
import com.minhchauptit.scoremanagement.entity.ScoreDetail;

public class ScoreDetailBeanUtil {
    public static ScoreDetail dto2Entity(ScoreDetailDTO scoreDetailDTO){
        ScoreDetail scoreDetail = new ScoreDetail();
        scoreDetail.setId(scoreDetailDTO.getId());
        scoreDetail.setAttendanceScore(scoreDetailDTO.getAttendanceScore());
        scoreDetail.setMidTermExamScore(scoreDetailDTO.getMidTermExamScore());
        scoreDetail.setPracticeScore(scoreDetailDTO.getPracticeScore());
        scoreDetail.setAssignmentScore(scoreDetailDTO.getAssignmentScore());
        scoreDetail.setFinalExamScore(scoreDetailDTO.getFinalExamScore());
        scoreDetail.setSemester(scoreDetailDTO.getSemester());
        scoreDetail.setDescription(scoreDetailDTO.getDescription());
        scoreDetail.setStudent(StudentBeanUtil.dto2Entity(scoreDetailDTO.getStudentDTO()));
        return scoreDetail;
    }

    public static ScoreDetailDTO entity2Dto(ScoreDetail scoreDetail){
        ScoreDetailDTO scoreDetailDTO = new ScoreDetailDTO();
        scoreDetailDTO.setId(scoreDetail.getId());
        scoreDetailDTO.setAttendanceScore(scoreDetail.getAttendanceScore());
        scoreDetailDTO.setMidTermExamScore(scoreDetail.getMidTermExamScore());
        scoreDetailDTO.setPracticeScore(scoreDetail.getPracticeScore());
        scoreDetailDTO.setAssignmentScore(scoreDetail.getAssignmentScore());
        scoreDetailDTO.setFinalExamScore(scoreDetail.getFinalExamScore());
        scoreDetailDTO.setSemester(scoreDetail.getSemester());
        scoreDetailDTO.setDescription(scoreDetail.getDescription());
        scoreDetailDTO.setSubjectDTO(SubjectBeanUtil.entity2DTO(scoreDetail.getSubject()));
        scoreDetailDTO.setStudentDTO(StudentBeanUtil.entity2DTO(scoreDetail.getStudent()));
        return scoreDetailDTO;
    }
}
