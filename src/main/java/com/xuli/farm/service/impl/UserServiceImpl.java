package com.xuli.farm.service.impl;

import com.xuli.farm.exception.UserNameOrPasswordErrorException;
import com.xuli.farm.exception.UserNoActiveException;
import com.xuli.farm.mapper.UserMapper;
import com.xuli.farm.po.User;
import com.xuli.farm.service.UserService;
import com.xuli.farm.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) throws Exception {

    }

    @Override
    public Boolean active(String code) {
        return null;
    }

    @Override
    public User login(User user) throws Exception {
//        user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
        User queryUser = userMapper.selectOne(user);
        if (queryUser == null) {
            throw new UserNameOrPasswordErrorException("用户名或者密码有误！");
        }
        if (queryUser.getStatus().equalsIgnoreCase("N")) {
            throw new UserNoActiveException("用户名未激活！");
        }
        if (!queryUser.getType().equalsIgnoreCase("1")) {
            throw new UserNoActiveException("权限不够！请使用管理员账号登录！");
        }
        return queryUser;
    }

    @Override
    public User queryUserById(int uid) {
        return null;
    }

    @Override
    public Boolean addUser(User user) {
        return null;
    }

    @Override
    public Boolean updateUser(User user) {
        return null;
    }

    @Override
    public Boolean deleteUserById(Integer uid) {
        return null;
    }
}
