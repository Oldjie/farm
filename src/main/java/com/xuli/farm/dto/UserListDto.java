package com.xuli.farm.dto;


import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.User;

import java.util.List;

public class UserListDto {
    private List<User> users;


    public UserListDto(List<User> users, PageInfo pageInfo) {
        this.users = users;
        this.pageInfo = pageInfo;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }



    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    private PageInfo pageInfo;

}
