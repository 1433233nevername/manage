package com.zb.manage.biz.service;

import com.zb.manage.biz.vo.RecordVO;
import com.zb.manage.dal.mapper.RecordMapper;
import com.zb.manage.dal.mapper.StudentMapper;
import com.zb.manage.dal.model.Record;
import com.zb.manage.dal.model.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.*;

@Service
public class RecordService {
    @Resource
    private RecordMapper recordMapper;

    @Resource
    private StudentMapper studentMapper;

    public List<RecordVO> findAll() {
        List<Record> recordList = recordMapper.findAll();
        List<Student> studentList = studentMapper.findAll();
        Map<BigInteger, String> studentMap = new HashMap<>();
        studentList.forEach(student -> studentMap.put(student.getId(), student.getName()));
        List<RecordVO> recordVOList = new ArrayList<>();

        for (Record record : recordList) {
            RecordVO recordVO = new RecordVO();
            BeanUtils.copyProperties(record, recordVO);

            recordVO.setStudentName(studentMap.get(recordVO.getStudent_id()));
            recordVOList.add(recordVO);
        }
        return recordVOList;
    }


    public void add(BigInteger id, BigInteger exam_id, BigInteger student_id, Integer score) {
        Record record = new Record();
        record.setId(id);
        record.setExam_id(exam_id);
        record.setStudent_id(student_id);
        record.setScore(score);
        record.setCreat_time(new Date());
        recordMapper.add(record);
    }

    public void delete(BigInteger id) {
        recordMapper.delete(id);
    }

    public void update(Record Record) {
        recordMapper.update(Record);
    }

    public Record getById(BigInteger id) {
        return recordMapper.getById(id);
    }
 }

