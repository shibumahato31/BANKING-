package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Bank_Dao;
import dao.Customer_Dao;
import dto.Bank_Account;
import dto.Customer;

@WebServlet("/createbankaccount")
public class CreateBankAccount extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acc_type=req.getParameter("accounttype");
		Customer customer=(Customer) req.getSession().getAttribute("customer"); 
		List<Bank_Account> list=customer.getBankaccounts();
		
		boolean flag=true;
		
		for (Bank_Account bank_Account : list) {
			
			if(bank_Account.getAcc_type().equals(acc_type))
			{
				flag=false;
				break;
			}
		}
		
		if (flag==true) {
			Bank_Account bank_Account=new  Bank_Account();
			//bank_Account.setAc_no(0);
			//bank_Account.setStatus(flag);
			//bank_Account.setAmount(0);
			bank_Account.setAcc_type(acc_type);
			
			if(bank_Account.getAcc_type().equals("savings"))
			{
				bank_Account.setAcc_limit(10000);
			}
			else {
				bank_Account.setAcc_limit(15000);
			}
			
			bank_Account.setCustomer(customer);
			
			Bank_Dao bank_Dao=new  Bank_Dao();
			bank_Dao.save_account(bank_Account);
			
			List<Bank_Account> list2=list;
			list2.add(bank_Account);
			
			Customer_Dao customer_Dao=new  Customer_Dao();
			customer_Dao.update(customer);
			resp.getWriter().print("<h1>Congratulations your account has been created successfully .Please wait for Manager approval</h1>");
			req.getRequestDispatcher("Home.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1>Already account is existed</h1>");
		}
	}
}
