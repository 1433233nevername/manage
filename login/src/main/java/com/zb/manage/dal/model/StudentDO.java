package com.zb.manage.dal.model;

import java.math.BigInteger;
import java.util.Date;

public class StudentDO {
    private BigInteger id;

    private String name;

    private BigInteger number;

    private String age;

    private String entime;

    private Date retime;

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEntime() {
        return entime;
    }

    public void setEntime(String entime) {
        this.entime = entime;
    }

    public Date getRetime() {
        return retime;
    }

    public void setRetime(Date retime) {
        this.retime = retime;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", number='" + number + '\'' + ", age=" + age + '\'' + ", entime='" + entime + '\'' + ", retiem=" + retime + '}';
    }
}
