package com.mohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.BookingDAO;
import com.data.BusDAO;
import com.data.CustomerDAO;
import com.mohit.Booking;
import com.mohit.Bus;

@WebServlet("/cancelticket")
public class CancelTicketServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		HttpSession session =request.getSession();
		String userName=String.valueOf(session.getAttribute("userName"));
		CustomerDAO c=new CustomerDAO();
		int customerid=c.getId(userName);
		BookingDAO booking=new BookingDAO();
		List<Booking> book=booking.getBooking(customerid);
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<book.size();i++) {
			BusDAO busdao=new BusDAO();
			Bus b=busdao.getBus(book.get(i).getBusid());
			try {
				out = response.getWriter();
				out.print("<style>");
				out.print("  table {");
				out.print("    border-collapse: collapse;");
				out.print("    width: 100%;");
				out.print("    font-family: Arial, sans-serif;");
				out.print("  }");
				out.print("  th, td {");
				out.print("    border: 1px solid #dddddd;");
				out.print("    text-align: left;");
				out.print("    padding: 8px;");
				out.print("  }");
				out.print("  tr:nth-child(even) {");
				out.print("    background-color: #f2f2f2;");
				out.print("  }");
				out.print("  form {");
				out.print("    margin-top: 10px;");
				out.print("  }");
				out.print("  button {");
				out.print("    background-color: #4CAF50;");
				out.print("    color: white;");
				out.print("    padding: 10px 15px;");
				out.print("    border: none;");
				out.print("    cursor: pointer;");
				out.print("    border-radius: 5px;");
				out.print("  }");
				out.print("  button:hover {");
				out.print("    background-color: #45a049;");
				out.print("  }");
				out.print("</style>");

				out.print("<table>");
				out.print("<form action=\"ticketcancel\" method=\"post\">");
				out.print("  <tr>");
				out.print("    <th colspan=\"2\">" + b.getName() + "</th>");
				out.print("  </tr>");
				out.print("  <tr>");
				out.print("    <td>Bus ID:</td>");
				out.print("    <td>");
				out.print("      <select name=\"busid\">");
				out.print("        <option value=\"" + book.get(i).getBusid() + "\">" + book.get(i).getBusid() + "</option>");
				out.print("      </select>");
				out.print("    </td>");
				out.print("  </tr>");
				out.print("  <tr>");
				out.print("    <td>Customer ID:</td>");
				out.print("    <td>");
				out.print("      <select name=\"cusid\">");
				out.print("        <option value=\"" + book.get(i).getCusid() + "\">" + book.get(i).getCusid() + "</option>");
				out.print("      </select>");
				out.print("    </td>");
				out.print("  </tr>");
				out.print("  <tr>");
				out.print("    <td>Seat Number:</td>");
				out.print("    <td>");
				out.print("      <select name=\"seatnumber\">");
				out.print("        <option value=\"" + book.get(i).getBooked_set() + "\">" + book.get(i).getBooked_set() + "</option>");
				out.print("      </select>");
				out.print("    </td>");
				out.print("  </tr>");
				out.print("  <tr>");
				out.print("    <td>" + b.getSource() + "</td>");
				out.print("  </tr>");
				out.print("  <tr>");
				out.print("    <td>" + b.getDestination() + "</td>");
				out.print("  </tr>");

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String departure = b.getDeparture().format(formatter);
				String arrival = b.getArrival().format(formatter);
				out.print("  <tr>");
				out.print("    <td>" + departure + "</td>");
				out.print("  </tr>");
				out.print("  <tr>");
				out.print("    <td>" + arrival + "</td>");
				out.print("  </tr>");
				out.print("  <tr>");
				out.print("    <td>" + book.get(i).getStatus() + "</td>");
				out.print("  </tr>");
				out.print("  <tr>");
				out.print("    <td colspan=\"2\">");
				out.print("      <button type=\"submit\">Cancel</button>");
				out.print("    </td>");
				out.print("  </tr>");
				out.print("</form>");
				out.print("</table>");
				out.print("<br>");


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			out=response.getWriter();
			out.print("<a href=\"navbarpage.jsp\">Back To Home</a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
	}
}
