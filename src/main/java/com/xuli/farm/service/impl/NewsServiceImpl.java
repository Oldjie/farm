package com.xuli.farm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuli.farm.mapper.NewsMppaer;
import com.xuli.farm.po.Feedback;
import com.xuli.farm.po.News;
import com.xuli.farm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMppaer newsMppaer;

    @Override
    public PageInfo<News> queryUserAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> News = newsMppaer.selectAll();
        PageInfo<News> pageInfo = new PageInfo<News>(News);
        return pageInfo;
    }

    @Override
    public News queryUserById(int uid) {
        News news = newsMppaer.selectByPrimaryKey(uid);
        return news;
    }

    @Override
    public Boolean insertNews(News news) {

        int i = newsMppaer.insert(news);

        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean updateUser(News news) {
        int i = newsMppaer.updateByPrimaryKey(news);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        int i = newsMppaer.deleteByPrimaryKey(id);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }
}
