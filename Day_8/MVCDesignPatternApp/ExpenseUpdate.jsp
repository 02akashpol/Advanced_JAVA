<%@page import="com.service.ExpenseService"%>
<%@page import="com.service.ExpenseServiceImple"%>

<jsp:useBean id="expense" class="com.dto.Expense" scope="session"></jsp:useBean>
<jsp:setProperty name="expense" property="*"/>

<%

	ExpenseService expenseService = new ExpenseServiceImple();
	int recv = expenseService.updateExpense(expense);
	
	//System.out.println(recv);
	
	if(recv == 1)
		response.sendRedirect("ExpenseList.jsp");
	else
%>		<%= "Failed to update expense." %>

