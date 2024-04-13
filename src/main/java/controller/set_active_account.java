package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setactiveaccount")
public class set_active_account extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acc_no = req.getParameter("acno");
		long ac_number=Long.parseLong(acc_no);
		//here we going to set the active account using session tracking'
		
		req.getSession().setAttribute("ac_number",ac_number);
		req.getRequestDispatcher("Account_home.html").include(req, resp);
		
		
	}

}
