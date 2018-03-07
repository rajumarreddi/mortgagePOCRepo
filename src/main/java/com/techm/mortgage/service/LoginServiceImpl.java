package com.techm.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.mortgage.bean.LoginBean;
import com.techm.mortgage.bean.RegistrationBean;
import com.techm.mortgage.dao.MortgageDao;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	MortgageDao mortgageDao;
	
	@Override
	public LoginBean verifyUser(LoginBean loginBean) {
		return mortgageDao.verifyUser(loginBean);
	}

	@Override
	public boolean isUserExists(RegistrationBean rBean) {
		return mortgageDao.isUserExists(rBean);
	}
	
}
