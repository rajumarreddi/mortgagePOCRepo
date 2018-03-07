package com.techm.mortgage.service;

import com.techm.mortgage.bean.DBCredentials;
import com.techm.mortgage.bean.PersonalDetailsBean;
import com.techm.mortgage.bean.RegistrationBean;

public interface RegistrationService {
	RegistrationBean addUser(RegistrationBean rBean);
	void createTable(DBCredentials dbCredentials);
	PersonalDetailsBean savePersonalDetails(PersonalDetailsBean rBean);
}
