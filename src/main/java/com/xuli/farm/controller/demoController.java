package com.xuli.farm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/article")
public class demoController {


    @RequestMapping("/articleList.html")
    public String getArticleList(Model model, String title, @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "1") Integer pageNum) {
        int offset = (pageNum - 1) * pageSize;
            return "articleList";
    }
}
