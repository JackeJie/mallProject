package com.mallProject.demo.dao;

import java.util.List;

import com.mallProject.demo.entity.BUser;

public interface BUserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(BUser record);

    int insertSelective(BUser record);

    BUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(BUser record);

    int updateByPrimaryKey(BUser record);
    
    List<BUser>  getBUserAll();
    
    
}