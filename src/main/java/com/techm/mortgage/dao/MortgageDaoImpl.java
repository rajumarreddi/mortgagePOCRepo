package com.techm.mortgage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.techm.mortgage.bean.DBCredentials;
import com.techm.mortgage.bean.LoginBean;
import com.techm.mortgage.bean.PersonalDetailsBean;
import com.techm.mortgage.bean.RegistrationBean;
import com.techm.mortgage.util.DaoHelper;
import com.techm.mortgage.util.MySQLQuries;


@Repository
public class MortgageDaoImpl implements MortgageDao{
	private static final Logger logger = LoggerFactory.getLogger(MortgageDaoImpl.class);
	
	Set<RegistrationBean> userSet = new HashSet<RegistrationBean>();
	
	@Override
	public LoginBean verifyUser(LoginBean loginBean) {
        try(Connection con = DaoHelper.getInstance().getConnection();
        		PreparedStatement statement = con.prepareStatement(MySQLQuries.GET_USER);) {
        	statement.setString(1, loginBean.getEmailId());
        	ResultSet resultSet = statement.executeQuery();
        	if (resultSet.next()) {
                String email = resultSet.getString("email");
                String pwd = resultSet.getString("userPassword");
                String name = resultSet.getString("name");
                if(null != loginBean && loginBean.getEmailId().equalsIgnoreCase(email)){
            		if(loginBean.getPassword().equalsIgnoreCase(pwd)){
            			loginBean.setValidUser(Boolean.TRUE);
            			loginBean.setName(name);
            		}
            	}
            }
        	if(null != resultSet && !resultSet.isClosed()) {
        		resultSet.close();
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("In MortgageDaoImpl::verifyUser : "+loginBean);
		return loginBean;
	}
	
	@Override
	public RegistrationBean addUser(RegistrationBean rBean) {
		if(null != rBean && isUserExists(rBean)) {
			rBean.setRegistered(false);
			rBean.setUserExists(true);
		}else {
			try(Connection con = DaoHelper.getInstance().getConnection();
					PreparedStatement statement = con.prepareStatement(MySQLQuries.ADD_USER);){
				statement.setString(1, rBean.getFullName());
				statement.setString(2, rBean.getEmail());
				statement.setString(3, rBean.getPassword());
				boolean rowInserted = statement.executeUpdate() > 0;
				logger.info("User has been registered successfully..!!"+rowInserted);
				rBean.setRegistered(true);
				rBean.setUserExists(false);
			}
			catch(Exception ex) {
				logger.info("Failed to register user...!!");
				ex.printStackTrace();
			}
		}
		return rBean;
	}

	@Override
	public boolean isUserExists(RegistrationBean rBean) {
		boolean flag = false;
		LoginBean loginBean = new LoginBean();
		loginBean.setEmailId(rBean.getEmail());
		loginBean.setPassword(rBean.getPassword());
		loginBean = verifyUser(loginBean);
		if(null != loginBean && loginBean.getValidUser()) {
			flag = true;
		}
		return flag;
	}

	@Override
	public void createTable(DBCredentials dbCredentials) {
		try(Connection con = DaoHelper.getInstance().getConnection();
				Statement stmt = con.createStatement();
				) {
			stmt.executeUpdate(dbCredentials.getMySQLQuery());
			logger.info("Query :: "+dbCredentials.getMySQLQuery());
			logger.info("table has been created...");
		} catch (SQLException e) {
			logger.info("Unable to create table..");
			e.printStackTrace();
		}
	}
//name, phone, salary, email, address
	@Override
	public PersonalDetailsBean savePersonalDetails(PersonalDetailsBean rBean) {
		try(Connection con = DaoHelper.getInstance().getConnection();
				PreparedStatement statement = con.prepareStatement(MySQLQuries.SAVE_PERSONAL_DETAILS);){
			statement.setString(1, rBean.getName());
			statement.setString(2, rBean.getPhone());
			statement.setInt(3, rBean.getSalary());
			statement.setString(4, rBean.getEmail());
			statement.setString(5, rBean.getAddress());
			boolean rowInserted = statement.executeUpdate() > 0;
			logger.info("User data been saved successfully..!!"+rowInserted);
			rBean.setDataSaved(rowInserted);
		}
		catch(Exception ex) {
			logger.info("Failed to save user data...!!");
			rBean.setDataSaved(false);
			ex.printStackTrace();
		}
		return rBean;
	}
	
	

}
