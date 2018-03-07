package com.techm.mortgage.bean;

public class PersonalDetailsBean {
	private String name;
	private String phone;
	private int salary;
	private String email;
	private String address;
	private boolean dataSaved;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isDataSaved() {
		return dataSaved;
	}
	public void setDataSaved(boolean dataSaved) {
		this.dataSaved = dataSaved;
	}
}

