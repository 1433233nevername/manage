package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface TeacherMapper {
   Teacher findByName(@Param("teachername") String teachername);

   //查询所有用户信息
   List<Teacher> findAll();

   void add(Teacher teacher);

   void delete(@Param("id") BigInteger id);

   void update(Teacher teacher);

   Teacher getById(@Param("id") BigInteger id);
}

