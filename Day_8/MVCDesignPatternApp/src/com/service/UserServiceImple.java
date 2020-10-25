package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImple;
import com.dto.User;

public class UserServiceImple implements UserService {

	private UserDao userDao;
	
	public UserServiceImple() {
		
		userDao = new UserDaoImple();
	}

	@Override
	public int registration(User user) {
		
		return userDao.insert(user);
	}

	@Override
	public boolean logIn(User user) {
		
		return userDao.logIn(user);
	}

}
