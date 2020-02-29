package com.minhchauptit.scoremanagement.controller.admin;

import com.minhchauptit.scoremanagement.dto.SubjectDTO;
import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.service.SubjectService;
import com.minhchauptit.scoremanagement.util.bean.SubjectBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return "view/admin/subject/list";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model model){
        SubjectDTO subjectDTO = new SubjectDTO();
        model.addAttribute("subjectDTO",subjectDTO);
        return "view/admin/subject/save";
    }

    @PostMapping("/save")
    public String saveSubject(@Valid @ModelAttribute("subjectDTO") SubjectDTO subjectDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.warning("ERROR SubjectDTO input when saving");
            return "view/admin/subject/save";
        }
        String param = null;
        param = subjectDTO.getId()==null ? "insert" : "update";
        Subject subject = SubjectBeanUtil.dto2Entity(subjectDTO);
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
            return "view/admin/subject/save";
        }
        else return "view/admin/404";

    }

    @GetMapping("/delete")
    public String deleteSubject(@RequestParam("id") Integer id){
        try{
            subjectService.deleteById(id);
        }catch (EmptyResultDataAccessException ex){
            logger.warning("Subject not found - id = "+id);
            return "view/admin/404";
        }

        return "redirect:/admin/subject/list?delete_success";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor  = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }


}
