package com.zb.manage.dal.mapper;
import com.zb.manage.dal.model.Exam;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface ExamMapper {
    Exam findByLesson_id(@Param("lesson_id") String lesson_id);

    List<Exam> findAll();

    void add(Exam exam);

    void delete(@Param("id") BigInteger id);

    void update(Exam exam);

    Exam getById(@Param("id") BigInteger id);
}
