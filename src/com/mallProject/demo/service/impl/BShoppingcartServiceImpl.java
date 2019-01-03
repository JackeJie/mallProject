package com.mallProject.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mallProject.demo.dao.BShoppingcartMapper;
import com.mallProject.demo.entity.BShoppingcart;
import com.mallProject.demo.service.BShoppingcartService;

@Service(value="bShoppingcartServiceImpl")
public class BShoppingcartServiceImpl implements BShoppingcartService {
	
	
	@Autowired
	private BShoppingcartMapper  bShoppingcartMapper;

	@Override
	public int deleteByPrimaryKey(Integer sid) {
		// TODO Auto-generated method stub
		return bShoppingcartMapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(BShoppingcart record) {
		// TODO Auto-generated method stub
		return bShoppingcartMapper.insert(record);
	}

	@Override
	public int updateByPrimaryKey(BShoppingcart record) {
		// TODO Auto-generated method stub
		return bShoppingcartMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<BShoppingcart> getBShoppingcartAll() {
		// TODO Auto-generated method stub
		return bShoppingcartMapper.getBShoppingcartAll();
	}

	@Override
	public int getCount() {
		
		return bShoppingcartMapper.getCount();
	}

	@Override
	public int getCountUserShoppingCart(Integer id) {
		// TODO Auto-generated method stub
		return bShoppingcartMapper.getCountUserShoppingCart(id);
	}

}
