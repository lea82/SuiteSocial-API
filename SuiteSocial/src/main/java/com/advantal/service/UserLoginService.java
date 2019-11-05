package com.advantal.service;

import com.advantal.model.UserLogin;

public interface UserLoginService {
	
	public boolean userLogin(UserLogin userLogin);
	
	public boolean resetPassword(UserLogin userLogin);

	public boolean forwardLink(UserLogin userLogin);

}
