package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Bank_Dao;
import dto.Bank_Account;

@WebServlet("/changestatus")
public class Change_Status extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ac_no =req.getParameter("acno");
		long acc_no = Long.parseLong(ac_no);
		
		Bank_Dao bank_Dao=new Bank_Dao();
		Bank_Account bank_Account=bank_Dao.fetch_account_details(acc_no);
		
		if(bank_Account.isStatus())
		{
			bank_Account.setStatus(false);
		}
		else {
			bank_Account.setStatus(true);
		}
		
		bank_Dao.update_the_detail(bank_Account);
		resp.getWriter().print("<h1> Status got updated </h1>");
//		req.getRequestDispatcher("adminhome.jsp").include(req, resp);
		
		//Here i am going to take the updated information from account table
		List<Bank_Account> list=bank_Dao.fetchAll();
		//session tracking
		req.getSession().setAttribute("list", list);
		req.getRequestDispatcher("adminhome.jsp").include(req, resp);
		
	}

}
