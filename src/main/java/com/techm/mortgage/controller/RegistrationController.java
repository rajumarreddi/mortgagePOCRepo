package com.techm.mortgage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.mortgage.bean.DBCredentials;
import com.techm.mortgage.bean.PersonalDetailsBean;
import com.techm.mortgage.bean.RegistrationBean;
import com.techm.mortgage.service.RegistrationService;
import com.techm.mortgage.util.RestURIConstants;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping(value = RestURIConstants.USER_REGISTRATION, method = RequestMethod.POST)
	public @ResponseBody RegistrationBean addUser(@RequestBody RegistrationBean rBean) {
		logger.info("Start addUser()");
		return registrationService.addUser(rBean);
	}
	
	@RequestMapping(value = RestURIConstants.CREATE_TABLE, method = RequestMethod.POST)
	public @ResponseBody void createTable(@RequestBody DBCredentials dbCredentials) {
		registrationService.createTable(dbCredentials);
	}
	
	@RequestMapping(value = RestURIConstants.SAVE_PERSONAL_DETAILS, method = RequestMethod.POST)
	public @ResponseBody PersonalDetailsBean savePersonalDetails(@RequestBody PersonalDetailsBean rBean) {
		logger.info("Start savePersonalDetails ");
		return registrationService.savePersonalDetails(rBean);
	}
	
}
