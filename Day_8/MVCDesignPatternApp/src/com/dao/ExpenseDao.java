package com.dao;

import java.util.ArrayList;

import com.dto.Expense;

public interface ExpenseDao {

	int insertExpense(Expense expense);
	
	int updateExpense(Expense expense);
	
	int deleteExpense(int expenseId);
	
	ArrayList<Expense> expenseList(int expenseId);
	
	Expense getExpense(int expenseId);
}
