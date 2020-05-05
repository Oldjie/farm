package com.xuli.farm.service;

import com.xuli.farm.po.IndexContent;

public interface IndexService {
    IndexContent queryIndexContentById(int i);

    Boolean updateContent(IndexContent indexContent);
}
