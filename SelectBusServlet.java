package com.mohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.BusDAO;
import com.mohit.Bus;
@WebServlet("/selectbus")
public class SelectBusServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		try {
			PrintWriter out=response.getWriter();
			BusDAO bus=new BusDAO();
			List<Bus> b=bus.getBusDetails(request.getParameter("boarding_point"),request.getParameter("destination_point"));
			for(int i=0;i<b.size();i++) {
				if(b.get(i).getAvailableseats()!=0) {
					out.print("<table>");
					out.print("<tr>");
					out.print("<th>Bus Id:</th>");
					out.print("<td>"+b.get(i).getId()+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<th>Bus Name:</th>");
					out.print("<td>"+b.get(i).getName()+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<th>Source:</th>");
					out.print("<td>"+b.get(i).getSource()+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<th>Destination:</th>");
					out.print("<td>"+b.get(i).getDestination()+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<th>Type:</th>");
					out.print("<td>"+b.get(i).getType()+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<th>Departure:</th>");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			        String departure = b.get(i).getDeparture().format(formatter);
			        String arrival=b.get(i).getArrival().format(formatter);
					out.print("<td>"+departure+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<th>Arrival:</th>");
					out.print("<td>"+arrival+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<th>Available Seats:</th>");
					out.print("<td>"+b.get(i).getAvailableseats()+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<th>Fare:</th>");
					out.print("<td>"+b.get(i).getFare()+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<form action=\"seatselection\" method=\"post\">");
					out.print("<td>");
					out.print("<select name=\"idbus\">");
					out.print("<option value=\"" + b.get(i).getId() + "\">" + b.get(i).getId() + "</option>");
					out.print("</select>");
					out.print("</td>");
					out.print("<td>");
					out.print("<button type=\"submit\">Book</button>");
					out.print("</td>");
					out.print("</form>");
					out.print("</tr>");
					out.print("</table>");
					out.print("<br>");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
