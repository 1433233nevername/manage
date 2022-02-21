package com.zb.manage.dal.model;

public class User {
    private Integer id;

    private String username;

    private String password;
    private String addr;
    private String love;
    private String birthday;
    private String education;
    private String sex;
    public String getAddr(){
        return addr;
    }
    public void setAddr(String addr){
        this.addr=addr;
    }
    public String getLove(){
        return love;
    }
    public void setLove(String love){
        this.love=love;
    }
    public String getBirthday(){
        return birthday;
    }
    public void setBirthday(String birthday){
       this.birthday=birthday;
    }
    public String getEducation(){
        return education;
    }
    public void setEducation(String education){
        this.education=education;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", addr='" + addr + '\'' + ", love=" + love + '\''+", birthday='" + birthday + '\'' + ", education=" + education + '\''+", sex='" + sex +'}';
    }
}
