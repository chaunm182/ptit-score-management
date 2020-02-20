package com.minhchauptit.scoremanagement.dto;

import javax.persistence.Column;

public class ScoreDetailDTO {
    private Integer id;
    private Float attendanceScore;
    private Float midTermExamScore;
    private Float practiceScore;
    private Float assignmentScore;
    private Float finalExamScore;
    private String description;
    private Integer semester;
    private SubjectDTO subjectDTO;
    private StudentDTO studentDTO;

    private Float mark;
    private String letter;

    public ScoreDetailDTO() {
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

    public SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }

    public void setSubjectDTO(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
