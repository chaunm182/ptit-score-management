package com.minhchauptit.scoremanagement.controller.admin;

import com.minhchauptit.scoremanagement.dto.SubjectDTO;
import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.service.SubjectService;
import com.minhchauptit.scoremanagement.util.bean.SubjectBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private Environment env;

    @GetMapping("/list")
    public String showListSubject(Model model,
                                  @RequestParam(name = "size" , required = false, defaultValue = "8") Integer size){
        long totalPages = subjectService.calculateTotalPages(size);
        model.addAttribute("totalPages",totalPages);
        return "/view/admin/subject/list";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model model){
        Subject subject = new Subject();
        model.addAttribute("subject",subject);
        return "/view/admin/subject/save";
    }

    @PostMapping("/save")
    public String saveSubject(@ModelAttribute("subject") Subject subject){
        Subject result = subjectService.save(subject);
        String param = null;
        if (result!=null){
            param = "insert_success";
        }
        else param = "insert_error";
        return "redirect:/admin/subject/list?"+param;

    }


}
