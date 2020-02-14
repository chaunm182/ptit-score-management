package com.minhchauptit.scoremanagement.rest;

import com.minhchauptit.scoremanagement.dto.SubjectDTO;
import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.service.SubjectService;
import com.minhchauptit.scoremanagement.util.bean.SubjectBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectRestController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public List<Subject> findAll(){
        return subjectService.findAll();
    }

    @GetMapping("/subjects/{page},{size},{sortExpression},{sortDirection}")
    public List<SubjectDTO> findSubjectsWithPagingAndSorting(
            @PathVariable(name = "page", required = false) Integer page,
            @PathVariable(name = "size", required = false) Integer size,
            @PathVariable(name = "sortExpression", required = false) String sortExpression,
            @PathVariable(name = "sortDirection", required = false) String sortDirection
    ){
        Page<Subject> subjectPage = subjectService.findAllWithPagingAndSorting(page,size,sortExpression,sortDirection);
        List<Subject> subjectList = subjectPage.getContent();
        List<SubjectDTO> result = new ArrayList<>();
        for(Subject subject: subjectList){
            result.add(SubjectBeanUtil.entity2DTO(subject));
        }
        return result;
    }
}
