package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.UserMapper;
import com.zb.manage.dal.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User getByName(String userName) {
        return userMapper.findByName(userName);
    }

    public void add(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.add(user);
    }
}

