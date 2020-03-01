package com.minhchauptit.scoremanagement.dto;

public class SubjectDetailDTO {
    private Integer id;
    private Integer attendanceWeight;
    private Integer midTermExamWeight;
    private Integer practiceWeight;
    private Integer assignmentWeight;

    private SubjectDTO subjectDTO;

    public SubjectDetailDTO() {
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

    public SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }

    public void setSubjectDTO(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }
}
