package com.xuli.farm.service;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.News;
import org.springframework.stereotype.Service;

@Service
public interface NewsService {
    PageInfo<News> queryUserAll(int pageNum, int pageSize);

    News queryUserById(int uid);

    Boolean insertNews(News news);

    Boolean updateUser(News news);

    Boolean deleteUserById(Integer id);
}
