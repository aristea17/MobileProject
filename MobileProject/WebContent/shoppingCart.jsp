<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="code.Order" import="code.ShoppingCart" import="code.BuyProduct" import="java.util.List"%>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSS/reset.css" rel="stylesheet" type="text/css">
<title>Shopping Cart</title>
</head>
<body>
	<script type="text/javascript">
	
	function remove(supplier, product){
		var p = document.getElementById(product).innerHTML;
		$.ajax({
			url: 'ShoppingCartServlet',
			data: {
				sName : supplier,
				pName : p
			},
			// Debugging alert
			/*success: function(responseText){
				alert(p);	
			} */
		})
		location.reload();
	}
	
	function reduce(){
		
	}
	
	</script>
	
	<div class="tableContainer">
		<%
			List<Order> listOfOrders = ShoppingCart.getOrderList();
			int iOrder = 0;
			for(Order order : listOfOrders){
			String supplier = order.getSupplier();
			double total = order.getTotal();
		%>
		<p>Supplier: <%=supplier + " - Total: " + total %></p>
		<table id="table<%=iOrder%>" class="table table-striped">
			<thead>
				<tr>
					<th>Remove</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>ReduceField</th>
					<th>ReduceButton</th>
				</tr>
			</thead>
			<tbody>
			<%
				// For each product received from DB query we create a table row
				List<BuyProduct> listOfProducts = order.getProductList();
				// Index is used to create and use ids on needed cells
				int iBP=0;
				for(BuyProduct product : listOfProducts){
			%>
			<tr>
				<td>
				<button class="btn btn-default" type="button" id="remove<%=iBP %>>" value="remove" onclick="remove('<%=supplier %>','name<%=iBP %>');">Remove</button>
				</td>
				<td id="name<%=iBP%>"><%=product.getName() %></td>
				<td><%=product.getPrice() %></td>
				<td id="quantity<%=iBP%>"><%=product.getQuantity() %></td>
				<td>
				<input type="text"  id="field<%=iBP%>" class="form-control" onkeypress='return event.charCode >=48 && event.charCode <=57'></input>
				</td>
				<td>
				<button class="btn btn-default" type="button" id="reduce<%=iBP %>>" value="reduce" onclick="reduce();">Reduce</button>
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
	</div>
</body>
</html>