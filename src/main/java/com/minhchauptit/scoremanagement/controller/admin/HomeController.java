package com.minhchauptit.scoremanagement.controller.admin;

import com.minhchauptit.scoremanagement.dto.AccountDTO;
import com.minhchauptit.scoremanagement.dto.StudentDTO;
import com.minhchauptit.scoremanagement.entity.Account;
import com.minhchauptit.scoremanagement.entity.Student;
import com.minhchauptit.scoremanagement.service.StudentService;
import com.minhchauptit.scoremanagement.util.bean.AccountBeanUtil;
import com.minhchauptit.scoremanagement.util.bean.StudentBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class HomeController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/home")
    public String home(){
        return "view/admin/home";
    }

    @GetMapping("/my-account")
    public String showMyAccountPage(Model model, HttpServletRequest request){
        Account account = (Account) request.getSession().getAttribute("account");
        String username = account.getUsername();
        Student student = studentService.findSByAccountUsername(username);
        StudentDTO studentDTO = StudentBeanUtil.entity2DTO(student);
        model.addAttribute("studentDTO",studentDTO);
        return "/view/admin/my-account";
    }
}
