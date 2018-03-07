package com.techm.mortgage.util;

public interface MySQLQuries {
	String CREATE_TABLE = "create table user(name varchar(50),mobileNumber varchar(20),email varchar(50),"
			+ "userPassword varchar(50),gender varchar(10),address varchar(80),PRIMARY KEY (email))";
	
	String GET_USER = "SELECT * FROM user WHERE email = ?";
	
	String ADD_USER = "INSERT INTO user (name, email, userPassword) VALUES (?, ?, ?)";
	String SAVE_PERSONAL_DETAILS = "INSERT INTO personaldetails (name, phone, salary, email, address) VALUES (?, ?, ?, ?, ?)";
}

