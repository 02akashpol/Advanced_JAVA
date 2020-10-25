package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.conn.MyConn;
import com.dto.Expense;
import com.mysql.cj.protocol.Resultset;

public class ExpenseDaoImple implements ExpenseDao {

	private MyConn myConn;
	
	public ExpenseDaoImple() {
		
		myConn = new MyConn();
	}

	@Override
	public int insertExpense(Expense expense) {
		
		int recv = 0;
		
		try {
		
			Connection conn = myConn.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"insert into expense(itemName, price, date, userId) values(?, ?, ?, ?) ");
		
			stat.setString(1, expense.getItemName());
			stat.setFloat(2, expense.getPrice());
			stat.setString(3, expense.getDate());
			stat.setInt(4, expense.getUserId());
			
			recv = stat.executeUpdate();
			
			if(recv == 1)
				return recv;
			
			stat.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return recv;
	}

	@Override
	public int updateExpense(Expense expense) {
		
		int recv = 0;
		
		try {
			
			Connection conn = myConn.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"update expense set itemName = ?, price = ?, date = ? where expenseId = ? ");
			
			stat.setString(1, expense.getItemName());
			stat.setFloat(2, expense.getPrice());
			stat.setString(3, expense.getDate());
			stat.setInt(4, expense.getExpenseId());
			
			
			
			recv = stat.executeUpdate();
			
			//System.out.println(expense.getExpenseId());
			//System.out.println(expense.getItemName());
			//System.out.println(expense.getPrice());
			//System.out.println(expense.getDate());
			//System.out.println(recv);
			
			if(recv == 1)
				return recv;
		
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		return recv;
	}

	@Override
	public int deleteExpense(int expenseId) {
		
		int recv = 0;
		
		try {
		
			Connection conn = myConn.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"delete from expense where expenseId = ? ");
			
			stat.setInt(1, expenseId);
			
			recv = stat.executeUpdate();
			
			if(recv == 1)
				return recv;
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return recv;
	}

	@Override
	public ArrayList<Expense> expenseList(int userId) {
		
		ArrayList<Expense> al = new ArrayList<>();
		
		Connection conn;
		try {
			conn = myConn.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"select * from expense where userId = ?");
			stat.setInt(1, userId);
			
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				
				Expense expense = new Expense();
				expense.setItemName(rs.getString("itemName"));
				expense.setPrice(rs.getFloat("price"));
				expense.setDate(rs.getString("date"));
				expense.setExpenseId(rs.getInt("expenseId"));
				
				al.add(expense);
			}
		
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public Expense getExpense(int expenseId) {
		
		Expense expense = new Expense();
		
		try {
			Connection conn = myConn.getConnection();
			PreparedStatement stat = conn.prepareStatement(
					"select * from expense where expenseId = ?");
			
			stat.setInt(1, expenseId);
			
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				
				expense.setItemName(rs.getString("itemName"));
				expense.setPrice(rs.getFloat("price"));
				expense.setDate(rs.getString("date"));
				expense.setExpenseId(rs.getInt("expenseId"));
				return expense;
			}
		
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		return expense;
	}

}
