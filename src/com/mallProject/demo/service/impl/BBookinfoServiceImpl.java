package com.mallProject.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mallProject.demo.dao.BBookinfoMapper;
import com.mallProject.demo.entity.BBookinfo;
import com.mallProject.demo.service.BBookinfoService;

@Service(value="bBookinfoServiceImpl")
public class BBookinfoServiceImpl implements BBookinfoService {
	
	@Autowired
	private BBookinfoMapper bBookinfoMapper;

	@Override
	public int insert(BBookinfo record) {
		
		return bBookinfoMapper.insert(record);
	}

	@Override
	public List<BBookinfo> getBBookinfoAll() {
		
		return bBookinfoMapper.getBBookinfoAll();
	}
	
	
	public  BBookinfo selectByPrimaryKey(Integer bookid) {
		return bBookinfoMapper.selectByPrimaryKey(bookid);
	}

	@Override
	public int deleteByPrimaryKey(Integer bookid) {
		
		return bBookinfoMapper.deleteByPrimaryKey(bookid);
	}

	@Override
	public int updateByPrimaryKeySelective(BBookinfo record) {
		// TODO Auto-generated method stub
		return bBookinfoMapper.updateByPrimaryKeySelective(record);
	}

}
