package com.mallProject.demo.service;

import java.util.List;

import com.mallProject.demo.entity.BBookinfo;

public interface BBookinfoService {
	/**
	 * 
	 * @param record  �����Ʒ��Ϣ
	 * @return
	 */
	int insert(BBookinfo record);
	/**
	 * 
	 * @return  ��ѯ������Ʒ��Ϣ
	 */
	List<BBookinfo> getBBookinfoAll();
	/**
	 * 
	 * @param bookid  ����������ѯ����
	 * @return
	 */
	BBookinfo selectByPrimaryKey(Integer bookid);
	/**
	 * 
	 * @param bookid  ��������ɾ������
	 * @return
	 */
	 int deleteByPrimaryKey(Integer bookid);
	 /**
	  * 
	  * @param record  ���������޸�
	  * @return
	  */
	 int updateByPrimaryKeySelective(BBookinfo record);
	
}
