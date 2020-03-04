package com.minhchauptit.scoremanagement.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginPage(){
        return "view/admin/login";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "view/admin/access-denied";
    }

    @GetMapping("/forgot-password")
    public String showForgotPasswordPage(){
        return "view/admin/forgot-password";
    }
}
