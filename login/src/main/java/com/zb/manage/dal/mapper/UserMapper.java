package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    UserDO findByName(@Param("username") String username);

    //查询所有用户信息
    List<UserDO> findAll();

    void add(UserDO user);

}

