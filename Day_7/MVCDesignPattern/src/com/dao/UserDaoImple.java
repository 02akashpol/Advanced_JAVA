package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.MyConn;
import com.dto.User;

public class UserDaoImple implements UserDao {

	private MyConn myConn;
	
	public UserDaoImple() {
		
		myConn = new MyConn();
	}

	@Override
	public int insert(User user) {
		
		int recv = 0;
		
		try {
			
			Connection conn = myConn.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"insert into user(userName, password) values(?, ?)");
			
			stat.setString(1, user.getUserName());
			stat.setString(2, user.getPassword());
			
			recv = stat.executeUpdate();
			
			stat.close();
		
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		return recv;
	}

	@Override
	public boolean logIn(User user) {
		
		boolean recv = false;
		
		try {
			
			Connection conn = myConn.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"select * from user where userName = ? and password = ?");
			
			stat.setString(1, user.getUserName());
			stat.setString(2, user.getPassword());
			
			ResultSet rs = stat.executeQuery();

			if(rs.next())
				recv = true;
			
			stat.close();
		
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}

		return recv;
	}

}
