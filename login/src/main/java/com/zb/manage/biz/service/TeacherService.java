package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.TeacherMapper;
import com.zb.manage.dal.model.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    public Teacher getByName(String taachername) {
return teacherMapper.findByName(taachername);
    }

    public void add(BigInteger id, String teachid, String teachername) {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setTeachid(teachid);
        teacher.setTeachername(teachername);
        teacher.setTime(new Date());
        teacherMapper.add(teacher);
    }

    public void delete(BigInteger id) {
        teacherMapper.delete(id);
    }

    public void update(Teacher teacher) {
        teacherMapper.update(teacher);
    }

    public Teacher getById(BigInteger id) {
        return teacherMapper.getById(id);
    }
 }

