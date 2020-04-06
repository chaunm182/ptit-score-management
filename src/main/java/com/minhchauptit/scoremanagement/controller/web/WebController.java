package com.minhchauptit.scoremanagement.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/faq")
    public String showFaqPage(){
        return "view/web/faq";
    }

    @GetMapping("/login-form")
    public String showLoginPage(){
        return "view/web/login-form";
    }

    @GetMapping("/login-fail")
    public String showResultForloginFail(){
        return "view/web/login-fail";
    }
}
