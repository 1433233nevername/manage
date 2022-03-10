package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User findByName(@Param("username") String username);

    //查询所有用户信息
    List<User> findAll();

    void add(User user);
}

