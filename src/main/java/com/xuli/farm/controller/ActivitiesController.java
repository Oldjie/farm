package com.xuli.farm.controller;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.Activities;
import com.xuli.farm.service.ActivitiesService;
import com.xuli.farm.service.impl.AboutServiceImpl;
import com.xuli.farm.service.impl.ActivitiesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class ActivitiesController {

    @Autowired
    private ActivitiesServiceImpl activitiesService;

    @RequestMapping("admin/outdoor_activities.html")
    public String activities(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageInfo<Activities> pageBean = activitiesService.queryUserAll(pageNum, pageSize);

        model.addAttribute("activities", pageBean);
        return "admin/outdoor_activities";
    }

    @RequestMapping("admin/add_activities.html")
    public String addActivities(){
        return "admin/add_activities";
    }
}
