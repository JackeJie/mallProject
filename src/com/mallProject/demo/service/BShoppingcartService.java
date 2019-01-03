package com.mallProject.demo.service;

import java.util.List;

import com.mallProject.demo.entity.BShoppingcart;

public interface BShoppingcartService {
	/**
	 * 
	 * @param sid  ɾ������
	 * @return
	 */
	int deleteByPrimaryKey(Integer sid);
	/**
	 * 
	 * @param record  ���뵥��
	 * @return
	 */
	int insert(BShoppingcart record);
	/**
	 * 
	 * @param record ���µ���
	 * @return
	 */
	int updateByPrimaryKey(BShoppingcart record);
	/**
	 * 
	 * @return  ��ѯ������Ʒ
	 */
	List<BShoppingcart> getBShoppingcartAll();
	
	/**
	 * 
	 * @param id
	 * @return   ��ѯ���ﳵ��Ʒ����
	 */
	 int getCount();
	 /**
	  *    
	  * @param id  �����û�id��ѯ�û����ﳵ   ���ڸ��û����˺�ʦʹ��
	  * @return
	  */
	int getCountUserShoppingCart(Integer id);

}
