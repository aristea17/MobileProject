<%@page import="javaClasses.Order" import="javaClasses.ShoppingCart" import="javaClasses.BuyProduct" import="java.util.List" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSS/reset.css" rel="stylesheet" type="text/css">
<link href="CSS/shoppingCart.css" rel="stylesheet" type="text/css">
<title>Shopping Cart</title>
</head>
<body> 
<script src="JS/shoppingCart.js" type="text/javascript"></script>
	<% 
	/* If ShoppingCart is empty nothing is displayed, else we get a visualization of what is inside the cart */
	if(!ShoppingCart.isEmpty()){%>
	<div class="tableContainer">
		<%
			/* Creates a different table for each suppliers and fills it with its products */
			/* Index is used to create and use ids on needed cells */
			List<Order> listOfOrders = ShoppingCart.getOrderList();
			int iOrder = 0;
			int iBP=0;
			for(Order order : listOfOrders){
			String supplier = order.getSupplier();
			String total = order.getTotal();
		%>
		<br/>
		<br/>
		<p><b>Supplier: </b><%=supplier%></p>
		<br/>
		<p><b>Total: </b><%=total %></p>
		<br/>
		<br/>
		<table id="table<%=iOrder%>" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th class="col-md-1"></th>
					<th class="col-md-2">Name</th>
					<th class="col-md-2">Price</th>
					<th class="col-md-1">Quantity</th>
					<th class="col-md-1"></th>
					<th class="col-md-1"></th>
				</tr>
			</thead>
			<tbody>
			<%
				/* For each product received from DB query we create a table row */
				List<BuyProduct> listOfProducts = order.getProductList();
				for(BuyProduct product : listOfProducts){
			%>
			<tr>
				<td>
				<button class="btn btn-default" type="button" id="remove<%=iBP %>>" value="remove" onclick="remove('<%=supplier %>','name<%=iBP %>');">Remove</button>
				</td>
				<td id="name<%=iBP%>"><%=product.getName() %></td>
				<td><%=product.getPrice() %></td>
				<td><%=product.getQuantity() %></td>
				<td>
				<div class="col-sm-8">
				<input type="text" id="field<%=iBP%>" class="form-control input-sm" onkeypress='return event.charCode >=48 && event.charCode <=57'></input>
				</div>
				</td>
				<td>
				<button class="btn btn-default" type="button" id="reduce<%=iBP %>>" value="reduce" onclick="reduce('<%=supplier %>','name<%=iBP %>','field<%=iBP%>');">Reduce</button>
				</td>
			</tr>
			<%
			iBP++;
			}
			%>
			</tbody>
		</table>		
		<%
		iOrder++;
		}
		%>
		<input class="btn btn-md btn-default" type="button" value="Send email order" id="send" onclick="send()">
	</div>
	<% }
		else{%>
		<p><b>Shopping Cart is empty!</b></p>
	<% } %>
</body>
</html>