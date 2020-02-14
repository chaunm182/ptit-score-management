package com.minhchauptit.scoremanagement.dto;


import java.sql.Timestamp;

public class SubjectDTO {
    private String id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private SubjectDetailDTO subjectDetailDTO;

    public SubjectDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
