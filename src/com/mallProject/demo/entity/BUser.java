package com.mallProject.demo.entity;

import java.util.Date;

public class BUser {
    private Integer uid;

    private String uname;

    private String upwd;

    private String uphone;

    private String usex;

    private Date uregistetime;

    private Date ulastdate;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex == null ? null : usex.trim();
    }

    public Date getUregistetime() {
        return uregistetime;
    }

    public void setUregistetime(Date uregistetime) {
        this.uregistetime = uregistetime;
    }

    public Date getUlastdate() {
        return ulastdate;
    }

    public void setUlastdate(Date ulastdate) {
        this.ulastdate = ulastdate;
    }
}