package com.minhchauptit.scoremanagement.controller.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> showResultForloginFail(){
        return new ResponseEntity<String>("false", HttpStatus.OK);
    }
}
