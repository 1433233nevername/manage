package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.TeacherMapper;
import com.zb.manage.dal.model.TeacherDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    public List<TeacherDO> findAll() {
        return teacherMapper.findAll();
    }

    public TeacherDO getByName(String taachername) {
        return teacherMapper.findByName(taachername);
    }

    public void add(BigInteger id, String teachid, String teachername) {
        TeacherDO teacher = new TeacherDO();
        teacher.setId(id);
        teacher.setTeachid(teachid);
        teacher.setTeachername(teachername);
        teacher.setTime(new Date());
        teacherMapper.add(teacher);
    }

    public void delete(BigInteger id) {
        teacherMapper.delete(id);
    }

    public void update(TeacherDO teacher) {
        teacherMapper.update(teacher);
    }

    public TeacherDO getById(BigInteger id) {
        return teacherMapper.getById(id);
    }
}

