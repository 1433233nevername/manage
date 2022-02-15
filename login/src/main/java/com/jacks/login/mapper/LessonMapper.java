package com.jacks.login.mapper;

import com.jacks.login.pojo.Lesson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Repository
public interface LessonMapper {
   Lesson findByName(@Param("lename") String lename);
   //查询所有课程信息
   List<Lesson> findAll();

   void add(Lesson lesson);

   void delete(@Param("id") BigInteger id);

   void update(Lesson lesson);

   Lesson getById(@Param("id") BigInteger id);
}

