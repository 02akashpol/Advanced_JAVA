package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConn {

	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/Advanced_JAVA?useSSL=FALSE";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "Akashpol@123";
	
	private Connection conn;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		if(conn == null || conn.isClosed()) {
			
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		
		return conn;
	}
	
}

