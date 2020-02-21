package com.minhchauptit.scoremanagement.controller.admin;

import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.service.ScoreDetailService;
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
    private ScoreDetailService scoreDetailService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/upload")
    public String showFormForUpload(Model model){
        List<Subject> subjectList = subjectService.findAll();
        model.addAttribute("subjects",subjectList);
        return "view/admin/scoredetail/upload-form";
    }
    @GetMapping("/search")
    public String showSeachScorePage(Model model){
        List<Integer> semesters = scoreDetailService.findDistinctSemester();
        model.addAttribute("semesters",semesters);
        return "view/admin/scoredetail/search";
    }

}
