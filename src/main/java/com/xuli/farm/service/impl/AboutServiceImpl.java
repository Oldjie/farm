package com.xuli.farm.service.impl;

import com.xuli.farm.mapper.AboutMapper;
import com.xuli.farm.po.About;
import com.xuli.farm.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutMapper aboutMapper;

    @Override
    public About queryAboutById(int aid) {

        About about = aboutMapper.selectByPrimaryKey(aid);
        return about;


    }

    @Override
    public Boolean updateUser(About about) {
        int i = aboutMapper.updateByPrimaryKey(about);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }
}
