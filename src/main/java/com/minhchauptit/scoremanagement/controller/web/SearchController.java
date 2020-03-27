package com.minhchauptit.scoremanagement.controller.web;

import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/")
    public String showSearchPage(Model model){
        List<Subject> list = subjectService.findTop3WithUpdateTime();
        model.addAttribute("listSubject",list);
        return "view/web/search";
    }
    @GetMapping("/loaderio-252b7179047195bae418032a8b65257a")
    public String testFromLoaderIo(){
        return "view/web/loaderio-252b7179047195bae418032a8b65257a";
    }
}
