package com.jacks.login.mapper;

import com.jacks.login.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {
   User findByName(@Param("username") String username);

   //查询所有用户信息
   List<User> findAll();

   void add(User user);
}

