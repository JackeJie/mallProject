package com.mallProject.demo.service;

import java.util.List;

import com.mallProject.demo.entity.BOrder;

public interface BOrderService {
	/**
	 * 
	 * @return  查询所有订单
	 */
	List<BOrder> getBOrderAll();
	
	/**
	 * 
	 * @param oid  根据主键查询订单
	 * @return
	 */
	BOrder selectByPrimaryKey(Integer oid);
	/**
	 * 
	 * @param record  添加订单
	 * @return
	 */
	int insert(BOrder record);

}
