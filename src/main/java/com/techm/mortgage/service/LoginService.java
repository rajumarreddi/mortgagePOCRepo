package com.techm.mortgage.service;

import com.techm.mortgage.bean.LoginBean;
import com.techm.mortgage.bean.RegistrationBean;

public interface LoginService {
	public LoginBean verifyUser(LoginBean loginBean);
	public boolean isUserExists(RegistrationBean rBean);
}
