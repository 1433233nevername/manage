package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.TeacherDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface TeacherMapper {
    TeacherDO findByName(@Param("teachername") String teachername);

    //查询所有用户信息
    List<TeacherDO> findAll();

    void add(TeacherDO teacher);

    void delete(@Param("id") BigInteger id);

    void update(TeacherDO teacherDO);

    TeacherDO getByTeachid(@Param("teachid") BigInteger teachid);

    TeacherDO getById(@Param("id") BigInteger id);
}

