package com.mallProject.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mallProject.demo.dao.BUserMapper;
import com.mallProject.demo.entity.BUser;
import com.mallProject.demo.service.BUserService;

@Service(value="bUserServiceImpl")
public class BUserServiceImpl implements BUserService {
	
	@Autowired
	private BUserMapper  bUserMapper;

	@Override
	public int deleteByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return bUserMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public int insert(BUser record) {
		// TODO Auto-generated method stub
		return bUserMapper.insert(record);
	}

	@Override
	public BUser selectByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return bUserMapper.selectByPrimaryKey(uid);
	}

	@Override
	public int updateByPrimaryKey(BUser record) {
		// TODO Auto-generated method stub
		return bUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<BUser> getBUserAll() {
		// TODO Auto-generated method stub
		return bUserMapper.getBUserAll();
	}

}
