package com.xuli.farm.service;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.Food;

public interface FoodService {
    PageInfo<Food> queryUserAll(int pageNum, int pageSize);
}
