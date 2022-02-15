package com.jacks.login.mapper;

import com.jacks.login.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
   Student findByName(@Param("name") String name);

   //查询所有学生信息
   List<Student> findAll();

   void add(Student student);

    void delete(@Param("id") BigInteger id);

    void update(Student student);

    Student getById(@Param("id") BigInteger id);

    Student findByAge(@Param("age") String age);
}

