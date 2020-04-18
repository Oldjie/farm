package com.xuli.farm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuli.farm.exception.UserNameNotNullException;
import com.xuli.farm.exception.UserNameOrPasswordErrorException;
import com.xuli.farm.exception.UserNoActiveException;
import com.xuli.farm.mapper.UserMapper;
import com.xuli.farm.po.PageBean;
import com.xuli.farm.po.User;
import com.xuli.farm.service.UserService;
import com.xuli.farm.util.MailUtil;
import com.xuli.farm.util.Md5Util;
import com.xuli.farm.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void register(User user) throws Exception {
        user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        User queryUser = userMapper.selectOne(u);


        if (queryUser != null) {
            throw new UserNameNotNullException("用户名已存在！");
        }
        user.setStatus("N");
        user.setCode(UuidUtil.getUuid());
        user.setType("2");
        userMapper.insert(user);
        MailUtil.sendMail(user.getEmail(), "<h1>恭喜您！注册成功</h1><a href=http://localhost:80/user/active?code=" + user.getCode() + ">点击激活</a>");

    }

    @Override
    public Boolean active(String code) {
        User user = new User();
        user.setCode(code);
        User queryUser = userMapper.selectOne(user);
        queryUser.setStatus("Y");
        int count = userMapper.updateByPrimaryKey(queryUser);

        return count == 1;
    }

    @Override
    public User login(User user) throws Exception {
        user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
        User queryUser = userMapper.selectOne(user);
        if (queryUser == null) {
            throw new UserNameOrPasswordErrorException("用户名或者密码有误！");
        }
        if (queryUser.getStatus().equalsIgnoreCase("N")) {
            throw new UserNoActiveException("用户名未激活！");
        }
//        if (!queryUser.getType().equalsIgnoreCase("1")) {
//            throw new UserNoActiveException("权限不够！请使用管理员账号登录！");
//        }
        return queryUser;
    }

    @Override
    public User queryUserById(int uid) {
        User user = userMapper.selectByPrimaryKey(uid);
        return user;
    }

    @Override
    public PageInfo<User> queryUserAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
//        PageBean<User> pageBean = new PageBean<>();


        return pageInfo;
    }

    @Override
    public Boolean addUser(User user) {
        return null;
    }

    @Override
    public Boolean updateUser(User user) {
        User oldUser = userMapper.selectByPrimaryKey(user.getUid());
        user.setType(oldUser.getType());
        user.setPassword(oldUser.getPassword());
        user.setType(oldUser.getCode());
        user.setType(oldUser.getStatus());
        int i = userMapper.updateByPrimaryKey(user);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean deleteUserById(Integer uid) {
        int i = userMapper.deleteByPrimaryKey(uid);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<User> getUserList(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }


}
