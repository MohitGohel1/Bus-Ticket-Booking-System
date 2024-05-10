package com.mohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.BookingDAO;
import com.data.BusDAO;

@WebServlet("/ticketcancel")
public class TicketCancel extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		int busid=Integer.parseInt(request.getParameter("busid"));
		int cusid=Integer.parseInt(request.getParameter("cusid"));
		int seatnumber=Integer.parseInt(request.getParameter("seatnumber"));
		try {
			PrintWriter out=response.getWriter();
//			out.print("busid="+busid+"<br>");
//			out.print("cusid="+cusid+"<br>");
//			out.print("seatnumber="+seatnumber);
			BookingDAO booking=new BookingDAO();
			booking.cancelTicket(busid, cusid, seatnumber);
			BusDAO b=new BusDAO();
			b.setAvailableSeats1(busid);
			response.sendRedirect("cancelticket");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
	}
}
