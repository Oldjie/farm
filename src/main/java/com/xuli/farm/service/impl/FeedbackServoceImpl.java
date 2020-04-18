package com.xuli.farm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuli.farm.mapper.FeedbackMapper;
import com.xuli.farm.po.Feedback;
import com.xuli.farm.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServoceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;
    @Override
    public Boolean addFeedback(Feedback feedback) {
        int status = feedbackMapper.insert(feedback);
        if (status == 0) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public PageInfo<Feedback> queryUserAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Feedback> feedback = feedbackMapper.selectAll();
        PageInfo<Feedback> pageInfo = new PageInfo<Feedback>(feedback);


        return pageInfo;
    }
}
