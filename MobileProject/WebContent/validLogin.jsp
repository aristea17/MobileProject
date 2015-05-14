<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="hibernate.ProductManager" import="hibernate.Products" import="java.util.List"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="CSS/validLogin.css" rel="stylesheet" type="text/css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<body>
<%
String user = (String)session.getAttribute("user");
%>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
					<a class="navbar-brand" href="validLogin.jsp?pagina=home">Project Name</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				<li><a href="validLogin.jsp?pagina=home">Make an order</a></li>
				<li><a href="#about">Bills</a></li>
				<li><a href="productStock.jsp?pagina=products">Product Stock</a></li>
				<li><a href="supplierList.jsp?pagina=suppliers">Suppliers</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li> 
						<img src="./Images/setting-icon.png" alt="Settings" height="45" width="45"/></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" area-expanded="false">Welcome <b><%=user%></b><span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="login.jsp">Log out</a></li>
							</ul>
						</li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container2">
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="true">
			Select Category
			<span class="caret"></span>
			</button>
             <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li class="divider"></li>
                <li><a href="#">Another action</a></li>
                <li class="divider"></li>
                <li><a href="#">Something else here</a></li>
              </ul>
		</div>	
	</div>	
	<div class="container3">
		<div class="table">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Batch Amount</th>
					<th>Minimum</th>
					<th>Stored</th>
				</tr>
			</thead>
		<tbody>
	<%
	List<Products> list = ProductManager.getProductsListByCategory(user);
	for(Products p : list){
	%>
	<tr>
	<td><%=p.getID()%></td>
	<td><%=p.getName() %></td>
	<td><%=p.getBatchAmount() %></td>
	<td><%=p.getMinimum() %></td>
	<td><%=p.getStored() %></td>
</tr>
<% } %>
</tbody>
</table>
</div>
</div>
</body>
</html>