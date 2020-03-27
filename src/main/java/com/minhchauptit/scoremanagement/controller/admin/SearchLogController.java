package com.minhchauptit.scoremanagement.controller.admin;


import com.minhchauptit.scoremanagement.service.SearchLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchLogController {
    @Autowired
    private SearchLogService searchLogService;
    @GetMapping("/admin/search-log")
    public String showSearchLogPage(Model model,
                                    @RequestParam(value = "size", required = false, defaultValue = "15")
                                            Integer size){
        long numberOfPages = getNumberOfPages(size);
        model.addAttribute("numbersOfPages",numberOfPages);
        return "view/admin/search-log-list";
    }

    private long getNumberOfPages(Integer size){
        long total = searchLogService.count();
        return (total%size==0) ? total/size : (total/size)+1;
    }
}
