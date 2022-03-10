package com.zb.manage.dal.model;

import java.math.BigInteger;
import java.util.Date;

public class Record {
    private BigInteger id;

    private BigInteger examid;

    private BigInteger studentid;

    private Integer score;

    private Date creattime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getExamid() {
        return examid;
    }

    public void setExamid(BigInteger examid) {
        this.examid = examid;
    }

    public BigInteger getStudentid() {
        return studentid;
    }

    public void setStudentid(BigInteger studentid) {
        this.studentid = studentid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", examid=" + examid +
                ", studentid=" + studentid +
                ", score=" + score +
                ", creattime=" + creattime +
                '}';
    }
}
