package com.mallProject.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.mallProject.demo.entity.MmallUser;

public interface MmallUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(MmallUser record);

	int insertSelective(MmallUser record);

	MmallUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(MmallUser record);

	int updateByPrimaryKey(MmallUser record);

	int checkUsername(String username);

	int checkEmile(String emile);

	MmallUser selectLogin(@Param("username") String username, @Param("password") String password);

	String selectQuestionByUsername(String username);

	int checkAnswer(@Param("username") String username, @Param("question") String question,
			@Param("answer") String answer);

	int updatePasswordByUsername(@Param("password") String password, @Param("username") String username);

	int checkPassword(@Param("password") String password, @Param("userId") Integer userId);

	int checkEmailByUserId(@Param("email") String email, @Param("userId") Integer userId);

}