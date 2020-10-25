package com.dao;

import com.dto.User;

public interface UserDao {

	int insert(User user);
	
	boolean logIn(User user);
	
}
