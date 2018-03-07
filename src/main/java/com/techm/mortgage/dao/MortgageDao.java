package com.techm.mortgage.dao;

import com.techm.mortgage.bean.DBCredentials;
import com.techm.mortgage.bean.LoginBean;
import com.techm.mortgage.bean.PersonalDetailsBean;
import com.techm.mortgage.bean.RegistrationBean;

public interface MortgageDao {
	public LoginBean verifyUser(LoginBean loginBean);
	public RegistrationBean addUser(RegistrationBean rBean);
	public boolean isUserExists(RegistrationBean rBean);
	public void createTable(DBCredentials dbCredentials);
	PersonalDetailsBean savePersonalDetails(PersonalDetailsBean rBean);
}
