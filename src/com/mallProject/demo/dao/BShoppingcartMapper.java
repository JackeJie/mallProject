package com.mallProject.demo.dao;

import java.util.List;

import com.mallProject.demo.entity.BShoppingcart;

public interface BShoppingcartMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(BShoppingcart record);

    int insertSelective(BShoppingcart record);

    BShoppingcart selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(BShoppingcart record);

    int updateByPrimaryKey(BShoppingcart record);
    
    
    List<BShoppingcart>  getBShoppingcartAll();
}