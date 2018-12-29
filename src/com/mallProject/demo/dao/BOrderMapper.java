package com.mallProject.demo.dao;

import com.mallProject.demo.entity.BOrder;

public interface BOrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(BOrder record);

    int insertSelective(BOrder record);

    BOrder selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(BOrder record);

    int updateByPrimaryKey(BOrder record);
}