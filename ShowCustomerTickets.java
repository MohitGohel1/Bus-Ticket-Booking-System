package com.mohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.BookingDAO;
import com.data.BusDAO;
import com.data.CustomerDAO;
import com.mohit.Booking;
import com.mohit.Bus;
import com.mohit.Customer;

@WebServlet("/showcustomerticket")
public class ShowCustomerTickets extends HttpServlet{


	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		BookingDAO b=new BookingDAO();
		Booking booking=new Booking();
		List<Booking> list=b.getAllBooking();
		BusDAO busdao=new BusDAO();
		CustomerDAO cusdao=new CustomerDAO();
		try {
			PrintWriter out=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<list.size();i++) {
			Bus bus=busdao.getBus(list.get(i).getBusid());
			Customer cus=cusdao.getCustomer(list.get(i).getCusid());
			if(list.get(i).getStatus().equals("nc")) {
				try {
					PrintWriter out=response.getWriter();
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
					out.print("<form action=\"confirmticket\" method=\"post\">");
					out.print("  <tr>");
					out.print("    <th colspan=\"2\">" + bus.getName() + "</th>");
					out.print("  </tr>");
					out.print("  <tr>");
					out.print("    <td>Bus ID:</td>");
					out.print("    <td>");
					out.print("      <select name=\"busid\">");
					out.print("        <option value=\"" + list.get(i).getBusid() + "\">" + list.get(i).getBusid() + "</option>");
					out.print("      </select>");
					out.print("    </td>");
					out.print("  </tr>");
					out.print("  <tr>");
					out.print("    <td>Customer ID:</td>");
					out.print("    <td>");
					out.print("      <select name=\"cusid\">");
					out.print("        <option value=\"" + list.get(i).getCusid() + "\">" + list.get(i).getCusid() + "</option>");
					out.print("      </select>");
					out.print("    </td>");
					out.print("  </tr>");
					out.print("  <tr>");
					out.print("    <td>Seat Number:</td>");
					out.print("    <td>");
					out.print("      <select name=\"seatnumber\">");
					out.print("        <option value=\"" + list.get(i).getBooked_set() + "\">" + list.get(i).getBooked_set() + "</option>");
					out.print("      </select>");
					out.print("    </td>");
					out.print("  </tr>");
					out.print("  <tr>");
					out.print("    <td>" + bus.getSource() + "</td>");
					out.print("  </tr>");
					out.print("  <tr>");
					out.print("    <td>" + bus.getDestination() + "</td>");
					out.print("  </tr>");

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String departure = bus.getDeparture().format(formatter);
					String arrival = bus.getArrival().format(formatter);
					out.print("  <tr>");
					out.print("    <td>" + departure + "</td>");
					out.print("  </tr>");
					out.print("  <tr>");
					out.print("    <td>" + arrival + "</td>");
					out.print("  </tr>");
					out.print("  <tr>");
					out.print("    <td>" + list.get(i).getStatus() + "</td>");
					out.print("  </tr>");
					out.print("  <tr>");
					out.print("    <td colspan=\"2\">");
					out.print("      <button type=\"submit\">Confirm</button>");
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
			
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
	}
}
