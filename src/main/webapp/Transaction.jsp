<%@page import="java.util.List"%>
<%@page import="dto.BankTransaction"%>
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
<h1>Welcome_To_Transaction_Page</h1>
	<% long acno=(long)request.getSession().getAttribute("ac_number");
	Bank_Dao bank_Dao=new Bank_Dao();
	Bank_Account bank_Account=bank_Dao.find(acno);
	List<BankTransaction> list=bank_Account.getList();
	%>
	<table border="1">
	<tr>
	<td>Tid</td>
	<td>Deposit</td>
	<td>Withdraw</td>
	<td>view_Transaction</td>
	<td>Date</td>
	</tr>
	<% for(BankTransaction bankTransaction: list) { %>
	<tr>
	<td><%= bankTransaction.getTid() %> </td>
	<td><%= bankTransaction.getDeposit() %> </td>
	<td><%= bankTransaction.getWithdraw() %> </td>
	<td><%= bankTransaction.getBalance() %> </td>
	<td><%= bankTransaction.getDate_time()%></td>
	<%} %>
	</tr>
	</table>
</body>
</html>