<%@page import="dto.Bank_Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Admin home page</h1>
	<% List<Bank_Account> list=(List<Bank_Account>)request.getSession().getAttribute("list"); %>
	<table border="1">
		<tr>
			<th>Account_number</th>
			<th>Account_type</th>
			<th>Customer_name</th>
			<th>Customer_id</th>
			<th>Account_status</th>
			<th>Change_status</th>
		</tr>
		<% for(Bank_Account bank_Account : list)  {%>
		<tr>
			<th><%=bank_Account.getAc_no() %></th>
			<th><%=bank_Account.getAcc_type() %></th>
			<th><%=bank_Account.getCustomer().getCname() %></th>
			<th><%=bank_Account.getCustomer().getCid() %></th>
			<th><%=bank_Account.isStatus() %></th>
			<th><%=bank_Account.isStatus() %></th>
			<th><a href="changestatus?acno=<%= bank_Account.getAc_no()%>"> <button>Change_Status</button></a></th>
		</tr>
		<%} %>
	</table>
	<br><br>
	 
</body>
</html>