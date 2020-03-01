package com.minhchauptit.scoremanagement.dto;

import java.sql.Timestamp;

public class StudentDTO extends PersonDTO{
    private String studentId;
    private Timestamp createdAt;
    private ScoreDetailDTO scoreDetailDTO;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public ScoreDetailDTO getScoreDetailDTO() {
        return scoreDetailDTO;
    }

    public void setScoreDetailDTO(ScoreDetailDTO scoreDetailDTO) {
        this.scoreDetailDTO = scoreDetailDTO;
    }
}
