package com.mallProject.demo.service;

import java.util.List;

import com.mallProject.demo.entity.BShoppingcart;

public interface BShoppingcartService {
	/**
	 * 
	 * @param sid  删除单条
	 * @return
	 */
	int deleteByPrimaryKey(Integer sid);
	/**
	 * 
	 * @param record  加入单条
	 * @return
	 */
	int insert(BShoppingcart record);
	/**
	 * 
	 * @param record 更新单条
	 * @return
	 */
	int updateByPrimaryKey(BShoppingcart record);
	/**
	 * 
	 * @return  查询所有商品
	 */
	List<BShoppingcart> getBShoppingcartAll();
	
	/**
	 * 
	 * @param id
	 * @return   查询购物车商品数量
	 */
	 int getCount();
	 /**
	  *    
	  * @param id  根据用户id查询用户购物车   后期给用户加账号师使用
	  * @return
	  */
	int getCountUserShoppingCart(Integer id);

}
