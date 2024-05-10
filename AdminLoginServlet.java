package com.mohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.AdminDAO;

@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		AdminDAO a=new AdminDAO();
		PrintWriter out;
		if(a.adminVerification(username, password)) {
			try {
				response.sendRedirect("adminnavbar.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				out=response.getWriter();
				out.print("UserName of Password Mismatch");
				RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
				rd.include(request, response);
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
	}
	
}
