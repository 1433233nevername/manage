package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.ExamMapper;
import com.zb.manage.dal.mapper.LessonMapper;
import com.zb.manage.dal.mapper.RecordMapper;
import com.zb.manage.dal.model.Exam;
import com.zb.manage.dal.model.Lesson;
import com.zb.manage.dal.model.Record;
import com.zb.manage.web.controller.LessonController;
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

    public List<Exam> findAll() {
        return examMapper.findAll();
    }

    public void add(BigInteger id, BigInteger lessonid) {
        Lesson lesson = lessonMapper.getByLenumber(lessonid);
        if (null == lesson) {
            throw new IllegalArgumentException("课程ID不合法:" + lessonid);
        }
        Exam exam = new Exam();
        exam.setId(id);
        exam.setLessonid(lessonid);
        exam.setCreattime(new Date());
        examMapper.add(exam);
    }

    public void delete(BigInteger id) {
        List<Record> recordList = recordMapper.findByExamId(id);
        if (recordList.size() > 0) {
            throw new IllegalArgumentException("该考试不能删除,请先删除对应信息");
        }
        examMapper.delete(id);
    }

    public void update(Exam exam) {
        examMapper.update(exam);
    }

    public Exam getById(BigInteger id) {
        return examMapper.getById(id);
    }
}
