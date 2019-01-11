package com.mallProject.demo.common;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include=Inclusion.NON_NULL)
//��֤���л�json��ʱ��  �����null����keyҲ����ʧ
public class ServerResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5935982297875644368L;
	
	private Integer status;
	private String msg;
	private T data;
	
	private  ServerResponse(int status) {
		this.status=status;
	}

	private  ServerResponse(int status,T data) {
		this.status=status;
		this.data=data;
	}
	
	private  ServerResponse(int status,String msg,T data) {
		this.status=status;
		this.data=data;
		this.msg=msg;
	}
	
	private  ServerResponse(int status,String msg) {
		this.status=status;
		this.msg=msg;
	}
	//ʹ֮����json���л��������
	@JsonIgnore
	public boolean isSuccess() {
		return this.status == ResponseCode.SUCCESS.getCode();
	}

	public Integer getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}
	
	
	public static <T> ServerResponse<T> createBySuccess(){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}
	
	public static <T> ServerResponse<T> createBySuccessMessage(String msg){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
	}
	
	public static <T> ServerResponse<T> createBySuccess(T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
	}
	
	public static <T> ServerResponse<T> createBySuccess(String msg,T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
	}
	
	public static <T> ServerResponse<T> createByError(){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
	}
	
	public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
	}
	
	public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
		return new ServerResponse<T>(errorCode,errorMessage);
	}

	@Override
	public String toString() {
		return "ServerResponse [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
	
}
