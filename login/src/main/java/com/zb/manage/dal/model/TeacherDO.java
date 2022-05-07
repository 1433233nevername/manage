package com.zb.manage.dal.model;

import java.math.BigInteger;
import java.util.Date;

public class TeacherDO {
    private BigInteger id;

    private String teachid;

    private String teachername;

    private Date time;

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public String getTeachid() {
        return teachid;
    }

    public void setTeachid(String teachid) {
        this.teachid = teachid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Teacher{" + ", id=" + id + '\'' + ", teachid=" + teachid + '\'' + ", teachername=" + teachername + '\'' + ", time=" + time + '}';
    }
}
