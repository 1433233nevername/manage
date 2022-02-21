package com.zb.manage.dal.model;

import java.math.BigInteger;
import java.util.Date;

public class Selection {
    private BigInteger id;

    private String stuid;

    private String lesid;

    private Date setime;

    private String tescore;

    public void setId(BigInteger id){
        this.id = id;
    }

    public BigInteger getId(){
        return id;
    }

    public void setStuid(String stuid){
        this.stuid = stuid;
    }

    public String getStuid(){
        return stuid;
    }

    public String getLesid(){
        return lesid;
    }

    public void setLesid(String lesid){
        this.lesid = lesid;
    }

    public Date getSetime(){
        return setime;
    }

    public void setSetime(Date setime){
        this.setime = setime;
    }

    public String getTescore(){
        return tescore;
    }

    public void setTescoree(String tescore){
        this.tescore = tescore;
    }

    @Override
    public String toString() {
        return "Stu_les{" + ", stuid=" + stuid + '\'' + ", lesid=" + lesid + '\'' + ", setime=" + setime + '\'' + ", tescore=" + tescore + '}';
    }
}
