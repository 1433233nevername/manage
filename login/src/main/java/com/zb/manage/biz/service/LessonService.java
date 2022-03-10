package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.LessonMapper;
import com.zb.manage.dal.mapper.SelectionMapper;
import com.zb.manage.dal.model.Lesson;
import com.zb.manage.dal.mapper.TeacherMapper;
import com.zb.manage.dal.model.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class LessonService {
    @Resource
    private LessonMapper lessonMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private SelectionMapper selectionMapper;

    public List<Lesson> findAll() {
        return lessonMapper.findAll();
    }

    public void add(BigInteger id, String lename, BigInteger lenumber, BigInteger teachid, String letime) {
        Teacher teacher = teacherMapper.getByTeachid(teachid);
        if (null == teacher) {
            throw new IllegalArgumentException("教师ID不合法:" + teachid);
        }
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
        int selectionCount = selectionMapper.countByLessonId(id);
        if (selectionCount > 0) {
            throw new IllegalArgumentException("选课表有依赖此课程，不得删除");
        }
        lessonMapper.delete(id);
    }

    public void update(Lesson lesson) {
        lessonMapper.update(lesson);
    }

    public Lesson getById(BigInteger id) {
        return lessonMapper.getById(id);
    }

}

