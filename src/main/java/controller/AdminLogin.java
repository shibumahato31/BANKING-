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

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		Bank_Dao bank_Dao=new Bank_Dao();

		if(email.equals("admin@gmail.com") && name.equals("admin"))
		{
			resp.getWriter().print("<h1>Admin Login Success</h1>");
			List<Bank_Account> list=bank_Dao.fetchAll();
			
			//session tracking
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("adminhome.jsp").include(req, resp);

		}
		else {
			resp.getWriter().print("<h1>Invalid Login</h1>");
		}
	}
}
