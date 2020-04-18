package com.xuli.farm.controller;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.Food;
import com.xuli.farm.service.FoodService;
import com.xuli.farm.service.impl.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class FoodController {
    @Autowired
    private FoodServiceImpl foodService;
    @RequestMapping("admin/restaurant_food.html")
    public String food(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageInfo<Food> pageBean = foodService.queryUserAll(pageNum, pageSize);

        model.addAttribute("foods", pageBean);
        return "admin/restaurant_food";
    }


    @RequestMapping("admin/add_food.html")
    public String addFood(){
        return "admin/add_food";
    }
}
