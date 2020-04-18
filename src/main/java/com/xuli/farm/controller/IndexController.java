package com.xuli.farm.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xuli.farm.po.*;
import com.xuli.farm.service.impl.AboutServiceImpl;
import com.xuli.farm.service.impl.FeedbackServoceImpl;
import com.xuli.farm.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * @author xuli
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private AboutServiceImpl aboutService;

    @Autowired
    private NewsServiceImpl newsService;
    @Autowired
    private FeedbackServoceImpl feedbackServoce;

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("index.html")
    public String index(Model model) {
        return "home/index";
    }


    @GetMapping("header.html")
    public String header() {

        return "home/header";
    }

    @GetMapping("footer.html")
    public String footer() {

        return "home/footer";
    }

    @GetMapping("login.html")
    public String login() {

        return "home/login";
    }

    @GetMapping("register.html")
    public String register() {

        return "home/register";
    }





    @GetMapping("contact.html")
    public String contact() {

        return "home/contact";
    }


    @GetMapping("forgot.html")
    public String forgot() {

        return "home/forgot";
    }


    @GetMapping("reset.html")
    public String reset() {
        return "home/reset";
    }


    @GetMapping("about.html")
    public String about(Model model) {
        About about = aboutService.queryAboutById(1);
        model.addAttribute("about", about);
        return "home/about";
    }


    @GetMapping("archive.html")
    public String archive() {

        return "home/archive";
    }

    @ResponseBody
    @PostMapping("feedback")
    public ResultInfo feedback(HttpSession session, @RequestParam(value = "message") String message) {
        User user = (User) session.getAttribute("user");
        ResultInfo resultInfo = null;
        if (null != user) {
            Feedback feedback = new Feedback();
            feedback.setMessage(message);
            feedback.setUid(user.getUid());
            feedback.setUid(user.getUid());
            feedback.setUsername(user.getUsername());
            Boolean status = feedbackServoce.addFeedback(feedback);

            resultInfo = new ResultInfo(status, user.getName(), "留言成功，感谢您的反馈！");
        } else {
            resultInfo = new ResultInfo(false, null, "当前未登录，请先登录后再留言！");
        }
        return resultInfo;


    }


}
