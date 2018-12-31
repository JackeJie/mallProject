package com.mallProject.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author wangj  
 *
 */
public class BBookinfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3848507244908476469L;

	private Integer bookid;

    private Integer booktypeid;

    private String bookname;

    private String bookauthor;

    private Float bookmoney;

    private String booknote;
    
    private Integer bookstate;
    
    private Date  createtime;
    
    private Date  updatetime; 

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getBooktypeid() {
        return booktypeid;
    }

    public void setBooktypeid(Integer booktypeid) {
        this.booktypeid = booktypeid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor == null ? null : bookauthor.trim();
    }

    public Float getBookmoney() {
        return bookmoney;
    }

    public void setBookmoney(Float bookmoney) {
        this.bookmoney = bookmoney;
    }

    
    
    public Integer getBookstate() {
		return bookstate;
	}

	public void setBookstate(Integer bookstate) {
		this.bookstate = bookstate;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	

	public String getBooknote() {
        return booknote;
    }

    public void setBooknote(String booknote) {
        this.booknote = booknote == null ? null : booknote.trim();
    }

	@Override
	public String toString() {
		return "BBookinfo [bookid=" + bookid + ", booktypeid=" + booktypeid + ", bookname=" + bookname + ", bookauthor="
				+ bookauthor + ", bookmoney=" + bookmoney + ", booknote=" + booknote + ", bookstate=" + bookstate
				+ ", createtime=" + createtime + ", updatetime=" + updatetime + "]";
	}
    
    
    
    
}