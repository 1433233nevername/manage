package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.ExamMapper;
import com.zb.manage.dal.model.Exam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class ExamService {
    @Resource
    private ExamMapper examMapper;


    public List<Exam> findAll() {
        return examMapper.findAll();
    }

    public void add(BigInteger id, String lessonid) {
        Exam exam = new Exam();
        exam.setId(id);
        exam.setLessonid(lessonid);
        exam.setCreattime(new Date());
        examMapper.add(exam);
    }

    public void delete(BigInteger id) {
        examMapper.delete(id);
    }

    public void update(Exam exam) {
        examMapper.update(exam);
    }

    public Exam getById(BigInteger id) {
        return examMapper.getById(id);
    }
}
