package com.minhchauptit.scoremanagement.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SearchController {

    @GetMapping("/")
    public String showSearchPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.getAttribute("account");
        return "view/web/search";
    }
}
