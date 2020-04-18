package com.xuli.farm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuli.farm.mapper.ActivitisMapper;
import com.xuli.farm.po.Activities;
import com.xuli.farm.po.Feedback;
import com.xuli.farm.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import java.util.List;
@Service
public class ActivitiesServiceImpl implements ActivitiesService {
    @Autowired
    private ActivitisMapper activitisMapper;

    @Override
    public PageInfo<Activities> queryUserAll(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Activities> activities = activitisMapper.selectAll();
        PageInfo<Activities> pageInfo = new PageInfo<>(activities);


        return pageInfo;
    }
}
