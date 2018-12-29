package com.mallProject.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mallProject.demo.dao.BManagerMapper;
import com.mallProject.demo.entity.BManager;
import com.mallProject.demo.service.BManagerService;

@Service(value="bManagerServiceImpl")
public class BManagerServiceImpl implements BManagerService {
	
	
	@Autowired
	private BManagerMapper bManagerMapper;

	@Override
	public List<BManager> getBManagerAll() {
		// TODO Auto-generated method stub
		return bManagerMapper.getBManagerAll();
	}

}
