package com.mallProject.demo.entity;

import java.io.Serializable;

/**
 * 
 * @author wangj  π‹¿Ì±Ì
 *
 */
public class BManager implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3918002002329018162L;

	private Integer aid;

    private String aname;

    private String apwd;

    private Integer alevel;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd == null ? null : apwd.trim();
    }

    public Integer getAlevel() {
        return alevel;
    }

    public void setAlevel(Integer alevel) {
        this.alevel = alevel;
    }
}