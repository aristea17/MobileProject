<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="hibernate.SuppliersManager" import="hibernate.Suppliers" import="java.util.List" %>
 <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> -->
<link href="CSS/supplierList.css" rel="stylesheet" type="text/css">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<!-- <script type="text/javascript" src="Bootstrap/js/bootstrap.min.js"></script> -->
<title>Suppliers</title>
</head>
<body>
	<div class="container2">
		<div class="prova">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Company</th>
					<th>E-mail</th>
					<th>Representative name</th>
					<th>Address</th>
					<th>Telephone</th>
				</tr>
			</thead>
		<tbody>
<%
SuppliersManager sp = new SuppliersManager();
List<Suppliers> list = sp.getSuppliersList(user);
for(Suppliers s : list){
%>
<tr>
	<td><%=s.getID()%></td>
	<td><%=s.getCompany() %></td>
	<td><%=s.getEmail()%></td>
	<td><%=s.getRepresentative()%></td>
	<td><%=s.getAddress()%></td>
	<td><%=s.getTelephone()%></td>
</tr>
<%} %>
</tbody>
</table>
</div>
</div>
</body>	
</html>