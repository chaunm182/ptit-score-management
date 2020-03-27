package com.minhchauptit.scoremanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "search_log")
public class SearchLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne(targetEntity = Ip.class, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ip_id")
    private Ip ip;

    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "student_id")
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Ip getIp() {
        return ip;
    }

    public void setIp(Ip ip) {
        this.ip = ip;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
