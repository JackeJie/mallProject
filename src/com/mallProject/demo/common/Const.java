package com.mallProject.demo.common;

/**
 * 
 * @author wangj
 *  声明一个常量类
 */
public class Const {

	
	public static final String CURRENT_USER="currentuser";
	
	public static final String USERNAME="USERNAME";
	public static final String EMAIL="EMAIL";
	
	
	//使用内部接口类 实现分组效果
	public interface Role{
		public int ROLE_CUSTOMER=0; //0是顾客
		
		public int ROLE_ADMIN=1; //0是顾客
	}
	
}
