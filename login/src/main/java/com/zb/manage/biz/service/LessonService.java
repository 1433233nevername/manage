package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.LessonMapper;
import com.zb.manage.dal.model.Lesson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class LessonService {
    @Resource
    private LessonMapper lessonMapper;

    public List<Lesson> findAll() {
        return lessonMapper.findAll();
    }
    public void add(BigInteger id, String lename, String lenumber, String teachid, String letime) {
        Lesson lesson = new Lesson();
        lesson.setId(id);
        lesson.setLename(lename);
        lesson.setLenumber(lenumber);
        lesson.setTeachid(teachid);
        lesson.setLetime(letime);
        lesson.setCretime(new Date());
        lessonMapper.add(lesson);
    }

    public void delete(BigInteger id) {
        lessonMapper.delete(id);
    }

    public void update(Lesson lesson){
        lessonMapper.update(lesson);
    }

    public Lesson getById(BigInteger id) {
        return lessonMapper.getById(id);
    }

}

