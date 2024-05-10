package com.mohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.BookingDAO;
import com.data.BusDAO;
import com.data.CustomerDAO;
import com.mohit.Booking;

@WebServlet("/bookingseat")
public class BookedSeat extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		String userName=String.valueOf(session.getAttribute("userName"));
		int busid=Integer.parseInt(String.valueOf(session.getAttribute("busid")));
		int bookedseat=Integer.parseInt(request.getParameter("seat"));
		CustomerDAO c=new CustomerDAO();
		BusDAO b=new BusDAO();
		int customerid=c.getId(userName);
//		int busid=Integer.parseInt(String.valueOf(session.getAttribute("busid")));
		int fare=b.getFare(busid);
//		int bookedseat=Integer.parseInt(request.getParameter("selectseatnumber"));
		Booking booking=new Booking(customerid,busid,bookedseat,fare);
		BookingDAO book=new BookingDAO();
		BusDAO busdao=new BusDAO();
//		try {
//			response.sendRedirect("seatselection");
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();/
//		}
//		try {
////			response.sendRedirect("seatselection");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			PrintWriter out=response.getWriter();
//			out.print(busid+"<br>");
//			out.print(userName+"<br>");
//			out.print(bookedseat);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(book.addBooking(booking)) {
			busdao.setAvailableSeats(busid);
				try {
					response.sendRedirect(request.getContextPath() + "/seatselection");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
	}
}
