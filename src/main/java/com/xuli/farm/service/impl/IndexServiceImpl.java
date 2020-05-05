package com.xuli.farm.service.impl;

import com.xuli.farm.mapper.IndexMapper;
import com.xuli.farm.po.IndexContent;
import com.xuli.farm.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;

    @Override
    public IndexContent queryIndexContentById(int i) {
        IndexContent index = indexMapper.selectByPrimaryKey(i);
        return index;
    }

    @Override
    public Boolean updateContent(IndexContent indexContent) {
        int count = indexMapper.updateByPrimaryKey(indexContent);
        return count == 1;
    }
}
