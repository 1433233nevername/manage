package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.Student;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface StudentMapper {
   Student findByName(@Param("name") String name);

   //查询所有学生信息
   List<Student> findAll();

   void add(Student student);

    void delete(@Param("id") BigInteger id);

    void update(Student student);

    Student getById(@Param("id") BigInteger id);

    Student getByNumber(@Param("number") BigInteger number);

    Student findByAge(@Param("age") String age);
}

