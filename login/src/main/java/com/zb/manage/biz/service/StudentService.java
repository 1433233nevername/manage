package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.RecordMapper;
import com.zb.manage.dal.mapper.SelectionMapper;
import com.zb.manage.dal.mapper.StudentMapper;
import com.zb.manage.dal.model.StudentDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Resource
    private SelectionMapper selectionMapper;

    @Resource
    private RecordMapper recordMapper;

    public List<StudentDO> findAll() {
        return studentMapper.findAll();
    }

    public StudentDO getByName(String name) {
        return studentMapper.findByName(name);
    }

    public void add(BigInteger id, String name, BigInteger number, String age, String entime) {
        StudentDO student = new StudentDO();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setEntime(entime);
        student.setRetime(new Date());
        student.setNumber(number);
        studentMapper.add(student);
    }

    public void delete(BigInteger id) {
        int selectionCount = selectionMapper.countByStudentId(id);
        if (selectionCount > 0) {
            throw new IllegalArgumentException("学生表有依赖此课程，不得删除");
        }
        int recordCount = recordMapper.countByStudentId(id);
        if(recordCount > 0) {
            throw new IllegalArgumentException("学生表有依赖此课程，不得删除");
        }
        studentMapper.delete(id);
    }

    public void update(StudentDO student) {
        studentMapper.update(student);
    }

    public StudentDO getById(BigInteger id) {
        return studentMapper.getById(id);
    }

    public StudentDO getByAge(String age) {
        return studentMapper.findByAge(age);
    }
}

