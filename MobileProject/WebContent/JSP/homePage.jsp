<%@page import="service.ProductManager" import="model.Products" import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- CUSTOM CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/homePage.css">
<title>Home</title>
<%@include file="header.jsp" %>
</head>
<body>
<p><b>Department:</b></p>
<p id="dep"><%=user %></p>
<br/>
<br/>
<b>Select category:</b>
<select id="category">
<option>Select category</option>
</select>
<br/>
<br/>
<br/>
<!-- CUSTOM JAVASCRIPT -->
<script src="${pageContext.request.contextPath}/JS/homePage.js" type="text/javascript"></script>
<input class="btn btn-md btn-default" type="button" value="Show Products" id="showTable"/>
<br/>
<br/>
<div id="tablediv">
<table class="table table-bordered table-striped" cellspacing="0" id="table">
    <tr>
        <th class="col-md-1" scope="col">ID</th>
        <th class="col-md-2" scope="col">Name</th>
        <th class="col-md-1" scope="col">Minimum</th>
        <th class="col-md-1" scope="col">Stored</th>
        <th class="col-md-2" scope="col">Supplier</th>
        <th class="col-md-1" scope="col">Price</th> 
        <th class="col-md-1" scope="col">Batch Amount</th> 
        <th class="col-md-2" scope="col">Email</th>
        <th class="col-md-2" scope="col">Order Amount</th>     
    </tr>
</table>
<input class="btn btn-md btn-default" type="button" value="Add to cart" id="cart" onclick="addToCart()"/>
</div>
</body>
</html>