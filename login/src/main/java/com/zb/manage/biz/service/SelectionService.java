package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.LessonMapper;
import com.zb.manage.dal.mapper.SelectionMapper;
import com.zb.manage.dal.mapper.StudentMapper;
import com.zb.manage.dal.model.Lesson;
import com.zb.manage.dal.model.Selection;
import com.zb.manage.dal.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class SelectionService {
    @Resource
    private SelectionMapper selectionMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private LessonMapper lessonMapper;

    public List<Selection> findAll() {
        return selectionMapper.findAll();
    }

    public void add(BigInteger id, BigInteger stuid, BigInteger lesid,String tescore) {
        Student student = studentMapper.getByNumber(stuid);
        if(null == student) {
            throw new IllegalArgumentException("学生ID不合法:" + stuid);
        }
        Lesson lesson = lessonMapper.getByLenumber(lesid);
        if(null == lesson) {
            throw new IllegalArgumentException("课程ID不合法:" + lesid);
        }
        Selection selection = new Selection();
        selection.setId(id);
        selection.setStuid(stuid);
        selection.setLesid(lesid);
        selection.setTescoree(tescore);
        selection.setSetime(new Date());
        selectionMapper.add(selection);
    }

    public void delete(BigInteger id) {
        selectionMapper.delete(id);
    }

    public void update(Selection selection) {
        selectionMapper.update(selection);
    }

    public Selection getById(BigInteger id) {
        return selectionMapper.getById(id);
    }
}

