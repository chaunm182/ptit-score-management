package com.minhchauptit.scoremanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "subject_detail")
public class SubjectDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "attendance_weight")
    private Integer attendanceWeight;

    @Column(name = "mid_term_exam_weight")
    private Integer midTermExamWeight;

    @Column(name = "practice_weight")
    private Integer practiceWeight;

    @Column(name = "assignment_weight")
    private Integer assignmentWeight;

    @OneToOne(mappedBy = "subjectDetail",cascade = CascadeType.ALL)
    private Subject subject;

    public SubjectDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttendanceWeight() {
        return attendanceWeight;
    }

    public void setAttendanceWeight(Integer attendanceWeight) {
        this.attendanceWeight = attendanceWeight;
    }

    public Integer getMidTermExamWeight() {
        return midTermExamWeight;
    }

    public void setMidTermExamWeight(Integer midTermExamWeight) {
        this.midTermExamWeight = midTermExamWeight;
    }

    public Integer getPracticeWeight() {
        return practiceWeight;
    }

    public void setPracticeWeight(Integer practiceWeight) {
        this.practiceWeight = practiceWeight;
    }

    public Integer getAssignmentWeight() {
        return assignmentWeight;
    }

    public void setAssignmentWeight(Integer assignmentWeight) {
        this.assignmentWeight = assignmentWeight;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}

