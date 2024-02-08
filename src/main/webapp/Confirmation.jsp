<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation Page</title>
</head>
<body>
    <h1>Customer Details</h1>
    <p>Thank you for submitting your details:</p>

    <ul>
    	<c:forEach var="cus_details" items="${THE_CUSTOMER}">
    	
	    	<c:url var="tempLink" value="InsertCustomerServlet">
	    		<c:param name="command" value="LOAD"></c:param>
	    		<c:param name="customerId" value="${cus_details.customerId}"></c:param>
	    	</c:url>

	    	<c:url var="deleteLink" value="InsertCustomerServlet">
	    		<c:param name="command" value="DELETE"></c:param>
	    		<c:param name="customerId" value="${cus_details.customerId}"></c:param>
	    	</c:url>
    	
	        <li><strong>First Name:</strong> ${cus_details.firstname}</li>
	        <li><strong>Last Name:</strong> ${cus_details.lastname}</li>
	        <li><strong>Address:</strong> ${cus_details.address}</li>
	        <li><strong>NIC Number:</strong> ${cus_details.NIC}</li>
	        <li><strong>Message:</strong> ${cus_details.message}</li>
	        <li><strong>Update Details:</strong><button><a href="${tempLink}">Update Details</a></button></li>
	        <li><strong>Delete Details:</strong><button><a href="${deleteLink}">Delete Details</a></button></li>
	        
	    </c:forEach>	    
    </ul>
</body>
</html>