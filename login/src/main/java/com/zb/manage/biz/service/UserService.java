package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.UserMapper;
import com.zb.manage.dal.model.UserDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<UserDO> findAll() {
        return userMapper.findAll();
    }

    public UserDO getByName(String userName) {
        return userMapper.findByName(userName);
    }

    public void add(String username, String password) {
        UserDO userDO = new UserDO();
        userDO.setUsername(username);
        userDO.setPassword(password);
        userMapper.add(userDO);
    }
}

