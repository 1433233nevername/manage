package com.zb.manage.dal.model;

import java.math.BigInteger;
import java.util.Date;

public class Exam {
    private BigInteger id;

    private String lessonid;

    private Date creattime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getLessonid() {
        return lessonid;
    }

    public void setLessonid(String lessonid) {
        this.lessonid = lessonid;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        return "Exam{" + "id='" + id + '\'' + ", lessonid='" + lessonid + '\'' + ", creattime=" + creattime + '}';
    }
}
