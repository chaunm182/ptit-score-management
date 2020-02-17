package com.minhchauptit.scoremanagement.dto;

import java.sql.Timestamp;

public class StudentDTO {
    private Integer id;
    private String studentId;
    private String firstName;
    private String lastName;
    private Timestamp createdAt;
    private ScoreDetailDTO scoreDetailDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
