<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="code.Order" import="code.ShoppingCart" import="code.BuyProduct" import="java.util.List"%>
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
	<script type="text/javascript">
	
	function remove(supplier, product){
		var REMOVE_ID = 3;
		var p = document.getElementById(product).innerHTML;
		$.ajax({
			url: 'ShoppingCartServlet',
			data: {
				sName : supplier,
				pName : p,
				ID : REMOVE_ID
			},
			// Debugging alert
			/*success: function(responseText){
				alert(p);	
			}*/
		})
		location.reload();
	}
	
	function reduce(supplier, product, quantity){
		var q = document.getElementById(quantity).value;
		// Check empty box - else do nothing
		if(q!=""){
			q = parseInt(q);
			var UPDATE_ID = 4;
			var p = document.getElementById(product).innerHTML;
			$.ajax({
				url: 'ShoppingCartServlet',
				data: {
					sName : supplier,
					pName : p,
					iQuantity : q,
					ID : UPDATE_ID
				},
				// Debugging alert
				// success: alert(p)
			})
			location.reload();
		}
	}
	
	function send(){
		var SEND_ID = 2;
		$.ajax({
			url: 'ShoppingCartServlet',
			data : {
				ID : SEND_ID
			},
			//async: false,
			// Debugging alert
			/*success: function(responseText){
				alert(responseText);
			}*/
		})
		//location.reload();
	}
	
	</script>
	
	<div class="tableContainer">
		<%
			List<Order> listOfOrders = ShoppingCart.getOrderList();
			int iOrder = 0;
			int iBP=0;
			for(Order order : listOfOrders){
			String supplier = order.getSupplier();
			String total = order.getTotal();
		%>
		<br/>
		<br/>
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
				<input type="text" id="field<%=iBP%>" class="form-control" onkeypress='return event.charCode >=48 && event.charCode <=57'></input>
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
</body>
</html>