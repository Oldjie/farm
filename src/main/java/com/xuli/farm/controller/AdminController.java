package com.xuli.farm.controller;


import com.xuli.farm.exception.UserNameOrPasswordErrorException;
import com.xuli.farm.exception.UserNoActiveException;
import com.xuli.farm.po.ResultInfo;
import com.xuli.farm.po.User;
import com.xuli.farm.service.UserService;
import com.xuli.farm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @Autowired
    private UserServiceImpl userService;



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



}
