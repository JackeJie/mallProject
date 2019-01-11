package com.mallProject.demo.service;

import com.mallProject.demo.common.ServerResponse;
import com.mallProject.demo.entity.MmallUser;

@SuppressWarnings("rawtypes")
public interface UserService {

	ServerResponse<MmallUser> login(String username, String password);

	public ServerResponse<String> register(MmallUser user);

	public ServerResponse<String> checkValid(String str, String type);

	public ServerResponse selectQuestion(String username);

	public ServerResponse CheckAnswer(String username, String question, String answer);

	public ServerResponse<String> forgetResetPassWord(String username, String passwordNew, String forgetToken);
	
	public ServerResponse<String> resetPassWord(String asswordOld,String asswordNew,MmallUser user );
	
	public ServerResponse<MmallUser> updateInformation(MmallUser user);
	
	public ServerResponse<MmallUser> getInformation(Integer userId);
}
