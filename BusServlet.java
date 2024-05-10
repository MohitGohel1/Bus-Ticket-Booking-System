package com.mohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.BusDAO;
import com.mohit.Bus;

@WebServlet("/busservlet")
public class BusServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		String busName=request.getParameter("busName");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String type=request.getParameter("type");
		LocalDate departure=Date.valueOf(request.getParameter("departureDate")).toLocalDate();
		LocalDate arrival=Date.valueOf(request.getParameter("arrivalDate")).toLocalDate();
		int totalseats=Integer.parseInt(request.getParameter("totalSeats"));
		int availableseats=Integer.parseInt(request.getParameter("availableSeats"));
		int fare=Integer.parseInt(request.getParameter("fare"));
		Bus b=new Bus(busName,source,destination,type,departure,arrival,totalseats,availableseats,fare);
		
		try {
			PrintWriter out=response.getWriter();
			BusDAO bus=new BusDAO();
			if(bus.addBus(b)) {
				out.print("Successfully Stored the Data into Data base");
				out.print("<a href=\"bus.jsp\">Want to Add again</a>");
				out.print("<a href=\"adminnavbar.jsp\">home page</a>");
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
