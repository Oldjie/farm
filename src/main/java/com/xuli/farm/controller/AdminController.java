package com.xuli.farm.controller;


import com.github.pagehelper.PageInfo;
import com.xuli.farm.exception.UserNameOrPasswordErrorException;
import com.xuli.farm.exception.UserNoActiveException;
import com.xuli.farm.po.About;
import com.xuli.farm.po.Feedback;
import com.xuli.farm.po.ResultInfo;
import com.xuli.farm.po.User;
import com.xuli.farm.service.impl.AboutServiceImpl;
import com.xuli.farm.service.impl.FeedbackServoceImpl;
import com.xuli.farm.service.impl.NewsServiceImpl;
import com.xuli.farm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")

public class AdminController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private NewsServiceImpl newsService;
    @Autowired
    private FeedbackServoceImpl feedbackServoce;

    @Autowired
    private AboutServiceImpl aboutService;

    @GetMapping("index.html")
    public String index(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "admin/index";
    }

    @GetMapping("reset-password.html")
    public String index() {
        return "admin/reset-password.html";
    }


    @RequestMapping("/sign_in.html")
    public String loginHtml() {
        return "admin/sign_in";
    }


    /***
     * 登录
     * @param user
     * @param session
     * @return 返回管理员首页
     */
    @PostMapping("/login")
    @ResponseBody
    public ResultInfo login(User user, HttpSession session) {
        ResultInfo resultInfo = null;
        if (user.getType() == null) {
            resultInfo = new ResultInfo(false, null, "参数异常！");
        }
        try {
            User queryUser = userService.login(user);
            session.setAttribute("user", queryUser);

            resultInfo = new ResultInfo(true, null, null);


        } catch (UserNameOrPasswordErrorException e) {
            resultInfo = new ResultInfo(false, null, e.getMessage());
        } catch (UserNoActiveException e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器忙请稍后重试！");
        }
        return resultInfo;
    }

    /***
     *  退出登录
     * @param session
     * @return 返回登录界面
     */
    @GetMapping("loginOut.html")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "admin/sign_in";
    }


    @GetMapping("users.html")
    public String users(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageInfo<User> pageBean = userService.queryUserAll(pageNum, pageSize);

        model.addAttribute("people", pageBean);
        return "admin/users";
    }

    @GetMapping("feedback.html")
    public String feedback(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageInfo<Feedback> pageBean = feedbackServoce.queryUserAll(pageNum, pageSize);

        model.addAttribute("people", pageBean);
        return "admin/feedback";
    }

    @GetMapping("user.html")
    public String user(Model model, @RequestParam(value = "uid") int uid) {
        User user = userService.queryUserById(uid);
        model.addAttribute("user", user);

        return "admin/user";
    }

    @GetMapping("header.html")
    public String header(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "admin/header";
    }


    @GetMapping("about.html")
    public String help(Model model, HttpSession session) {
        About about = aboutService.queryAboutById(1);
        model.addAttribute("about", about);
        return "admin/about";
    }


    @PostMapping("save_user")
    @ResponseBody
    public ResultInfo saveUser(User user) {
        ResultInfo resultInfo = null;
        Boolean flag = userService.updateUser(user);
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;

    }


    @PostMapping("save_about")
    @ResponseBody
    public ResultInfo saveUser(About about) {
        ResultInfo resultInfo = null;
        about.setId(1);
        Boolean flag = aboutService.updateUser(about);
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;

    }

    @PostMapping("del_user")
    @ResponseBody
    public ResultInfo delUser(User user) {
        ResultInfo resultInfo = null;
        Boolean flag = userService.deleteUserById(user.getUid());
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;
    }


}
