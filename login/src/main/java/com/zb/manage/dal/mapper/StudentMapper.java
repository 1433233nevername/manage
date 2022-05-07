package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.StudentDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface StudentMapper {
    StudentDO findByName(@Param("name") String name);

    //查询所有学生信息
    List<StudentDO> findAll();

    void add(StudentDO student);

    void delete(@Param("id") BigInteger id);

    void update(StudentDO studentDO);

    StudentDO getById(@Param("id") BigInteger id);

    StudentDO getByNumber(@Param("number") BigInteger number);

    StudentDO findByAge(@Param("age") String age);
}

