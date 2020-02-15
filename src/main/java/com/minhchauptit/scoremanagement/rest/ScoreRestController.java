package com.minhchauptit.scoremanagement.rest;

import com.minhchauptit.scoremanagement.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class ScoreRestController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private StorageService storageService;

    @GetMapping("/scores")
    public String findAll(){
        return "hello";
    }

    @PostMapping("/scores/upload")
    public String uploadFile(HttpServletRequest request, @RequestBody MultipartFile file){
        storageService.uploadFile(file);
        return "Upload file successfully";
    }
}
