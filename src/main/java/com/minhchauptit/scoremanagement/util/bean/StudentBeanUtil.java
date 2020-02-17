package com.minhchauptit.scoremanagement.util.bean;

import com.minhchauptit.scoremanagement.dto.StudentDTO;
import com.minhchauptit.scoremanagement.entity.Student;

public class StudentBeanUtil {
    public static Student dto2Entity(StudentDTO studentDTO){
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setStudentId(studentDTO.getStudentId());
        student.setCreatedAt(studentDTO.getCreatedAt());
        return student;
    }

    public static StudentDTO entity2DTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setCreatedAt(student.getCreatedAt());
        return studentDTO;
    }
}
