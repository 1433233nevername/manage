package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.LessonDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface LessonMapper {
    LessonDO findByName(@Param("lename") String lename);

    //查询所有课程信息
    List<LessonDO> findAll();

    void add(LessonDO lesson);

    void delete(@Param("id") BigInteger id);

    void update(LessonDO lessonDO);

    LessonDO getByLenumber(@Param("lenumber") BigInteger lenumber);

    LessonDO getById(@Param("id") BigInteger id);
}

