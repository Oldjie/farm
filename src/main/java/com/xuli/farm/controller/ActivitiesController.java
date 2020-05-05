package com.xuli.farm.controller;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.*;
import com.xuli.farm.service.ActivitiesService;
import com.xuli.farm.service.impl.AboutServiceImpl;
import com.xuli.farm.service.impl.ActivitiesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("admin/updateActivities.html")
    @ResponseBody
    public ResultInfo updateActivities(Activities activities) {
        ResultInfo resultInfo = null;
        Boolean flag = activitiesService.updateActivities(activities);
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;

    }

    @PostMapping("admin/save_activities.html")
    @ResponseBody
    public ResultInfo saveActivities(Activities activities) {
        ResultInfo resultInfo = null;
        Boolean flag = activitiesService.insertActivities(activities);
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;

    }

    @GetMapping("admin/editActivities.html")
    public String editActivities(Model model, @RequestParam(value = "uid") int uid) {
        Activities activities = activitiesService.queryActivitiesById(uid);
        model.addAttribute("activities", activities);
        return "admin/editActivities";

    }

    @PostMapping("admin/delActivities.html")
    @ResponseBody
    public ResultInfo delActivities(Activities activities) {
        ResultInfo resultInfo = null;
        Boolean flag = activitiesService.deleteActivitiesById(activities.getId());
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;
    }

    @GetMapping("activities.html")
    public String archives(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageInfo<Activities> activitiesPageInfo = activitiesService.queryUserAll(pageNum, pageSize);

        model.addAttribute("activities", activitiesPageInfo);
        return "home/activities";
    }

    @GetMapping("activitiesDetails.html")
    public String activities(Model model, @RequestParam(value = "uid") int uid) {
        Activities activities = activitiesService.queryActivitiesById(uid);
        model.addAttribute("activities", activities);

        return "home/activitiesDetails";
    }
}
