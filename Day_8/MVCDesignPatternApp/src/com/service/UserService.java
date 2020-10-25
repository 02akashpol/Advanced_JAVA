package com.service;

import com.dto.User;

public interface UserService {

	int registration(User user);
	
	boolean logIn(User user);
}
