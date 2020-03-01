package com.xuli.farm.controller;


import com.xuli.farm.po.User;
import com.xuli.farm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demo {

    @RequestMapping("/")
    public String index() {
        return "hello,word!";
    }

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public User hello() {
        User user = this.userService.queryById(1L);
        return user;
    }
}
