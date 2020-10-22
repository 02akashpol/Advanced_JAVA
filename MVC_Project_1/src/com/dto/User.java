package com.dto;

public class User {

	private String fullName;
	private String userName;
	private String password;
	
	public User() {
	
		super();
	
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return fullName + " " + userName + " " + password;
	}
		
}
