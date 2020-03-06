package com.minhchauptit.scoremanagement.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhchauptit.scoremanagement.dto.StudentDTO;
import com.minhchauptit.scoremanagement.dto.StudentSuggestionDTO;
import com.minhchauptit.scoremanagement.entity.Student;
import com.minhchauptit.scoremanagement.response.StudentSuggestionResponse;
import com.minhchauptit.scoremanagement.service.StudentService;
import com.minhchauptit.scoremanagement.util.bean.StudentBeanUtil;
import com.minhchauptit.scoremanagement.util.bean.StudentSuggestionBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public StudentDTO getStudent(@PathVariable(name = "studentId") String studentId){
        Student student = studentService.findByStudentId(studentId);
        StudentDTO studentDTO = StudentBeanUtil.entity2DTO(student);
        return studentDTO;
    }

    @GetMapping("/students/search")
    public ResponseEntity<StudentSuggestionResponse> findStudentsByStudentIdLikeOrFullNameLike(
            @RequestParam("query") String param){
        List<Student> students = studentService.findStudentsByStudentIdLikeOrFullNameLike(param);
        List<StudentSuggestionDTO> dtos = new ArrayList<>();
        for(Student student:students){
            dtos.add(StudentSuggestionBeanUtil.entity2DTO(student));
        }
        StudentSuggestionResponse response = new StudentSuggestionResponse();
        response.setSuggestion(dtos);

        return new ResponseEntity<StudentSuggestionResponse>(response, HttpStatus.OK);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable(name = "studentId") Integer id){
        Student student = studentService.findById(id);
        studentService.delete(id);
        return "Delete success student: "+student.getId()+"/"+student.getStudentId();
    }

    @DeleteMapping("/students/all")
    public String deleteAllStudents(){
        studentService.deleteAll();
        return "Delete all successfully";
    }




}
