package com.mohit.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.BookingDAO;

@WebServlet("/confirmticket")
public class GiveConfirmation extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		int busid=Integer.parseInt(request.getParameter("busid"));
		int cusid=Integer.parseInt(request.getParameter("cusid"));
		int seatnumber=Integer.parseInt(request.getParameter("seatnumber"));
		
		BookingDAO booking=new BookingDAO();
		booking.confirmTicket(busid, cusid, seatnumber);
		try {
			response.sendRedirect("showcustomerticket");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
	}
}
