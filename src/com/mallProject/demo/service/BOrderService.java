package com.mallProject.demo.service;

import java.util.List;

import com.mallProject.demo.entity.BOrder;

public interface BOrderService {
	/**
	 * 
	 * @return  ��ѯ���ж���
	 */
	List<BOrder> getBOrderAll();
	
	/**
	 * 
	 * @param oid  ����������ѯ����
	 * @return
	 */
	BOrder selectByPrimaryKey(Integer oid);
	/**
	 * 
	 * @param record  ��Ӷ���
	 * @return
	 */
	int insert(BOrder record);

}
