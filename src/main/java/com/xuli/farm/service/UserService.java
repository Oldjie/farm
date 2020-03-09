package com.xuli.farm.service;

import com.xuli.farm.mapper.UserMapper;
import com.xuli.farm.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UserService {

    void register(User user) throws Exception;

    Boolean active(String code);

    User login(User user) throws Exception;

    User queryUserById(int uid);

    Boolean addUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUserById(Integer uid);
}