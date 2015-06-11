<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- BOOTSTRAP CSS -->
<link href="${pageContext.request.contextPath}/Bootstrap/css/bootstrap.min.css" rel="stylesheet" "/>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- BOOTSTRAP JAVASCRIPT -->
<script src="${pageContext.request.contextPath}/Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<!-- CUSTOM CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/homePage.css">
<title>Home Page</title>
</head>
<body>
<%
String user = (String)session.getAttribute("user");
%>
<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
					<a class="navbar-brand" href="information.jsp?pagina=info">IMS Project</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				<li><a href="homePage.jsp?pagina=home">Make an order</a></li>
				<li><a href="shoppingCart.jsp?pagina=shoppingCart">Shopping Cart</a></li>
				<li><a href="productStock.jsp?pagina=products">Product Stock</a></li>
				<li><a href="supplierList.jsp?pagina=suppliers">Suppliers</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li> 
						<img src="${pageContext.request.contextPath}/Images/setting-icon.png" alt="Settings" height="45" width="45"/></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" area-expanded="false">Welcome <b><%=user%></b><span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="logout.jsp">Log out</a></li>
							</ul>
						</li>
				</ul>
			</div>
		</div>
	</nav>