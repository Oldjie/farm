package com.xuli.farm.mapper;


import com.xuli.farm.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {

}
