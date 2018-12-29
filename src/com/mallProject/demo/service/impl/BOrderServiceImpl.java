package com.mallProject.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mallProject.demo.dao.BOrderMapper;
import com.mallProject.demo.entity.BOrder;
import com.mallProject.demo.service.BOrderService;
@Service(value="bOrderServiceImpl")
public class BOrderServiceImpl implements BOrderService {
	
	@Autowired
	private BOrderMapper  bOrderMapper;

	@Override
	public List<BOrder> getBOrderAll() {
		// TODO Auto-generated method stub
		return bOrderMapper.getBOrderAll();
	}

	@Override
	public BOrder selectByPrimaryKey(Integer oid) {
		// TODO Auto-generated method stub
		return bOrderMapper.selectByPrimaryKey(oid);
	}

	@Override
	public int insert(BOrder record) {
		// TODO Auto-generated method stub
		return bOrderMapper.insert(record);
	}

}
