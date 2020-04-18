package com.xuli.farm.controller;


import com.xuli.farm.dto.RestInfo;
import com.xuli.farm.exception.UserExistsException;
import com.xuli.farm.exception.UserNameNotNullException;
import com.xuli.farm.exception.UserNameOrPasswordErrorException;
import com.xuli.farm.exception.UserNoActiveException;
import com.xuli.farm.po.ResultInfo;
import com.xuli.farm.po.User;
import com.xuli.farm.service.UserService;
import com.xuli.farm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("queryInfoByLoginUser")
    @ResponseBody
    public ResultInfo queryInfoByLoginUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        ResultInfo resultInfo = null;
        if (null != user) {
            resultInfo = new ResultInfo(true, user.getName(), null);
        } else {
            resultInfo = new ResultInfo(false, null, null);
        }
        return resultInfo;
    }

    @GetMapping(value = "loginOut")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultInfo login(User user, HttpSession session) {
        ResultInfo resultInfo = null;
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

    @PostMapping("register")
    @ResponseBody
    public ResultInfo register(User user, @RequestParam("check") String check, HttpSession session) {
        ResultInfo resultInfo = null;
        try {
            String checkCood = (String) session.getAttribute("check");
            if (!checkCood.equalsIgnoreCase(check)) {
                resultInfo = new ResultInfo(false, null, "验证有误，请重新输入！");
            } else {
                userService.register(user);
                resultInfo = new ResultInfo(true, null, null);

            }
        } catch (UserNameNotNullException e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, e.getMessage());

        } catch (UserExistsException e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器忙请稍后重试！");
        }


        return resultInfo;
    }


    @RequestMapping("active")
    public String active(@RequestParam("code") String code) {
        try {
            Boolean flag = userService.active(code);
            if (flag) {
                return "redirect:/login.html";
            } else {
                return "redirect:/error/500.html";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error/500.html";
        }

    }
}
