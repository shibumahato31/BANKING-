package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Bank_Account;
import dto.Customer;

@WebServlet("/fetchactiveaccount")
public class Fetch_Active_Accounts extends HttpServlet
{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer= (Customer) req.getSession().getAttribute("customer");
		List<Bank_Account> list=customer.getBankaccounts();
		ArrayList<Bank_Account> list2=new ArrayList();
		
		for (Bank_Account bank_Account : list) {
			if(bank_Account.isStatus() == true)
			{
				list2.add(bank_Account);
			}
			 
		}
		req.getSession().setAttribute("list", list2);
		req.getRequestDispatcher("accounts.jsp").include(req, resp);
	}
}
