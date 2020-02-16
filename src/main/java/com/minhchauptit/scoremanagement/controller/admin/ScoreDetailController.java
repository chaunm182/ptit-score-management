package com.minhchauptit.scoremanagement.controller.admin;

import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;


@Controller
@RequestMapping("/admin/score")
public class ScoreDetailController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/upload")
    public String showFormForUpload(Model model){
        List<Subject> subjectList = subjectService.findAll();
        model.addAttribute("subjects",subjectList);
        return "/view/admin/scoredetail/upload-form";
    }

}
