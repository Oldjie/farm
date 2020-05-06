package com.xuli.farm.service;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.Food;

public interface FoodService {
    PageInfo<Food> queryUserAll(int pageNum, int pageSize);

    Boolean insertFood(Food food);

    Food queryFoodById(int uid);

    Boolean deleteFoodById(Integer id);

    Boolean updateFood(Food food);
}
