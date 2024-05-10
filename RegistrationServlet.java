package com.mohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.CustomerDAO;
import com.mohit.Customer;
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		PrintWriter out;
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		String address=request.getParameter("address");
		long mobile=Long.parseLong(request.getParameter("mobilenumber"));
		String userName=request.getParameter("username");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		CustomerDAO cus=new CustomerDAO();
		if(cus.getUserNames(userName)) {
			try {
				out=response.getWriter();
				out.print("This username is not available");
				RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
				rd.include(request, response);
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(cus.getMobileNumbers(mobile)) {
			try {
				out=response.getWriter();
				out.print("Already Registered From this Mobile number");
				RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
				rd.include(request, response);
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(password1.equals(password2)) {
			try {
				Customer c=new Customer(firstName,lastName,address,mobile,userName,password1);
				if(cus.addCustomer(c)) {
					out=response.getWriter();
					out.print("You have Successfully Registered");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
				}
				else {
					out=response.getWriter();
					out.print("Something Went Wrong");
				}
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				out=response.getWriter();
				out.print("Password and Confirm Password Doesn't Match");
				RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
				rd.include(request, response);
			} catch (IOException | ServletException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		
	}
}
