package com.zb.manage.dal.model;

import java.math.BigInteger;
import java.util.Date;

public class Exam {
    private BigInteger id;

    private String lesson_id;

    private Date creat_time;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(String lesson_id) {
        this.lesson_id = lesson_id;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    @Override
    public String toString() {
        return "Exam{" + "id='" + id + '\'' + ", lesson_id='" + lesson_id + '\'' + ", creat_time=" + creat_time + '}';
    }
}
