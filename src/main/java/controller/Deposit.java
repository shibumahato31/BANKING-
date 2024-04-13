package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Bank_Dao;
import dto.BankTransaction;
import dto.Bank_Account;

@WebServlet("/deposit")
public class Deposit extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String amt=req.getParameter("amnt");
		double amount=Double.parseDouble(amt);
		
		
		long acno=(Long)req.getSession().getAttribute("ac_number");
		Bank_Dao bank_Dao=new Bank_Dao();
		
		
		Bank_Account bank_Account=bank_Dao.find(acno);
		bank_Account.setAmount(bank_Account.getAmount()+amount);
		
		BankTransaction bankTransaction=new BankTransaction();
		bankTransaction.setDeposit(amount);
		bankTransaction.setWithdraw(0);
		bankTransaction.setBalance(bank_Account.getAmount());
		bankTransaction.setDate_time(LocalDateTime.now());
		
		List<BankTransaction> list=bank_Account.getList();
		list.add(bankTransaction);//previous transaction history + current transaction
		bank_Account.setList(list);
		
		bank_Dao.update_the_detail(bank_Account);
		resp.getWriter().print("<h1>Amount Deposit Successful</h1>");
		req.getRequestDispatcher("Account_home.html").include(req, resp);
		
	}

}
