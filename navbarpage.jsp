<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Ticket Reservation System</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
  }
  h1 {
    text-align: center;
    color: #333;
  }
  .options-container {
    max-width: 500px;
    margin: 20px auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  .options-container ul {
    list-style-type: none;
    padding: 0;
  }
  .options-container li {
    margin-bottom: 10px;
  }
  .options-container a {
    display: block;
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    text-decoration: none;
    border-radius: 4px;
    text-align: center;
  }
  .options-container a:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>

<h1>Bus Ticket Reservation System</h1>

<div class="options-container">
  <ul>
    <li><a href="busschedule">Book Ticket</a></li>
    <li><a href="cancelticket">Cancel Ticket</a></li>
    <li><a href="showbooking.jsp">Show Bookings</a></li>
  </ul>
</div>

</body>
</html>