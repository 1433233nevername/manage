package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.RecordDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface RecordMapper {

    //查询所有用户信息
    List<RecordDO> findAll();

    void add(RecordDO Record);

    void delete(@Param("id") BigInteger id);

    void update(RecordDO RecordDO);

    RecordDO getById(@Param("id") BigInteger id);

    List<RecordDO> findByExamId(@Param("examId") BigInteger examId);

    int countByStudentId(@Param("studentId") BigInteger studentId);
}

