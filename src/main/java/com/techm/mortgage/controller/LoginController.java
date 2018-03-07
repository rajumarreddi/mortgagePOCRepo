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
import com.techm.mortgage.bean.LoginBean;
import com.techm.mortgage.service.LoginService;
import com.techm.mortgage.util.DaoHelper;
import com.techm.mortgage.util.RestURIConstants;


@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/testRESTConnection")
	public String testConnection() {
		return "Hello..!! Services are up and running..!!";
	}
	
	@RequestMapping(value = RestURIConstants.USER_LOGIN, method = RequestMethod.POST)
	public @ResponseBody LoginBean verifyUser(@RequestBody LoginBean loginBean) {
		logger.info("Start verifyUser()");
		return loginService.verifyUser(loginBean);
	}
	
	@RequestMapping(value = RestURIConstants.TEST_CONNECTION, method = RequestMethod.POST)
	public @ResponseBody DBCredentials verifyUser(@RequestBody DBCredentials dbCredentials) {
		return DaoHelper.getInstance().testDBConnection(dbCredentials);
	}
	
}
