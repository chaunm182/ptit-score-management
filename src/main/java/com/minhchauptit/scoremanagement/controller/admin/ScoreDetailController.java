package com.minhchauptit.scoremanagement.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/admin/score")
public class ScoreDetailController {

    @GetMapping("/upload")
    public String showFormForUpload(){
        return "/view/admin/scoredetail/upload-form";
    }

    @PostMapping("/check-file")
    public String readFile(@RequestParam("file") MultipartFile file){

        return "a";
    }
}
