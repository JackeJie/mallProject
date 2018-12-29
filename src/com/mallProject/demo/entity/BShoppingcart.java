package com.mallProject.demo.entity;

public class BShoppingcart {
    private Integer sid;

    private Integer uid;

    private Integer sordercount;

    private Float stotalprice;

    private String sispay;

    private String spaymethod;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSordercount() {
        return sordercount;
    }

    public void setSordercount(Integer sordercount) {
        this.sordercount = sordercount;
    }

    public Float getStotalprice() {
        return stotalprice;
    }

    public void setStotalprice(Float stotalprice) {
        this.stotalprice = stotalprice;
    }

    public String getSispay() {
        return sispay;
    }

    public void setSispay(String sispay) {
        this.sispay = sispay == null ? null : sispay.trim();
    }

    public String getSpaymethod() {
        return spaymethod;
    }

    public void setSpaymethod(String spaymethod) {
        this.spaymethod = spaymethod == null ? null : spaymethod.trim();
    }
}