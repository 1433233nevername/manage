package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.StudentMapper;
import com.zb.manage.dal.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Resource
    private StudentMapper studentMapper;

    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    public Student getByName(String name) {
        return studentMapper.findByName(name);
    }

    public void add(BigInteger id, String name, BigInteger number, String age, String entime) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setEntime(entime);
        student.setRetime(new Date());
        student.setNumber(number);
        studentMapper.add(student);
    }

    public void delete(BigInteger id) {
        studentMapper.delete(id);
    }

    public void update(Student student) {
        studentMapper.update(student);
    }

    public Student getById(BigInteger id) {
        return studentMapper.getById(id);
    }

    public Student getByAge(String age) {
        return studentMapper.findByAge(age);
    }
}

