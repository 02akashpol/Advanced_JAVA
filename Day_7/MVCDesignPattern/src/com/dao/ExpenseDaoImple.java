package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.conn.MyConn;
import com.dto.Expense;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteExpense(int expenseId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Expense> expenseList(int expenseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expense getExpense(int expenseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
