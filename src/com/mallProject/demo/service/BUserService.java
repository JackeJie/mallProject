package com.mallProject.demo.service;

import java.util.List;

import com.mallProject.demo.entity.BUser;

public interface BUserService {
	/**
	 * 
	 * @param uid  ��������ɾ��
	 * @return
	 */
	int deleteByPrimaryKey(Integer uid);
	/**
	 * 
	 * @param record
	 * @return  ������Ϣ
	 */
    int insert(BUser record);

    /**
     * 
     * @param uid  ��ѯ������Ϣ
     * @return
     */
    BUser selectByPrimaryKey(Integer uid);
    /**
     * 
     * @param record  ���������޸���Ϣ
     * @return
     */
    int updateByPrimaryKey(BUser record);
    /**
     * 
     * @return  ��ѯ�����û�
     */
    List<BUser>  getBUserAll();
}
