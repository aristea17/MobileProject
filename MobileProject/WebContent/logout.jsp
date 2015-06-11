<%@page import="javaClasses.ShoppingCart" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%
/* If exists, get the session and invalidates it */
session = request.getSession(false);
if(session!=null){
	session.removeAttribute("user");
	session.invalidate();
}
ShoppingCart.clear(); /* clears the shopping cart */

/* Redirect to Login Page*/
response.sendRedirect("login.jsp");
%>
</body>
</html>