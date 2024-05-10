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
  form {
    max-width: 500px;
    margin: 20px auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  label {
    display: block;
    margin-bottom: 5px;
    color: #555;
  }
  input[type="text"] {
    width: 100%;
    padding: 8px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }
  input[type="text"]:focus {
    outline: none;
    border-color: #007bff;
  }
  input[type="submit"] {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    cursor: pointer;
  }
  input[type="submit"]:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>

<h1>Bus Ticket Reservation System</h1>

<form action="register" method="post">
  <label for="firstname">First Name:</label>
  <input type="text"  name="firstname" pattern="[A-Za-z]+" required>

  <label for="lastname">Last Name:</label>
  <input type="text"  name="lastname" pattern="[A-Za-z]+" required>

  <label for="address">Address:</label>
  <input type="text"  name="address" required>

  <label for="mobilenumber">Mobile Number:</label>
  <input type="text" name="mobilenumber" pattern="[0-9]{10}" maxlength="10" required>

  <label for="username">Username:</label>
  <input type="text"  name="username" required>

  <label for="password1">Password:</label>
  <input type="password"  name="password1" required>

  <label for="password2">Confirm Password:</label>
  <input type="password" name="password2" required>

  <input type="submit" value="Submit">
</form>
<div class="login-link">
  <p>Already registered? <a href="Login.jsp">Login here</a></p>
  <p>Admin? <a href="admin.jsp">Admin Login</a></p>
</div>
</body>
</html>
