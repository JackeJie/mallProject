package com.mallProject.demo.dao;

import java.util.List;

import com.mallProject.demo.entity.BManager;

public interface BManagerMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(BManager record);

    int insertSelective(BManager record);

    BManager selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(BManager record);

    int updateByPrimaryKey(BManager record);
    
    List<BManager> getBManagerAll();
}