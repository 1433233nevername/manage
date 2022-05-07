package com.zb.manage.biz.vo;

import com.zb.manage.dal.model.RecordDO;

public class RecordVO extends RecordDO {

    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
