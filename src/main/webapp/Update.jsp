<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Customer</title>
    <style>
        /* Style for the form container */
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* Style for the form fields and labels */
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        /* Style for the "Update" button */
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 10px;
        }

        /* Style for the "Delete" button */
        .delete-button {
            background-color: #ff0000;
        }
    </style>
</head>
<body>
    <h1>Update Customer</h1>
    <form action="InsertCustomerServlet" method="post">
    
    	<input type="hidden" name="command" value="UPDATE"/>
	        <input type="hidden" name="customerId" value="${CUSTOMER.customerId}">    	
	        First Name: <input type="text" name="firstName" value="${CUSTOMER.firstname}"><br>
	        Last Name: <input type="text" name="lastName" value="${CUSTOMER.lastname}"><br>
	        Address: <input type="text" name="address" value="${CUSTOMER.address}"><br>
	        NIC Number: <input type="text" name="nicNumber" value="${CUSTOMER.NIC}"><br>
	        Message: <input type="text" name="message" value="${CUSTOMER.message}"><br>
        <input type="submit" value="Update">
        
    </form>
</body>
</html>
