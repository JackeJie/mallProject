package com.mallProject.demo.common;
/**
 * 
 * @author wangj
 *  œÏ”¶±‡¬Î
 */
public enum ResponseCode {
	
	SUCCESS(0,""),
	ERROR(1,""),
	NEED_LOGIN(10,"NEED_LOGIN"),
	ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT")
	;
	
	private final int code;
	private final String desc;
	
	ResponseCode(int code,String desc){
		this.code=code;
		this.desc=desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	

}
