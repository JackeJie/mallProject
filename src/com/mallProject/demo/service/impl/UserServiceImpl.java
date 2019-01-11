package com.mallProject.demo.service.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mallProject.demo.common.Const;
import com.mallProject.demo.common.ServerResponse;
import com.mallProject.demo.common.TokenCache;
import com.mallProject.demo.dao.MmallUserMapper;
import com.mallProject.demo.entity.MmallUser;
import com.mallProject.demo.service.UserService;
import com.mallProject.demo.util.MD5Util;

@SuppressWarnings("rawtypes")
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	private MmallUserMapper userMapper;

	@Override
	public ServerResponse<MmallUser> login(String username, String password) {
		// 校验用户名存不存在
		int resultCount = userMapper.checkUsername(username);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMessage("用户名不存在");
		}
		// 密码登录md5 获取MD5后的密码传入进去
		
		MmallUser user = userMapper.selectLogin(username, MD5Util.MD5EncodeUtf8(password));
		if (user == null) {
			return ServerResponse.createByErrorMessage("密码错误");
		}
		user.setPassword(StringUtils.EMPTY);

		// TODO Auto-generated method stub
		return ServerResponse.createBySuccess("登录成功", user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public ServerResponse<String> register(MmallUser user) {

		ServerResponse validResponse = this.checkValid(user.getUsername(), Const.USERNAME);
		// 校验用户名是否存在
		if (!validResponse.isSuccess()) {
			return validResponse;
		}
		validResponse = this.checkValid(user.getEmail(), Const.EMAIL);
		if (!validResponse.isSuccess()) {
			return ServerResponse.createByErrorMessage("Email已经存在");
		}
		user.setRole(Const.Role.ROLE_CUSTOMER);
		// MD5加密
		user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
		int resultCount = userMapper.insert(user);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMessage("注册失败");
		}
		return ServerResponse.createBySuccessMessage("注册成功");
	}

	// 校验
	@Override
	public ServerResponse<String> checkValid(String str, String type) {
		if (StringUtils.isNoneBlank(type)) {

			if (Const.USERNAME.equals(type)) {
				int resultCount = userMapper.checkUsername(str);
				if (resultCount > 0) {
					return ServerResponse.createByErrorMessage("用户名已存在");
				}
			}
			if (Const.EMAIL.equals(type)) {
				int resultCount = userMapper.checkEmile(str);
				if (resultCount > 0) {
					return ServerResponse.createByErrorMessage("Email已经存在");
				}
				return ServerResponse.createByErrorMessage("Email已经存在");
			}

		} else {
			return ServerResponse.createByErrorMessage("参数错误");
		}
		return ServerResponse.createBySuccessMessage("校验成功");
	}

	@Override
	public ServerResponse selectQuestion(String username) {

		ServerResponse validRespone = this.checkValid(username, Const.USERNAME);
		if (validRespone.isSuccess()) {
			return ServerResponse.createByErrorMessage("用户不存在");
		}
		String question = userMapper.selectQuestionByUsername(username);
		if (StringUtils.isNoneBlank(question)) {
			return ServerResponse.createBySuccess(question);
		}
		return ServerResponse.createByErrorMessage("找回密码得问题是空的");
	}

	// 使用本地缓存检查问题接口
	@Override
	public ServerResponse CheckAnswer(String username, String question, String answer) {
		int resultCount = userMapper.checkAnswer(username, question, answer);
		if (resultCount > 0) {
			// 说明问题及问题答案是这个用户的，并且是正确的
			String forgetToken = UUID.randomUUID().toString();
			// 放置本地并设置有效期
			TokenCache.setKey(TokenCache.TOKEN_PREFIX + username, forgetToken);
			return ServerResponse.createBySuccess(forgetToken);
		}
		return ServerResponse.createByErrorMessage("问题的答案回答错误");
	}

	@Override
	public ServerResponse<String> forgetResetPassWord(String username, String passwordNew, String forgetToken) {
		if (StringUtils.isBlank(forgetToken)) {
			return ServerResponse.createByErrorMessage("参数错误，token需要传递");
		}
		ServerResponse validRespone = this.checkValid(username, Const.USERNAME);
		if (validRespone.isSuccess()) {
			return ServerResponse.createByErrorMessage("用户不存在");
		}
		String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX + username);
		if (StringUtils.isBlank(token)) {
			return ServerResponse.createByErrorMessage("token无效或过期");
		}

		if (StringUtils.equals(forgetToken, token)) {
			String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
			int rowCount = userMapper.updatePasswordByUsername(md5Password, username);

			if (rowCount > 0) {
				return ServerResponse.createBySuccessMessage("修改密码成功");
			}
		} else {
			return ServerResponse.createByErrorMessage("token错误，清重新获取重置密码得token");
		}
		return ServerResponse.createBySuccessMessage("修改密码失败");
	}

	// 登录状态重置密码
	@Override
	public ServerResponse<String> resetPassWord(String asswordOld, String asswordNew, MmallUser user) {
		// 防止横向越权，要检验一下这个用户的旧密码，一定要指定是这个用户，因为我们会拆线呢一个count(1),如果不指定id，那么结果就是true count
		// >0;
		int resultCount = userMapper.checkPassword("md5+", user.getId());
		if (resultCount == 0) {
			return ServerResponse.createByErrorMessage("旧密码错误");
		}
		user.setPassword("MD5");
		int updateCount = userMapper.updateByPrimaryKeySelective(user);
		if (updateCount > 0) {
			return ServerResponse.createBySuccessMessage("密码更新成功");
		}
		return ServerResponse.createByErrorMessage("密码更新失败");

	}

	@Override
	public ServerResponse<MmallUser> updateInformation(MmallUser user) {
		// username 是不能被更新的
		// email也要进行一个校验，校验新的email是不是已经存在,并且存在的email如果相同的话，不能是我们当前的这个用户的阿
		int resultCount = userMapper.checkEmailByUserId(user.getEmail(), user.getId());
		if (resultCount > 0) {
			return ServerResponse.createByErrorMessage("email已经存在，清更换email再尝试更新");
		}
		MmallUser updateUser = new MmallUser();
		updateUser.setId(user.getId());
		updateUser.setEmail(user.getEmail());
		updateUser.setPhone(user.getPhone());
		updateUser.setQuestion(user.getQuestion());
		updateUser.setAnswer(user.getAnswer());

		int count = userMapper.updateByPrimaryKeySelective(updateUser);
		if (count > 0) {
			return ServerResponse.createBySuccess("个人信息更新成功",updateUser);
		}

		return ServerResponse.createByErrorMessage("信息更新失败");
	}
	
	@Override
	public ServerResponse<MmallUser> getInformation(Integer userId){
		MmallUser user=userMapper.selectByPrimaryKey(userId);
		if(user==null) {
			return ServerResponse.createByErrorMessage("找不大当前用户");
		}
		//将密码置为空
		user.setPassword(StringUtils.EMPTY);
		return ServerResponse.createBySuccess(user);
	}
	
	

}
