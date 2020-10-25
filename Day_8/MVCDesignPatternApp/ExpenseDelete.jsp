
<%@page import="com.service.ExpenseService"%>
<%@page import="com.service.ExpenseServiceImple"%>
<%

	int expenseId = Integer.parseInt(request.getParameter("expenseId"));
	ExpenseService expenseService = new ExpenseServiceImple();	
	int recv = expenseService.deleteExpense(expenseId);
	
	if(recv == 1)
		response.sendRedirect("ExpenseList.jsp");
	else
%>		<%= "Failed to delete expense." %>
	


