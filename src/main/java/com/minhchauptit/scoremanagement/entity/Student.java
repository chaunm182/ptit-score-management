package com.minhchauptit.scoremanagement.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends Person{
    @Column(name = "student_id",nullable = false,unique = true)
    private String studentId;

    @Column(name = "created_at")
    private Timestamp createdAt;


    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<ScoreDetail> scoreDetails;

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

    public Set<ScoreDetail> getScoreDetails() {
        return scoreDetails;
    }

    public void setScoreDetails(Set<ScoreDetail> scoreDetails) {
        this.scoreDetails = scoreDetails;
    }
}
