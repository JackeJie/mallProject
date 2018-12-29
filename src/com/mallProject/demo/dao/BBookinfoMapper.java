package com.mallProject.demo.dao;

import com.mallProject.demo.entity.BBookinfo;

public interface BBookinfoMapper {
    int deleteByPrimaryKey(Integer bookid);

    int insert(BBookinfo record);

    int insertSelective(BBookinfo record);

    BBookinfo selectByPrimaryKey(Integer bookid);

    int updateByPrimaryKeySelective(BBookinfo record);

    int updateByPrimaryKeyWithBLOBs(BBookinfo record);

    int updateByPrimaryKey(BBookinfo record);
}