package com.jacks.login.mapper;

import com.jacks.login.pojo.Selection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Repository
public interface SelectionMapper {
   //查询所有用户信息
   List<Selection> findAll();

   Selection findByTescore(@Param("tescore") String tescore);

   void add(Selection selection);

   void delete(@Param("id") BigInteger id);

   void update(Selection selection);

    Selection getById(@Param("id") BigInteger id);
}

