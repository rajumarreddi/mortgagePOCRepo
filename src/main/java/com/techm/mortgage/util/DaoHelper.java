package com.techm.mortgage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.mortgage.bean.DBCredentials;

public class DaoHelper {
	
	private static DaoHelper daoHelper = null;
	private static Connection connection = null;
	private static final Logger logger = LoggerFactory.getLogger(DaoHelper.class);
	
	private DaoHelper() {
		super();
	}
	
	public static DaoHelper getInstance(){
		daoHelper = new DaoHelper();
		return daoHelper;
	}
	
	public DBCredentials testDBConnection(DBCredentials credentials) {
		logger.info("-------- MySQL JDBC Connection Testing ------------");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		logger.info("MySQL JDBC Driver Registered!");
		} catch (ClassNotFoundException e) {
			logger.info("Failed to register MySQL JDBC Driver...");
			e.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://"+credentials.getHost()+":"+credentials.getPort()+"/"+credentials.getDns(),
				credentials.getUna(),credentials.getPwd())){
			if (connection != null) {
				logger.info("You made it, take control your database now!");
				credentials.setConnectionEstablished(true);
			} else {
				logger.info("Failed to establish connection!");
			}
		} catch (Exception e) {
			logger.info("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return credentials;
	}

	public Connection getConnection() {
		DBCredentials credentials = getDBCredentials();
		try {
			if(null == connection || connection.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://"+credentials.getHost()+":"+credentials.getPort()+"/"+credentials.getDns(),
						credentials.getUna(),credentials.getPwd());
			}
		}catch (Exception e) {
			logger.info("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection() {
			try {
				if(null != connection && !connection.isClosed()) {
					connection.close();
					logger.info("Connection has been closed...!!");
				}
			} catch (SQLException e) {
				logger.info("Failed to close connection...");
				e.printStackTrace();
			}
		}
	
	public static DBCredentials getDBCredentials() {
		DBCredentials dbCredentials = new DBCredentials();
		dbCredentials.setHost("us-cdbr-iron-east-05.cleardb.net");
		dbCredentials.setPort(3306);
		dbCredentials.setUna("b001e9fc992e4c");
		dbCredentials.setPwd("ac36815f");
		dbCredentials.setDns("ad_c8f80d7d0b4f5cb");
		return dbCredentials;
	} 
	}
	
