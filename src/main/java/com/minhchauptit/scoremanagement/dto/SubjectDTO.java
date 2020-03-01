package com.minhchauptit.scoremanagement.dto;

import java.sql.Timestamp;

public class SubjectDTO {

    private Integer id;
    private String subjectId;
    private String name;
    private Integer credit;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private SubjectDetailDTO subjectDetailDTO;

    public SubjectDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public SubjectDetailDTO getSubjectDetailDTO() {
        return subjectDetailDTO;
    }

    public void setSubjectDetailDTO(SubjectDetailDTO subjectDetailDTO) {
        this.subjectDetailDTO = subjectDetailDTO;
    }
}
