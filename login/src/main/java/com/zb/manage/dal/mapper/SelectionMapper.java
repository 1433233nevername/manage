package com.zb.manage.dal.mapper;

import com.zb.manage.dal.model.SelectionDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface SelectionMapper {
    //查询所有用户信息
    List<SelectionDO> findAll();

    void add(SelectionDO selection);

    void delete(@Param("id") BigInteger id);

    void update(SelectionDO selectionDO);

    SelectionDO getById(@Param("id") BigInteger id);

    int countByLessonId(@Param("lessonId") BigInteger lessonId);

    int countByStudentId(@Param("studentId") BigInteger studentId);
}

