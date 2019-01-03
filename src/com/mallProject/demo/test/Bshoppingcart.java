package com.mallProject.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mallProject.demo.service.BShoppingcartService;

public class Bshoppingcart {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BShoppingcartService sb = (BShoppingcartService) context.getBean("bShoppingcartServiceImpl");
		
		System.out.println(sb.getCount());
	}

}
