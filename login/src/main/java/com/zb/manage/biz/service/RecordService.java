package com.zb.manage.biz.service;

import com.zb.manage.biz.vo.RecordVO;
import com.zb.manage.dal.mapper.ExamMapper;
import com.zb.manage.dal.mapper.RecordMapper;
import com.zb.manage.dal.mapper.StudentMapper;
import com.zb.manage.dal.model.ExamDO;
import com.zb.manage.dal.model.RecordDO;
import com.zb.manage.dal.model.StudentDO;
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

    @Resource
    private ExamMapper examMapper;

    public List<RecordVO> findAll() {
        List<RecordDO> recordList = recordMapper.findAll();
        List<StudentDO> studentList = studentMapper.findAll();
        Map<BigInteger, String> studentMap = new HashMap<>();
        studentList.forEach(student -> studentMap.put(student.getId(), student.getName()));
        List<RecordVO> recordVOList = new ArrayList<>();

        for (RecordDO record : recordList) {
            RecordVO recordVO = new RecordVO();
            BeanUtils.copyProperties(record, recordVO);

            recordVO.setStudentName(studentMap.get(recordVO.getStudentid()));
            recordVOList.add(recordVO);
        }
        return recordVOList;
    }


    public void add(BigInteger id, BigInteger examid, BigInteger studentid, Integer score) {
        ExamDO exam = examMapper.getById(examid);
        if (null == exam) {
            throw new IllegalArgumentException("考试ID不合法:" + examid);
        }
        StudentDO student = studentMapper.getByNumber(studentid);
        if (null == student) {
            throw new IllegalArgumentException("学生ID不合法:" + studentid);
        }
        RecordDO record = new RecordDO();
        record.setId(id);
        record.setExamid(examid);
        record.setStudentid(studentid);
        record.setScore(score);
        record.setCreattime(new Date());
        recordMapper.add(record);
    }

    public void delete(BigInteger id) {
        recordMapper.delete(id);
    }

    public void update(RecordDO Record) {
        recordMapper.update(Record);
    }

    public RecordDO getById(BigInteger id) {
        return recordMapper.getById(id);
    }
}

