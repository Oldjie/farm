package com.xuli.farm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuli.farm.mapper.FoodMapper;
import com.xuli.farm.po.Food;
import com.xuli.farm.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
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

    @Override
    public Boolean insertFood(Food food) {
        int i = foodMapper.insert(food);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Food queryFoodById(int uid) {
        Food food = foodMapper.selectByPrimaryKey(uid);
        return food;
    }

    @Override
    public Boolean deleteFoodById(Integer id) {
        int i = foodMapper.deleteByPrimaryKey(id);
        if (i==0){
            return false;
        }else {
            return true;
        }
    }
}
