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
		// У���û����治����
		int resultCount = userMapper.checkUsername(username);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMessage("�û���������");
		}
		// �����¼md5 ��ȡMD5������봫���ȥ
		
		MmallUser user = userMapper.selectLogin(username, MD5Util.MD5EncodeUtf8(password));
		if (user == null) {
			return ServerResponse.createByErrorMessage("�������");
		}
		user.setPassword(StringUtils.EMPTY);

		// TODO Auto-generated method stub
		return ServerResponse.createBySuccess("��¼�ɹ�", user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public ServerResponse<String> register(MmallUser user) {

		ServerResponse validResponse = this.checkValid(user.getUsername(), Const.USERNAME);
		// У���û����Ƿ����
		if (!validResponse.isSuccess()) {
			return validResponse;
		}
		validResponse = this.checkValid(user.getEmail(), Const.EMAIL);
		if (!validResponse.isSuccess()) {
			return ServerResponse.createByErrorMessage("Email�Ѿ�����");
		}
		user.setRole(Const.Role.ROLE_CUSTOMER);
		// MD5����
		user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
		int resultCount = userMapper.insert(user);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMessage("ע��ʧ��");
		}
		return ServerResponse.createBySuccessMessage("ע��ɹ�");
	}

	// У��
	@Override
	public ServerResponse<String> checkValid(String str, String type) {
		if (StringUtils.isNoneBlank(type)) {

			if (Const.USERNAME.equals(type)) {
				int resultCount = userMapper.checkUsername(str);
				if (resultCount > 0) {
					return ServerResponse.createByErrorMessage("�û����Ѵ���");
				}
			}
			if (Const.EMAIL.equals(type)) {
				int resultCount = userMapper.checkEmile(str);
				if (resultCount > 0) {
					return ServerResponse.createByErrorMessage("Email�Ѿ�����");
				}
				return ServerResponse.createByErrorMessage("Email�Ѿ�����");
			}

		} else {
			return ServerResponse.createByErrorMessage("��������");
		}
		return ServerResponse.createBySuccessMessage("У��ɹ�");
	}

	@Override
	public ServerResponse selectQuestion(String username) {

		ServerResponse validRespone = this.checkValid(username, Const.USERNAME);
		if (validRespone.isSuccess()) {
			return ServerResponse.createByErrorMessage("�û�������");
		}
		String question = userMapper.selectQuestionByUsername(username);
		if (StringUtils.isNoneBlank(question)) {
			return ServerResponse.createBySuccess(question);
		}
		return ServerResponse.createByErrorMessage("�һ�����������ǿյ�");
	}

	// ʹ�ñ��ػ���������ӿ�
	@Override
	public ServerResponse CheckAnswer(String username, String question, String answer) {
		int resultCount = userMapper.checkAnswer(username, question, answer);
		if (resultCount > 0) {
			// ˵�����⼰�����������û��ģ���������ȷ��
			String forgetToken = UUID.randomUUID().toString();
			// ���ñ��ز�������Ч��
			TokenCache.setKey(TokenCache.TOKEN_PREFIX + username, forgetToken);
			return ServerResponse.createBySuccess(forgetToken);
		}
		return ServerResponse.createByErrorMessage("����Ĵ𰸻ش����");
	}

	@Override
	public ServerResponse<String> forgetResetPassWord(String username, String passwordNew, String forgetToken) {
		if (StringUtils.isBlank(forgetToken)) {
			return ServerResponse.createByErrorMessage("��������token��Ҫ����");
		}
		ServerResponse validRespone = this.checkValid(username, Const.USERNAME);
		if (validRespone.isSuccess()) {
			return ServerResponse.createByErrorMessage("�û�������");
		}
		String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX + username);
		if (StringUtils.isBlank(token)) {
			return ServerResponse.createByErrorMessage("token��Ч�����");
		}

		if (StringUtils.equals(forgetToken, token)) {
			String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
			int rowCount = userMapper.updatePasswordByUsername(md5Password, username);

			if (rowCount > 0) {
				return ServerResponse.createBySuccessMessage("�޸�����ɹ�");
			}
		} else {
			return ServerResponse.createByErrorMessage("token���������»�ȡ���������token");
		}
		return ServerResponse.createBySuccessMessage("�޸�����ʧ��");
	}

	// ��¼״̬��������
	@Override
	public ServerResponse<String> resetPassWord(String asswordOld, String asswordNew, MmallUser user) {
		// ��ֹ����ԽȨ��Ҫ����һ������û��ľ����룬һ��Ҫָ��������û�����Ϊ���ǻ������һ��count(1),�����ָ��id����ô�������true count
		// >0;
		int resultCount = userMapper.checkPassword("md5+", user.getId());
		if (resultCount == 0) {
			return ServerResponse.createByErrorMessage("���������");
		}
		user.setPassword("MD5");
		int updateCount = userMapper.updateByPrimaryKeySelective(user);
		if (updateCount > 0) {
			return ServerResponse.createBySuccessMessage("������³ɹ�");
		}
		return ServerResponse.createByErrorMessage("�������ʧ��");

	}

	@Override
	public ServerResponse<MmallUser> updateInformation(MmallUser user) {
		// username �ǲ��ܱ����µ�
		// emailҲҪ����һ��У�飬У���µ�email�ǲ����Ѿ�����,���Ҵ��ڵ�email�����ͬ�Ļ������������ǵ�ǰ������û��İ�
		int resultCount = userMapper.checkEmailByUserId(user.getEmail(), user.getId());
		if (resultCount > 0) {
			return ServerResponse.createByErrorMessage("email�Ѿ����ڣ������email�ٳ��Ը���");
		}
		MmallUser updateUser = new MmallUser();
		updateUser.setId(user.getId());
		updateUser.setEmail(user.getEmail());
		updateUser.setPhone(user.getPhone());
		updateUser.setQuestion(user.getQuestion());
		updateUser.setAnswer(user.getAnswer());

		int count = userMapper.updateByPrimaryKeySelective(updateUser);
		if (count > 0) {
			return ServerResponse.createBySuccess("������Ϣ���³ɹ�",updateUser);
		}

		return ServerResponse.createByErrorMessage("��Ϣ����ʧ��");
	}
	
	@Override
	public ServerResponse<MmallUser> getInformation(Integer userId){
		MmallUser user=userMapper.selectByPrimaryKey(userId);
		if(user==null) {
			return ServerResponse.createByErrorMessage("�Ҳ���ǰ�û�");
		}
		//��������Ϊ��
		user.setPassword(StringUtils.EMPTY);
		return ServerResponse.createBySuccess(user);
	}
	
	

}
