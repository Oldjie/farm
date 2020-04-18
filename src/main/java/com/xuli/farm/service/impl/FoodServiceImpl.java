package com.xuli.farm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuli.farm.mapper.FoodMapper;
import com.xuli.farm.po.Food;
import com.xuli.farm.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;
    @Override
    public PageInfo<Food> queryUserAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Food> foods = foodMapper.selectAll();
        PageInfo<Food> pageInfo = new PageInfo<>(foods);
        return pageInfo;
    }
}
