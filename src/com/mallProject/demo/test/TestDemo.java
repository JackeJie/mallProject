package com.mallProject.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mallProject.demo.entity.BBookinfo;
import com.mallProject.demo.service.BBookinfoService;

public class TestDemo {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BBookinfoService sb = (BBookinfoService) context.getBean("bBookinfoServiceImpl");
		
		//添加
		BBookinfo bookinfo = new BBookinfo();
		bookinfo.setBookauthor("哆啦and小丸子");
		bookinfo.setBookmoney(12.00f);
		bookinfo.setBookname("泡泡");
		bookinfo.setBooknote("哆啦");
		bookinfo.setBooktypeid(1);
		int id = sb.insert(bookinfo);
		System.out.println(id);
		
		
		//查询所有
		System.out.println(sb.getBBookinfoAll().get(0).getBooknote());
		
		
		//修改单条记录
		bookinfo.setBookmoney(520.00f);
		bookinfo.setBookid(1);
		sb.updateByPrimaryKeySelective(bookinfo);
		
		//查询单条
		System.out.println(sb.selectByPrimaryKey(1));
		
		//删除单条
		System.out.println(sb.deleteByPrimaryKey(3));
		
		
		
	}

}
