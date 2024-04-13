<%@page import="dto.Bank_Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_To_Account_Account</h1>
<% List<Bank_Account> list =(List<Bank_Account>)request.getSession().getAttribute("list");
if(list.isEmpty())
{%>
	<h1>No_Active_Account</h1>
 
<%} else {%>

<h1>Select_bank_Account</h1>
<% for(Bank_Account bank_Account: list) {%>
<a href="setactiveaccount?acno=<%=bank_Account.getAc_no() %>"><button><%=bank_Account.getAc_no() %></button></a>

<% } %>
<% } %>

 
</body>
</html>