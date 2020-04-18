package com.xuli.farm.service;

import com.xuli.farm.po.About;
import org.springframework.stereotype.Service;


@Service
public interface AboutService {
    About queryAboutById(int aid);

    Boolean updateUser(About about);
}
