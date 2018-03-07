package com.techm.mortgage.bean;

public class DBCredentials {
	private String dns;
	private String host;
	private int port;
	private String una;
	private String pwd;
	private boolean connectionEstablished;
	private String mySQLQuery;
	private boolean tableCreated;
	
	public String getDns() {
		return dns;
	}
	public void setDns(String dns) {
		this.dns = dns;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUna() {
		return una;
	}
	public void setUna(String una) {
		this.una = una;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isConnectionEstablished() {
		return connectionEstablished;
	}
	public void setConnectionEstablished(boolean connectionEstablished) {
		this.connectionEstablished = connectionEstablished;
	}
	public String getMySQLQuery() {
		return mySQLQuery;
	}
	public void setMySQLQuery(String mySQLQuery) {
		this.mySQLQuery = mySQLQuery;
	}
	public boolean isTableCreated() {
		return tableCreated;
	}
	public void setTableCreated(boolean tableCreated) {
		this.tableCreated = tableCreated;
	}
}
