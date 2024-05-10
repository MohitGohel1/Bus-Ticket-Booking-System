<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Bus Details Form</title>
    <style>
        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Bus Details Form</h2>
    <form action="busservlet" method="post">
        <label for="busName">Bus Name:</label>
        <input type="text" id="busName" name="busName" pattern="[A-Za-z]+"  required>

        <label for="source">Source:</label>
        <input type="text" id="source" name="source" pattern="[A-Za-z]+" required>

        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination" pattern="[A-Za-z]+" required>

        <label for="type">Type (AC/Non-AC):</label>
        <select id="type" name="type" required>
            <option value="AC">AC</option>
            <option value="Non-AC">Non-AC</option>
        </select>

        <label for="departureDate">Departure Date:</label>
        <input type="date" id="departureDate" name="departureDate" required>

        <label for="arrivalDate">Arrival Date:</label>
        <input type="date" id="arrivalDate" name="arrivalDate" required>

        <label for="totalSeats">Total Seats:</label>
        <input type="number" id="totalSeats" name="totalSeats" required>

        <label for="availableSeats">Available Seats:</label>
        <input type="number" id="availableSeats" name="availableSeats" required>

        <label for="fare">Fare:</label>
        <input type="number" id="fare" name="fare" required>

        <input type="submit" value="Submit">
    </form>
</body>
</html>