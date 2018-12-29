package com.mallProject.demo.service;

import java.util.List;

import com.mallProject.demo.entity.BUser;

public interface BUserService {
	/**
	 * 
	 * @param uid  根据主键删除
	 * @return
	 */
	int deleteByPrimaryKey(Integer uid);
	/**
	 * 
	 * @param record
	 * @return  插入信息
	 */
    int insert(BUser record);

    /**
     * 
     * @param uid  查询单条信息
     * @return
     */
    BUser selectByPrimaryKey(Integer uid);
    /**
     * 
     * @param record  根据主键修改信息
     * @return
     */
    int updateByPrimaryKey(BUser record);
    /**
     * 
     * @return  查询所有用户
     */
    List<BUser>  getBUserAll();
}
