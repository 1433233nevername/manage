package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.Record;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface RecordMapper {

   //查询所有用户信息
   List<Record> findAll();

   void add(Record Record);

   void delete(@Param("id") BigInteger id);

   void update(Record Record);

   Record getById(@Param("id") BigInteger id);
}

