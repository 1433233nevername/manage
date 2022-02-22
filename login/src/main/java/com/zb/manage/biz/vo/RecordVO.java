package com.zb.manage.biz.vo;

import com.zb.manage.dal.model.Record;

import java.math.BigInteger;

public class RecordVO extends Record {

    private String studentName;

    private BigInteger studentNumber;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public BigInteger getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(BigInteger studentNumber) {
        this.studentNumber = studentNumber;
    }
}
