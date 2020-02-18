package com.minhchauptit.scoremanagement.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {

    @GetMapping("/")
    public String showSearchPage(){
        return "/view/web/search";
    }
}
