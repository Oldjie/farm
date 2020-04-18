package com.xuli.farm.service;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.Feedback;
import com.xuli.farm.po.User;

public interface FeedbackService {
    Boolean addFeedback(Feedback feedback);

    PageInfo<Feedback> queryUserAll(int pageNum, int pageSize);
}
