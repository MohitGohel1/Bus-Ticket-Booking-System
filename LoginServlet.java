package com.mohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.CustomerDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		CustomerDAO d=new CustomerDAO();
		PrintWriter out;
		if(d.validateCustomer(userName, password)) {
			try {
//				out=response.getWriter();
//				out.print("Successfully Login");
				HttpSession session=request.getSession();
				session.setAttribute("userName",userName);
				response.sendRedirect("navbarpage.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				out=response.getWriter();
				out.print("You Have Entered Wrong userName or Password");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
