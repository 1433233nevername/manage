package com.zb.manage.dal.model;

import java.math.BigInteger;
import java.util.Date;

public class Record {
    private BigInteger id;

    private BigInteger exam_id;

    private BigInteger student_id;

    private Integer score;

    private Date creat_time;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getExam_id() {
        return exam_id;
    }

    public void setExam_id(BigInteger exam_id) {
        this.exam_id = exam_id;
    }

    public BigInteger getStudent_id() {
        return student_id;
    }

    public void setStudent_id(BigInteger student_id) {
        this.student_id = student_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", exam_id=" + exam_id +
                ", student_id=" + student_id +
                ", score=" + score +
                ", creat_time=" + creat_time +
                '}';
    }
}
