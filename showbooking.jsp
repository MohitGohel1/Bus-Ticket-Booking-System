<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.data.CustomerDAO,java.io.IOException,com.data.BookingDAO,com.data.BusDAO,com.mohit.Bus,java.util.*,com.mohit.Booking,java.time.format.DateTimeFormatter,java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String userName=String.valueOf(session.getAttribute("userName"));
	CustomerDAO c=new CustomerDAO();
	int customerid=c.getId(userName);
	BookingDAO booking=new BookingDAO();
	List<Booking> book=booking.getBooking(customerid);
	for(int i=0;i<book.size();i++) {
		BusDAO busdao=new BusDAO();
		Bus b=busdao.getBus(book.get(i).getBusid());
		try {
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
		out.print("<a href=\"navbarpage.jsp\">Back To Home</a>");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>
</body>
</html>