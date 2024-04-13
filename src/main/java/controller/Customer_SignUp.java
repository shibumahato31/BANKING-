package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Customer_Dao;
import dto.Customer;

@WebServlet("/Customer_SignUp")
public class Customer_SignUp extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		long mob = Long.parseLong(phone);
		String pass = req.getParameter("pass");
		String email = req.getParameter("email");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		/*
		 * resp.getWriter().print("<h1>"+name+"</h1>");
		 * resp.getWriter().print("<h1>"+phone+"</h1>");
		 * resp.getWriter().print("<h1>"+pass+"</h1>");
		 * resp.getWriter().print("<h1>"+email+"</h1>");
		 * resp.getWriter().print("<h1>"+dob+"</h1>");
		 * resp.getWriter().print("<h1>"+gender+"</h1>");
		 */

		Date date = Date.valueOf(dob);
		Period period = Period.between(date.toLocalDate(), LocalDate.now());
		int age = period.getYears();
		Customer customer = new Customer();
		Customer_Dao customer_Dao = new Customer_Dao();
		if (age > 18) {
			if (customer_Dao.check1(email).isEmpty() && customer_Dao.check2(mob).isEmpty()) {
				// customer.setCid(); It will be auto generated
				customer.setCname(name);
				customer.setCphone(mob);
				customer.setPwd(pass);
				customer.setC_email(email);
				customer.setDate(date);
				customer.setGender(gender);
				customer_Dao.save(customer);
				//resp.getWriter().print("<h1> Account has been created successfully.</h1>");
				Customer customer2=customer_Dao.check1(email).get(0);
				//Customer customer2=list.get(0);
				if(customer2.getGender().equals("female")) {
					resp.getWriter().print("<h1> Hello Madam</h1>");
				}
				else {
					resp.getWriter().print("<h1> Hello sir</h1>");
				}
				resp.getWriter().print("<h1> Account has been created successfully.</h1>");
				req.getRequestDispatcher("customerLogin.html").include(req, resp);
			} 
			else {
				resp.getWriter().print("<h1> Account is already existed.</h1>");
			}
		}
		else {
			resp.getWriter().print("<h1> You are not eligible to create an account.</h1>");
		}
	}
}
