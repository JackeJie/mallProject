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

	// ��¼�ӿ�
	@RequestMapping(value = "login.s", method = RequestMethod.POST)
	@ResponseBody
	public Object login(String username, String password, HttpSession session) {
		// ����sercice��
		ServerResponse<MmallUser> uResponse = userServer.login(username, password);
		if (uResponse.isSuccess()) {
			session.setAttribute(Const.CURRENT_USER, uResponse.getData());
		}
		return uResponse;
	}

	// �ǳ�����
	@RequestMapping
	@ResponseBody
	public ServerResponse<String> loginout(HttpSession session) {
		session.removeAttribute(Const.CURRENT_USER);
		return ServerResponse.createBySuccess();

	}

	// У���û��Ƿ����
	@RequestMapping
	@ResponseBody
	public ServerResponse<String> regsiter(MmallUser user) {
		return userServer.register(user);
	}

	// У��ӿ�
	public ServerResponse<String> checkValid(String str, String type) {
		return userServer.checkValid(str, type);
	}

	// ��ȡ�û���Ϣ
	@RequestMapping(value = "getUserInfo.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<MmallUser> getUserInfo(HttpSession session) {
		MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
		if (user != null) {
			return ServerResponse.createBySuccess(user);
		}
		return ServerResponse.createByErrorMessage("�û�δ��¼���޷���ȡ��ǰ�û���Ϣ");
	}

	// ͨ�������һ�����
	@RequestMapping(value = "forgentGetquestion.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> forgentGet(String username) {
		return userServer.selectQuestion(username);
	}

	// ��������
	@RequestMapping(value = "forgetCheckAnswer.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {
		return userServer.CheckAnswer(username, question, answer);
	}

	// ��������
	@RequestMapping(value = "forgetResetPassWord.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> forgetResetPassWord(String username, String passwordNew, String forgetToken) {
		return userServer.forgetResetPassWord(username, passwordNew, forgetToken);
	}

	// ��¼״̬���޸�����
	@RequestMapping(value = "resetPassWord.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> resetPassWord(HttpSession session, String asswordOld, String asswordNew) {
		MmallUser user = (MmallUser) session.getAttribute(Const.USERNAME);
		if (user == null) {
			return ServerResponse.createByErrorMessage("�û�δ��¼");
		}
		return userServer.resetPassWord(asswordOld, asswordNew, user);
	}

	// ���¸����û���Ϣ�ӿ�
	@RequestMapping(value = "updateInformation.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<MmallUser> updateInformation(HttpSession session, MmallUser user) {
		//��ֹuserid������   ���Դ�session��ȡ��user��Ϣ
		MmallUser currentuser = (MmallUser) session.getAttribute(Const.USERNAME);
		if (currentuser == null) {
			return ServerResponse.createByErrorMessage("�û�δ��¼");
		}
		user.setId(currentuser.getId());
		ServerResponse<MmallUser> response = userServer.updateInformation(user);
		if (response.isSuccess()) {
			session.setAttribute(Const.CURRENT_USER, response.getData());
		}

		return response;
	}

	// ��ȡ�û���ϸ��Ϣ
	@RequestMapping(value = "getInformation.s",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<MmallUser> getInformation(HttpSession session) {
		MmallUser currentuser = (MmallUser) session.getAttribute(Const.USERNAME);
		if (currentuser == null) {
			// �ж��û��Ƿ��¼�����δ��¼�򷵻�ǰ��δ��¼״̬�룬����ǿ�Ƶ�¼
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "δ��¼����Ҫǿ�Ƶ�¼status=10");
		}
		return userServer.getInformation(currentuser.getId());
	}
	
}
