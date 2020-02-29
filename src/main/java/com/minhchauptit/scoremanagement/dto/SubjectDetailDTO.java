package com.minhchauptit.scoremanagement.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SubjectDetailDTO {
    private Integer id;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Hệ số tối thiểu = 0%")
    @Max(value = 50, message = "Hệ số tối đa = 50%")
    private Integer attendanceWeight;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Hệ số tối thiểu = 0%")
    @Max(value = 50, message = "Hệ số tối đa = 50%")
    private Integer midTermExamWeight;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Hệ số tối thiểu = 0%")
    @Max(value = 50, message = "Hệ số tối đa = 50%")
    private Integer practiceWeight;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Hệ số tối thiểu = 0%")
    @Max(value = 50, message = "Hệ số tối đa = 50%")
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
