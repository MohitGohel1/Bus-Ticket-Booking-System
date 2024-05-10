package com.mohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.BusDAO;

@WebServlet("/seatselection")
public class SeatSelectionServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		try {
			PrintWriter out=response.getWriter();
			HttpSession session=request.getSession();
			String bus=request.getParameter("idbus");
			int busid;
			if(bus!=null) {
				busid=Integer.parseInt(bus);
				session.setAttribute("busid",busid);
			}
			else {
				busid=Integer.parseInt(String.valueOf(session.getAttribute("busid")));
			}
//			int busid=Integer.parseInt(request.getParameter("idbus"));
//			out.print("Customer userName:-"+session.getAttribute("userName")+"<br>");
//			out.print("Bus Id:-"+request.getParameter("busid"));
			BusDAO b=new BusDAO();
			List<Integer> list=b.getBookedSeats(busid);
			int totalseats=b.getTotalSeats(busid);
			out.print("<form action=\"bookingseat\" method=\"post\">");
			out.print("<label>Available Seats</label>");
			out.print("<select name=\"seat\">");
			for(int i=1;i<=totalseats;i++) {
				if(list.contains(i)==false) {
					out.print("<option value=\"" + i + "\">" + i + "</option>");
				}
			}
			out.print("</select>");
			out.print("<button type=\"Submit\">Submit</button>");
			out.print("</form>");
			out.print("<br>");
			out.print("<label>Reserved Seats</label><br>");
			for(int i=0;i<=totalseats;i++) {
				if(list.contains(i)) {
					out.print(i+"<br>");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
	}
}
