package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Customer_Dao;
import dto.Customer;

@WebServlet("/cutomerLogin")
public class CustomerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("id");

		int customerid = Integer.parseInt(cid);
		String password = req.getParameter("password");

		Customer_Dao customer_Dao = new Customer_Dao();
		Customer customer = customer_Dao.login(customerid);//inside customer ref.variable whole customer information is there
		if (customer == null) {
			resp.getWriter().print("<h1>Invalid customer id</h1>");
			req.getRequestDispatcher("Home.html").include(req, resp);
		} 
		else {
			if (customer.getPwd().equals(password)) {
				resp.getWriter().print("<h1>Login Successfull</h1>");
				//session tracking
				req.getSession().setAttribute("customer", customer);//it is used to store or set the information of customer or user which can be used in future also(set attribute is the method in which will take parameter as key and value format)
				req.getRequestDispatcher("Customer_home.html").include(req, resp);
			} 
			else {
				resp.getWriter().print("<h1>Invalid Password</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
			}
		}

	}
}
