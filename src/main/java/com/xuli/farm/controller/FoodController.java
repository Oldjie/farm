package com.xuli.farm.controller;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.Activities;
import com.xuli.farm.po.Food;
import com.xuli.farm.po.Product;
import com.xuli.farm.po.ResultInfo;
import com.xuli.farm.service.FoodService;
import com.xuli.farm.service.impl.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String addFood() {
        return "admin/add_food";
    }


    @PostMapping("admin/save_food.html")
    @ResponseBody
    public ResultInfo saveFood(Food food) {
        ResultInfo resultInfo = null;
        Boolean flag = foodService.insertFood(food);
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;

    }


    @GetMapping("admin/editFood.html")
    public String editFoods(Model model, @RequestParam(value = "uid") int uid) {
        Food food = foodService.queryFoodById(uid);
        model.addAttribute("food", food);
        return "admin/editFood";

    }


    @PostMapping("admin/delFood.html")
    @ResponseBody
    public ResultInfo delFoods(Food food) {
        ResultInfo resultInfo = null;
        Boolean flag = foodService.deleteFoodById(food.getId());
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;
    }

    @GetMapping("foods.html")

    public String foods(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageInfo<Food> foodPageInfo = foodService.queryUserAll(pageNum, pageSize);

        model.addAttribute("foods", foodPageInfo);
        return "home/foods";
    }


    @GetMapping("foodDetails.html")
    public String activities(Model model, @RequestParam(value = "uid") int uid) {
        Food food = foodService.queryFoodById(uid);
        model.addAttribute("food", food);

        return "home/foodDetails";
    }
}
