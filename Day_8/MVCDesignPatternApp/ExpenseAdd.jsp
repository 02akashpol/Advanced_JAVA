
<%@page import="com.service.ExpenseServiceImple"%>
<%@page import="com.service.ExpenseService"%>
<jsp:useBean id="expense" class="com.dto.Expense" scope="page"></jsp:useBean>
<jsp:useBean id="user" class="com.dto.User" scope="session"></jsp:useBean>

<jsp:setProperty name="expense" property="*"/>

<%

	expense.setUserId(user.getUserId());

	System.out.println(user);

	ExpenseService expenseService = new ExpenseServiceImple();
	
	int recv = expenseService.insertExpense(expense);
	
	if(recv == 1)
		response.sendRedirect("ExpenseList.jsp");
	else
		response.sendRedirect("ExpenseAddForm.jsp?errorMsg=Failed to add expense.");

%>