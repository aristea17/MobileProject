<%@page import="service.ProductManager" import="model.Products" import="java.util.List" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- BOOTSTRAP CSS -->
<link href="${pageContext.request.contextPath}/Bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<!-- CUSTOM CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/homePage.css">
<link href="${pageContext.request.contextPath}/CSS/supplierList.css" rel="stylesheet">
<!-- CUSTOM JAVASCRIPT -->
<script src="${pageContext.request.contextPath}/JS/productStock.js" type="text/javascript"></script>
<title>Suppliers</title>
</head> 
<body>
	<div class="container2">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th class="col-md-1">ID</th>
					<th class="col-md-2">Name</th>
					<th class="col-md-1">Minimum</th>
					<th class="col-md-1">Stored</th>
					<th class="col-md-1">Add/reduce</th>
					<th class="col-md-1"></th>
					<th class="col-md-1"></th>
				</tr>
			</thead>
		<tbody>
		<%
		/* For each product received from DB query we create a table row */
		List<Products> list = ProductManager.getProductsListByUser(user);
		/* Index is used to create and use ids on needed cells */
		int index=0;
		for(Products p : list){
		%>
			<tr>
				<td id="pid<%=index%>"><%=p.getID() %></td>
				<td><%=p.getName()%></td>
				<td id="min<%=index %>"><%=p.getMinimum() %></td>
				<td id="store<%=index %>"><%=p.getStored() %></td>
				<script>checkStored('store<%=index %>', 'min<%=index %>')</script>
				<td>
				<div class="col-sm-8">
				<input type="text" id="number<%=index %>" class="form-control input-sm" onkeypress='return event.charCode >=48 && event.charCode <=57'></input>
				</div>
				</td>
				<td>
				<button class="btn btn-default" type="button" id="increment<%=index %>>" value="increment" onclick="updateAdd('number<%=index %>','store<%=index %>','pid<%=index%>'); checkStored('store<%=index %>', 'min<%=index %>');">Add</button>
				</td>
				<td>
				<button class="btn btn-default" type="button" id="decrement<%=index %>" value="decrement" onclick="updateReduce('number<%=index %>', 'store<%=index %>', 'pid<%=index%>'); checkStored('store<%=index %>', 'min<%=index %>');">Reduce</button>
				</td>
			</tr>
		<%
			index++;
		}
		%>
</tbody>
</table>
</div>
</body>	
</html>