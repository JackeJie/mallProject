package com.mallProject.demo.entity;

import java.util.Date;

public class BOrder {
    private Integer oid;

    private Integer uid;

    private Integer bookid;

    private Date odate;

    private Integer onum;

    private Float oprice;

    private String omessage;

    private String oaddressee;

    private String oaddress;

    private String ophone;

    private String ostatus;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Integer getOnum() {
        return onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }

    public Float getOprice() {
        return oprice;
    }

    public void setOprice(Float oprice) {
        this.oprice = oprice;
    }

    public String getOmessage() {
        return omessage;
    }

    public void setOmessage(String omessage) {
        this.omessage = omessage == null ? null : omessage.trim();
    }

    public String getOaddressee() {
        return oaddressee;
    }

    public void setOaddressee(String oaddressee) {
        this.oaddressee = oaddressee == null ? null : oaddressee.trim();
    }

    public String getOaddress() {
        return oaddress;
    }

    public void setOaddress(String oaddress) {
        this.oaddress = oaddress == null ? null : oaddress.trim();
    }

    public String getOphone() {
        return ophone;
    }

    public void setOphone(String ophone) {
        this.ophone = ophone == null ? null : ophone.trim();
    }

    public String getOstatus() {
        return ostatus;
    }

    public void setOstatus(String ostatus) {
        this.ostatus = ostatus == null ? null : ostatus.trim();
    }
}