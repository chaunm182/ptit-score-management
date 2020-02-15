package com.minhchauptit.scoremanagement.controller.admin;

import com.minhchauptit.scoremanagement.dto.SubjectDTO;
import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.service.SubjectService;
import com.minhchauptit.scoremanagement.util.bean.SubjectBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    private Logger logger = Logger.getLogger(getClass().getName());

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
        String param = null;
        param = subject.getId()==null ? "insert" : "update";
        Subject result = subjectService.save(subject);

        if (result!=null){
            param += "_success";
        }
        else param = "_error";
        return "redirect:/admin/subject/list?"+param;

    }

    @GetMapping("/update")
    public String showFormForUpdate(Model model, @RequestParam(name = "id") Integer id){
        Subject subject  = subjectService.findById(id);
        if(subject!=null){
            model.addAttribute("subject",subject);
            return "/view/admin/subject/save";
        }
        else return "/view/admin/404";

    }

    @GetMapping("/delete")
    public String deleteSubject(@RequestParam("id") Integer id){
        try{
            subjectService.deleteById(id);
        }catch (EmptyResultDataAccessException ex){
            logger.warning("Subject not found - id = "+id);
            return "/view/admin/404";
        }

        return "redirect:/admin/subject/list?delete_success";
    }


}
