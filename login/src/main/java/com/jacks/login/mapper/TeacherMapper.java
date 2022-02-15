package com.jacks.login.mapper;

import com.jacks.login.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
   Teacher findByName(@Param("teachername") String teachername);

   //查询所有用户信息
   List<Teacher> findAll();

   void add(Teacher teacher);

   void delete(@Param("id") BigInteger id);

   void update(Teacher teacher);

   Teacher getById(@Param("id") BigInteger id);
}

