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

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amt=req.getParameter("amnt");
		double amount=Double.parseDouble(amt);
		
		long acno=(Long)req.getSession().getAttribute("ac_number");
		
		Bank_Dao bank_Dao=new Bank_Dao();
		
		
		Bank_Account bank_Account=bank_Dao.find(acno);
		if(bank_Account.getAmount()<amount)
		{
			resp.getWriter().print("<h1>Insuffucient balance & your available balance is: "+ bank_Account.getAmount()+"</h1>");
		}
		else {
			if(amount>bank_Account.getAcc_limit())
			{
				resp.getWriter().print("<h1> You are exceding limit your account limit is"+ bank_Account.getAcc_limit()+"</h1>");
			}
			else {
				bank_Account.setAmount(bank_Account.getAmount()-amount);
				
				
				
				BankTransaction bankTransaction=new BankTransaction();
				bankTransaction.setDeposit(0);
				bankTransaction.setWithdraw(amount);
				bankTransaction.setBalance(bank_Account.getAmount());
				bankTransaction.setDate_time(LocalDateTime.now());
				
				List<BankTransaction> list=bank_Account.getList();
				list.add(bankTransaction);//previous transaction history + current transaction
				bank_Account.setList(list);
				
				bank_Dao.update_the_detail(bank_Account);
				resp.getWriter().print("<h1>Amount withdraw Successful</h1>");
				req.getRequestDispatcher("Account_home.html").include(req, resp);
				
			}
		}
		
 
	}

}
