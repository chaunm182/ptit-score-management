package com.minhchauptit.scoremanagement.dto;

import java.util.Date;

public class SearchLogDTO {
    private Integer id;
    private IpDTO ipDTO;
    private StudentDTO studentDTO;
    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IpDTO getIpDTO() {
        return ipDTO;
    }

    public void setIpDTO(IpDTO ipDTO) {
        this.ipDTO = ipDTO;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
