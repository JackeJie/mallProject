package com.mallProject.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mallProject.demo.common.ServerResponse;
import com.mallProject.demo.entity.MmallUser;
import com.mallProject.demo.service.UserService;

public class TestDemo {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService sb = (UserService) context.getBean("userServiceImpl");
		
		ServerResponse<MmallUser> ss=sb.login("admin", "admin");
		System.out.println(ss.getData().getEmail());
		
	}

}
