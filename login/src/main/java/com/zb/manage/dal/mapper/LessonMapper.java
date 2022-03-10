package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.Lesson;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface LessonMapper {
    Lesson findByName(@Param("lename") String lename);

    //查询所有课程信息
    List<Lesson> findAll();

    void add(Lesson lesson);

    void delete(@Param("id") BigInteger id);

    void update(Lesson lesson);

    Lesson getByLenumber(@Param("lenumber") BigInteger lenumber);

    Lesson getById(@Param("id") BigInteger id);
}

