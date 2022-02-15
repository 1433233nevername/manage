package com.jacks.login.pojo;

import java.math.BigInteger;
import java.util.Date;

public class Teacher {
    private BigInteger id;

    private String teacheid;

    private String teachername;

    private Date time;

    public void setId(BigInteger id){
        this.id = id;
    }

    public BigInteger getId(){
        return id;
    }

    public String getTeacheid() {
        return teacheid;
    }

    public void setTeacheid(String teacheid) {
        this.teacheid = teacheid;
    }

    public String getTeachername(){
        return teachername;
    }

    public void setTeachername(String teachername){
        this.teachername = teachername;
    }

    public Date getTime(){
        return time;
    }

    public void setTime(Date time ){
        this.time = time;
    }

    @Override
    public String toString() {
        return "Teacher{" + ", id=" + id + '\'' + ", teachername=" + teachername + '\'' + ", time=" + time + '}';
    }
}
