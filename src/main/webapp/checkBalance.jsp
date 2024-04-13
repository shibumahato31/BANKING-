<%@page import="dto.Customer"%>
<%@page import="dto.Bank_Account"%>
<%@page import="dao.Bank_Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% long acno =(long)request.getSession().getAttribute("ac_number");
	Bank_Dao bank_Dao=new Bank_Dao();
	Bank_Account bank_Account=bank_Dao.find(acno);
	Customer customer=bank_Account.getCustomer();
	
	%>
	<h1>Hello <%if(customer.getGender().equals("male")) {%> Mr. <%} else {%> Miss. <%}%> <%= customer.getCname() %></h1>
	<h1>Hello : Your account balance is <%= bank_Account.getAmount() %></h1>
	<a href="Account_home.html"><button>Back</button></a>
</body>
</html>