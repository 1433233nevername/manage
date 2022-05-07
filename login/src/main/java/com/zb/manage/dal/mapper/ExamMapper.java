package com.zb.manage.dal.mapper;
import com.zb.manage.dal.model.ExamDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface ExamMapper {

    List<ExamDO> findAll();

    void add(ExamDO exam);

    void delete(@Param("id") BigInteger id);

    void update(ExamDO exam);

    ExamDO getById(@Param("id") BigInteger id);


}
