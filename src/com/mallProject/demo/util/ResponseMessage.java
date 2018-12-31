package com.mallProject.demo.util;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize
public class ResponseMessage<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1602468091884693618L;
	
	
	private int code;
	private String msg;
	private T data;
	
	
	private ResponseMessage(int code,String msg) {
		this.code=code;
		this.msg=msg;
	}
	
	private ResponseMessage(int code,String msg,T data) {
		this.data=data;
		this.code=code;
		this.msg=msg;
	}

	/**
	 * 
	 * @param code
	 * @param msg
	 * @return  ͨ�óɹ����ظ�ʽ
	 */
	public static ResponseMessage<Object>  returnResponseMessage(int code,String msg){
		return new ResponseMessage<>(code, msg);
	}
	/**
	 * 
	 * @param code  ������
	 * @param msg   ��Ϣ
	 * @param data  ����
	 * @return    ��ѯ�ɹ��󷵻�����
	 */
	public static ResponseMessage<Object>  returnResponseMessageSucess(int code,String msg,Object data){
		return new ResponseMessage<>(ResponEnum.SUCESS.getCode(), ResponEnum.SUCESS.getMsg(),data);
	}
	/**
	 * 
	 * @param code
	 * @param msg
	 * @return  ʧ�ܺ󷵻���Ϣ
	 */
	public static ResponseMessage<Object>  returnResponseMessageError(int code,String msg){
		return new ResponseMessage<>(code, msg);
	}

	@Override
	public String toString() {
		return "{code:" + code + ", msg:" + msg + ", data:" + data + "}";
	}
	
	
	
	
}
