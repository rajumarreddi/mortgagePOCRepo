package com.techm.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.mortgage.bean.DBCredentials;
import com.techm.mortgage.bean.PersonalDetailsBean;
import com.techm.mortgage.bean.RegistrationBean;
import com.techm.mortgage.dao.MortgageDao;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	@Autowired
	MortgageDao mortgageDao;

	@Override
	public RegistrationBean addUser(RegistrationBean rBean) {
		return mortgageDao.addUser(rBean);
	}

	@Override
	public void createTable(DBCredentials dbCredentials) {
		mortgageDao.createTable(dbCredentials);
	}

	@Override
	public PersonalDetailsBean savePersonalDetails(PersonalDetailsBean rBean) {
		return mortgageDao.savePersonalDetails(rBean);
	}

}
