package com.jacks.login.pojo;

import java.math.BigInteger;
import java.util.Date;

public class Lesson {
    private BigInteger id;

    private String lename;

    private String lenumber;

    private  String teachid;

    private String letime;

    private Date cretime;

    public void setId(BigInteger id){
        this.id = id;
    }

    public BigInteger getId(){
        return id;
    }

    public void setLename(String lename){
        this.lename = lename;
    }

    public String getLename(){
        return lename;
    }

    public void setTeachid(String teachid){
        this.teachid = teachid;
    }

    public String getTeachid(){
        return teachid;
    }

    public String getLenumber(){
        return lenumber;
    }

    public void setLenumber(String lenumber){
        this.lenumber = lenumber;
    }

    public String getLetime(){
        return letime;
    }

    public void setLetime(String letime){
        this.letime = letime;
    }

    public Date getCretime(){
        return cretime;
    }

    public void setCretime(Date cretime){
        this.cretime = cretime;
    }

    @Override
    public String toString() {
        return "Lesson{" + ", name=" + lename + '\'' + ", lenumber=" + lename + '\'' + ", letime=" + letime + '\'' + ", cretime=" + cretime + '}';
    }
}
