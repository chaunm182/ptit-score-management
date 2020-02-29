package com.minhchauptit.scoremanagement.dto;


import com.minhchauptit.scoremanagement.validation.annotation.SubjectCodeUnique;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.sql.Timestamp;

public class SubjectDTO {

    private Integer id;

    @Size(min = 2, message = "Tối thiểu 2 ký tự")
    @NotNull(message = "Không được để trống")
    @SubjectCodeUnique
    private String subjectId;

    @NotNull(message = "Không được để trống")
    @Size(min = 1, message = "Tối thiểu 1 ký tự")
    private String name;

    @NotNull(message = "Không được để trống")
    @Min(value = 1,message = "Tối thiểu 1 tín chỉ")
    private Integer credit;


    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Valid
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
