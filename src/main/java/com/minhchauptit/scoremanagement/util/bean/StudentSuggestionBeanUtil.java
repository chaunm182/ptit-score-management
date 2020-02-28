package com.minhchauptit.scoremanagement.util.bean;

import com.minhchauptit.scoremanagement.dto.StudentSuggestionDTO;
import com.minhchauptit.scoremanagement.entity.Student;

public class StudentSuggestionBeanUtil {
    public static StudentSuggestionDTO entity2DTO(Student student){
        StudentSuggestionDTO studentSuggestionDTO = new StudentSuggestionDTO();
        studentSuggestionDTO.setValue(student.getStudentId());
        studentSuggestionDTO.setData(student.getFirstName()+" "+student.getLastName());
        return studentSuggestionDTO;
    }
}
