<%!

	String msg;
	void validate(String userName, String password) {
	
		if(userName == "Akash" && password == "Pol")
			msg = "Your inputs are valid.";
		else
			msg = "Please provide the valid credentials.";
	}

%>

<% 

	String recv1 = request.getParameter("userName");
	String recv2 = request.getParameter("password");
	
	String userName[] = recv1.split(" ");
	String password[] = recv2.split(" ");
	
	validate(userName[0], password[0]);

%>

<%= msg %>