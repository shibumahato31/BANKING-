<%@page import="dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome_To_Account_Creation_Page</h1>
	<% Customer customer =(Customer) request.getSession().getAttribute("customer"); %>
	<h1>Hello dear <%= customer.getCname() %> </h1>
	<form action="createbankaccount">
		<h2>Please Select account type</h2><br>
		<input type="radio" name="accounttype" value="savings" required>Savings <br><br>
		<input type="radio" name="accounttype" value="current" required>Current <br><br>
		<button>Submit</button>
		<button>Reset</button>
	</form>
</body>
</html>