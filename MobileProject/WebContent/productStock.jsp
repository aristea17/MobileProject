<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="hibernate.ProductManager" import="hibernate.Products" import="java.util.List" %>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSS/reset.css" rel="stylesheet" type="text/css">
<link href="CSS/supplierList.css" rel="stylesheet" type="text/css">
<title>Suppliers</title>
</head>
<body>
<script type="text/javascript">

// Function to to update an "add" productStock in the DB
function updateAdd(number, store, pid){	
	var productCount = document.getElementById(number).value;
	// Check empty box - else do nothing
	if(productCount!=""){
		// Compute sum and update in html table
		var stored = document.getElementById(store).innerHTML;
		var sum = parseInt(productCount) + parseInt(stored);
		document.getElementById(store).innerHTML=sum;
		
		// We get Id of the element to access element in the DB
		var intId = document.getElementById(pid).innerHTML;
		
		$.ajax({
			url: 'ProductStockServlet',
			data: {
				id : intId,
				update : sum
			},
			// Debugging alert
			/* success: function(responseText){
				alert(responseText);	
			} */
		})
		
		// Delete value from input-box
		$('#' + number).val("");
	}
}

//Function to to update an "reduce" productStock in the DB
function updateDecrement(number, store, pid){
	var productCount = document.getElementById(number).value;
	// Check empty box - else do nothing
	if(productCount!=""){
		// Compute sum and update in html table (if less than 0 stock is set to 0 by default)
		var stored = document.getElementById(store).innerHTML;
		var sum = parseInt(stored) - parseInt(productCount);
		if(sum<0){sum = 0}
		document.getElementById(store).innerHTML=sum;
		
		// We get Id of the element to access element in the DB
		var intId = document.getElementById(pid).innerHTML;
		
		$.ajax({
			url: 'ProductStockServlet',
			data: {
				id : intId,
				update : sum
			},
			// Debugging alert
			/* success: function(responseText){
				alert(responseText);	
			} */
			})
			
		// Delete value from input-box
		$('#' + number).val("");
	}
}

// Change color of stored-field in table if it is less than min-field
function checkStored(store, min){
	var s = parseInt(document.getElementById(store).innerHTML);
	var m = parseInt(document.getElementById(min).innerHTML);
	if(s<m){$('#' + store).css('color', 'red');}
	// We update to black in anycase, because we don't know if it was set to "red" before
	else{$('#' + store).css('color', 'black');}
}
</script>

	<div class="container2">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th align="center">Minimum</th>
					<th align="center">Stored</th>
					<th>Add/reduce</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
		<tbody>
<%
// For each product received from DB query we create a table row
List<Products> list = ProductManager.getProductsListByUser(user);
// Index is used to create and use ids on needed cells
int index=0;
for(Products p : list){
%>
<tr>
	<td id="pid<%=index%>"><%=p.getID() %></td>
	<td><%=p.getName()%></td>
	<td align="center" "min<%=index %>"><%=p.getMinimum() %></td>
	<td align="center" id="store<%=index %>"><%=p.getStored() %></td>
	<script>checkStored('store<%=index %>', 'min<%=index %>')</script>
	<td>
	<div class="col-xs-3">
	<input type="text" id="number<%=index %>" class="form-control input-sm" onkeypress='return event.charCode >=48 && event.charCode <=57'></input>
	</div>
	</td>
	<td>
	<button class="btn btn-default" type="button" id="increment<%=index %>>" value="increment" onclick="updateAdd('number<%=index %>','store<%=index %>','pid<%=index%>'); checkStored('store<%=index %>', 'min<%=index %>');">Add</button>
	</td>
	<td>
	<button class="btn btn-default" type="button" id="decrement<%=index %>" value="decrement" onclick="updateDecrement('number<%=index %>', 'store<%=index %>', 'pid<%=index%>'); checkStored('store<%=index %>', 'min<%=index %>');">Reduce</button>
	</td>
</tr>
<%index++;
} %>
</tbody>
</table>
</div>
</body>	
</html>