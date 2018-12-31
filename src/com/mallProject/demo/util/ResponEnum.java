package com.mallProject.demo.util;

public enum ResponEnum {

	SUCESS(0,"³É¹¦"),
	ERROR(1,"Ê§”¡");
	
	
	private  final int code;
	private  final  String msg;
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	  ResponEnum(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
}
