package com.mallProject.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mallProject.demo.service.BBookinfoService;
import com.mallProject.demo.util.ResponseMessage;

public class TestDemo {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BBookinfoService sb = (BBookinfoService) context.getBean("bBookinfoServiceImpl");
		
		//���
//		BBookinfo bookinfo = new BBookinfo();
//		bookinfo.setBookauthor("����andС����");
//		bookinfo.setBookmoney(12.00f);
//		bookinfo.setBookname("����");
//		bookinfo.setBooknote("����");
//		bookinfo.setBooktypeid(1);
//		bookinfo.setBookstate(1);
//	
//		int id = sb.insert(bookinfo);
//		System.out.println(id);
//		
//		
////		//��ѯ����
		
		System.out.println(ResponseMessage.returnResponseMessageSucess(0, "�ɹ�",sb.getBBookinfoAll().get(0) ));
		System.out.println(sb.getBBookinfoAll().get(0));
		
////		
////		
////		//�޸ĵ�����¼
//		bookinfo.setBookmoney(520.00f);
//		bookinfo.setBookid(2);
//		bookinfo.setUpdatetime(new Date());
//		sb.updateByPrimaryKeySelective(bookinfo);
//		
//		//��ѯ����
//		System.out.println(sb.selectByPrimaryKey(1));
//		
//		//ɾ������
//		System.out.println(sb.deleteByPrimaryKey(3));
//		
//		
		
	}

}
