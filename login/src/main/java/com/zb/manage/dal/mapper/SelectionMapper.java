package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.Selection;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface SelectionMapper {
   //查询所有用户信息
   List<Selection> findAll();

   void add(Selection selection);

   void delete(@Param("id") BigInteger id);

   void update(Selection selection);

    Selection getById(@Param("id") BigInteger id);
}

