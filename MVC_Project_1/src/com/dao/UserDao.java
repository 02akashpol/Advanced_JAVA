package com.dao;

import com.dto.User;

public interface UserDao {

	int registration(User user);
	
	boolean logIn(User user);
}
