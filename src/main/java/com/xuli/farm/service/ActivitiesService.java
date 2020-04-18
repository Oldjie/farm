package com.xuli.farm.service;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.Activities;

public interface ActivitiesService {
    PageInfo<Activities> queryUserAll(int pageNum, int pageSize);
}
