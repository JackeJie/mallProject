package com.mallProject.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mallProject.demo.common.Const;
import com.mallProject.demo.common.ResponseCode;
import com.mallProject.demo.common.ServerResponse;
import com.mallProject.demo.entity.MmallUser;
import com.mallProject.demo.service.UserService;



@SuppressWarnings("unchecked")
@Controller
public class UserController {

	@Autowired
	private UserService userServer;

	// 登录接口
	@RequestMapping(value = "login.s", method = RequestMethod.POST)
	@ResponseBody
	public Object login(String username, String password, HttpSession session) {
		// 调用sercice层
		ServerResponse<MmallUser> uResponse = userServer.login(username, password);
		if (uResponse.isSuccess()) {
			session.setAttribute(Const.CURRENT_USER, uResponse.getData());
		}
		return uResponse;
	}

	// 登出功能
	@RequestMapping
	@ResponseBody
	public ServerResponse<String> loginout(HttpSession session) {
		session.removeAttribute(Const.CURRENT_USER);
		return ServerResponse.createBySuccess();

	}

	// 校验用户是否存在
	@RequestMapping
	@ResponseBody
	public ServerResponse<String> regsiter(MmallUser user) {
		return userServer.register(user);
	}

	// 校验接口
	public ServerResponse<String> checkValid(String str, String type) {
		return userServer.checkValid(str, type);
	}

	// 获取用户信息
	@RequestMapping(value = "getUserInfo.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<MmallUser> getUserInfo(HttpSession session) {
		MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
		if (user != null) {
			return ServerResponse.createBySuccess(user);
		}
		return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户信息");
	}

	// 通过问题找回密码
	@RequestMapping(value = "forgentGetquestion.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> forgentGet(String username) {
		return userServer.selectQuestion(username);
	}

	// 检查问题答案
	@RequestMapping(value = "forgetCheckAnswer.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {
		return userServer.CheckAnswer(username, question, answer);
	}

	// 忘记密码
	@RequestMapping(value = "forgetResetPassWord.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> forgetResetPassWord(String username, String passwordNew, String forgetToken) {
		return userServer.forgetResetPassWord(username, passwordNew, forgetToken);
	}

	// 登录状态下修改密码
	@RequestMapping(value = "resetPassWord.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> resetPassWord(HttpSession session, String asswordOld, String asswordNew) {
		MmallUser user = (MmallUser) session.getAttribute(Const.USERNAME);
		if (user == null) {
			return ServerResponse.createByErrorMessage("用户未登录");
		}
		return userServer.resetPassWord(asswordOld, asswordNew, user);
	}

	// 更新个人用户信息接口
	@RequestMapping(value = "updateInformation.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<MmallUser> updateInformation(HttpSession session, MmallUser user) {
		//防止userid被更换   所以从session中取出user信息
		MmallUser currentuser = (MmallUser) session.getAttribute(Const.USERNAME);
		if (currentuser == null) {
			return ServerResponse.createByErrorMessage("用户未登录");
		}
		user.setId(currentuser.getId());
		ServerResponse<MmallUser> response = userServer.updateInformation(user);
		if (response.isSuccess()) {
			session.setAttribute(Const.CURRENT_USER, response.getData());
		}

		return response;
	}

	// 获取用户详细信息
	@RequestMapping(value = "getInformation.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<MmallUser> getInformation(HttpSession session) {
		MmallUser currentuser = (MmallUser) session.getAttribute(Const.USERNAME);
		if (currentuser == null) {
			// 判断用户是否登录，如果未登录则返回前端未登录状态码，进行强制登录
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录，需要强制登录status=10");
		}
		return userServer.getInformation(currentuser.getId());
	}
	
}
