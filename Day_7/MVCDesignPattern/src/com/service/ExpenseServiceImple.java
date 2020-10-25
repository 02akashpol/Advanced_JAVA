package com.service;

import java.util.ArrayList;

import com.dao.ExpenseDao;
import com.dao.ExpenseDaoImple;
import com.dto.Expense;

public class ExpenseServiceImple implements ExpenseService {

	private ExpenseDao expenseDao;
	
	public ExpenseServiceImple() {
		
		expenseDao = new ExpenseDaoImple();
	}

	@Override
	public int insertExpense(Expense expense) {
		
		return expenseDao.insertExpense(expense);
	}

	@Override
	public int updateExpense(Expense expense) {
		
		return 0;
	}

	@Override
	public int deleteExpense(int expenseId) {
		
		return 0;
	}

	@Override
	public ArrayList<Expense> expenseList(int expenseId) {
		
		return null;
	}

	@Override
	public Expense getExpense(int expenseId) {
		
		return null;
	}

}
