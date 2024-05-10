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
@WebServlet("/busschedule")
public class BusScheduleServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		try {
			PrintWriter out=response.getWriter();
			HttpSession session=request.getSession();
//			out.print(session.getAttribute("userName"));
			BusDAO busd=new BusDAO();
			List<String> boarding=busd.getsource();
			List<String> destination=busd.getdestination();
			out.print("<title>Select Boarding and Destination Points</title>\r\n"
					+ "<style>\r\n"
					+ "  body {\r\n"
					+ "    font-family: Arial, sans-serif;\r\n"
					+ "    background-color: #f4f4f4;\r\n"
					+ "    margin: 0;\r\n"
					+ "    padding: 0;\r\n"
					+ "  }\r\n"
					+ "  h1 {\r\n"
					+ "    text-align: center;\r\n"
					+ "    color: #333;\r\n"
					+ "  }\r\n"
					+ "  .container {\r\n"
					+ "    max-width: 500px;\r\n"
					+ "    margin: 20px auto;\r\n"
					+ "    background-color: #fff;\r\n"
					+ "    padding: 20px;\r\n"
					+ "    border-radius: 8px;\r\n"
					+ "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
					+ "  }\r\n"
					+ "  label {\r\n"
					+ "    display: block;\r\n"
					+ "    margin-bottom: 10px;\r\n"
					+ "    color: #555;\r\n"
					+ "  }\r\n"
					+ "  select {\r\n"
					+ "    width: 100%;\r\n"
					+ "    padding: 8px;\r\n"
					+ "    margin-bottom: 15px;\r\n"
					+ "    border: 1px solid #ccc;\r\n"
					+ "    border-radius: 4px;\r\n"
					+ "    box-sizing: border-box;\r\n"
					+ "  }\r\n"
					+ "  input[type=\"submit\"] {\r\n"
					+ "    background-color: #007bff;\r\n"
					+ "    color: #fff;\r\n"
					+ "    border: none;\r\n"
					+ "    padding: 10px 20px;\r\n"
					+ "    border-radius: 4px;\r\n"
					+ "    cursor: pointer;\r\n"
					+ "  }\r\n"
					+ "  input[type=\"submit\"]:hover {\r\n"
					+ "    background-color: #0056b3;\r\n"
					+ "  }\r\n"
					+ "</style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<h1>Select Boarding and Destination Points</h1>\r\n"
					+ "\r\n"
					+ "<div class=\"container\">\r\n"
					+ "  <form action=\"selectbus\" method=\"post\">\r\n"
					+ "    <label for=\"boarding_point\">Select Boarding Point:</label>\r\n"
					+ "    <select name=\"boarding_point\" id=\"boarding_point\">");
			for(int i=0;i<boarding.size();i++) {
				out.print("<option value=\"" + boarding.get(i) + "\">" + boarding.get(i) + "</option>");
			}
			out.print("    </select>\r\n"
					+ "\r\n"
					+ "    <label for=\"destination_point\">Select Destination Point:</label>\r\n"
					+ "    <select name=\"destination_point\" id=\"destination_point\">");
			for(int i=0;i<boarding.size();i++) {
				out.print("<option value=\"" + destination.get(i) + "\">" + destination.get(i) + "</option>");
			}
			out.print("    </select>\r\n"
					+ "\r\n"
					+ "    <input type=\"submit\" value=\"Submit\">\r\n"
					+ "  </form>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
	}
}
