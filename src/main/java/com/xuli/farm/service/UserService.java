package com.xuli.farm.service;

import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.PageBean;
import com.xuli.farm.po.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void register(User user) throws Exception;

    Boolean active(String code);

    User login(User user) throws Exception;

    User queryUserById(int uid);

    PageInfo<User> queryUserAll(int pageNum, int pageSize);

    Boolean addUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUserById(Integer uid);

    List<User> getUserList(int pageNum, int pageSize);

    List<User> selectAll();
}