package com.mallProject.demo.service;

import java.util.List;

import com.mallProject.demo.entity.BBookinfo;

public interface BBookinfoService {
	/**
	 * 
	 * @param record  添加商品信息
	 * @return
	 */
	int insert(BBookinfo record);
	/**
	 * 
	 * @return  查询所有商品信息
	 */
	List<BBookinfo> getBBookinfoAll();
	/**
	 * 
	 * @param bookid  根据主键查询单条
	 * @return
	 */
	BBookinfo selectByPrimaryKey(Integer bookid);
	/**
	 * 
	 * @param bookid  根据主键删除单条
	 * @return
	 */
	 int deleteByPrimaryKey(Integer bookid);
	 /**
	  * 
	  * @param record  根据主键修改
	  * @return
	  */
	 int updateByPrimaryKeySelective(BBookinfo record);
	
}
