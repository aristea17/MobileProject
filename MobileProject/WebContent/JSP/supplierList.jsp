<%@page import="service.SuppliersManager" import="model.Suppliers" import="java.util.List" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
 <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- CUSTOM CSS -->
<link  rel="stylesheet" href="${pageContext.request.contextPath}/CSS/reset.css">
<link  rel="stylesheet" href="${pageContext.request.contextPath}/CSS/supplierList.css">
<title>Suppliers</title>
</head> 
<body>
	<div class="container2">
		<div class="prova">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th class="col-md-1">ID</th>
					<th class="col-md-2">Company</th>
					<th class="col-md-2">E-mail</th>
					<th class="col-md-2">Representative name</th>
					<th class="col-md-2">Address</th>
					<th class="col-md-2">Telephone</th>
				</tr>
			</thead>
		<tbody>
<%
List<Suppliers> list = SuppliersManager.getSuppliersList(user);
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