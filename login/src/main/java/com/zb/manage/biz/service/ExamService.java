package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.ExamMapper;
import com.zb.manage.dal.mapper.LessonMapper;
import com.zb.manage.dal.mapper.RecordMapper;
import com.zb.manage.dal.model.ExamDO;
import com.zb.manage.dal.model.LessonDO;
import com.zb.manage.dal.model.RecordDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class ExamService {
    @Resource
    private ExamMapper examMapper;

    @Resource
    private LessonMapper lessonMapper;

    @Resource
    private RecordMapper recordMapper;

    public List<ExamDO> findAll() {
        return examMapper.findAll();
    }

    public void add(BigInteger id, BigInteger lessonid) {
        LessonDO lesson = lessonMapper.getByLenumber(lessonid);
        if (null == lesson) {
            throw new IllegalArgumentException("课程ID不合法:" + lessonid);
        }
        ExamDO exam = new ExamDO();
        exam.setId(id);
        exam.setLessonid(lessonid);
        exam.setCreattime(new Date());
        examMapper.add(exam);
    }

    public void delete(BigInteger id) {
        List<RecordDO> recordList = recordMapper.findByExamId(id);
        if (recordList.size() > 0) {
            throw new IllegalArgumentException("该考试不能删除,请先删除对应信息");
        }
        examMapper.delete(id);
    }

    public void update(ExamDO exam) {
        examMapper.update(exam);
    }

    public ExamDO getById(BigInteger id) {
        return examMapper.getById(id);
    }
}
