package com.minhchauptit.scoremanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "score_detail")
public class ScoreDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "attendance_score")
    private Float attendanceScore;

    @Column(name = "mid_term_exam_score")
    private Float midTermExamScore;

    @Column(name = "practice_score")
    private Float practiceScore;

    @Column(name = "assignment_score")
    private Float assignmentScore;

    @Column(name = "final_exam_score")
    private Float finalExamScore;

    @Column(name = "description")
    private String description;

    @Column(name = "semester")
    private Integer semester;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public ScoreDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAttendanceScore() {
        return attendanceScore;
    }

    public void setAttendanceScore(Float attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public Float getMidTermExamScore() {
        return midTermExamScore;
    }

    public void setMidTermExamScore(Float midTermExamScore) {
        this.midTermExamScore = midTermExamScore;
    }

    public Float getPracticeScore() {
        return practiceScore;
    }

    public void setPracticeScore(Float practiceScore) {
        this.practiceScore = practiceScore;
    }

    public Float getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(Float assignmentScore) {
        this.assignmentScore = assignmentScore;
    }

    public Float getFinalExamScore() {
        return finalExamScore;
    }

    public void setFinalExamScore(Float finalExamScore) {
        this.finalExamScore = finalExamScore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
