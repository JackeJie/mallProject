package com.mallProject.demo.dao;

import com.mallProject.demo.entity.MmallProduct;
import com.mallProject.demo.entity.MmallProductWithBLOBs;

public interface MmallProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MmallProductWithBLOBs record);

    int insertSelective(MmallProductWithBLOBs record);

    MmallProductWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MmallProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MmallProductWithBLOBs record);

    int updateByPrimaryKey(MmallProduct record);
}