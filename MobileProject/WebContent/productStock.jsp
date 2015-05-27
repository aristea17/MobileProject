<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="hibernate.ProductManager" import="hibernate.Products" import="java.util.List" %>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> -->
<link href="CSS/supplierList.css" rel="stylesheet" type="text/css">
<title>Suppliers</title>
</head>
<body>
<script type="text/javascript">
// $(document).ready(function(){
//  	$('#increment').click(function(event){
//  		var n = $('#number').val();//gets the input
//  		$.get('ProductStockServlet', {add:n}, function(responseText){
//  			$("#store").each(function(){
// 				var a = $(this).html();
// 				jQuery(this).html(responseText);
// 			})
// 		});
//  	});
//  });
function ajaxFunction(){
	var ajaxRequest;
	try{
		ajaxRequest = new XMLHttpRequest();
	}
	catch(e){
		try{
			ajaxRequest = new ActiveXObject("Msxml12.XMLHTTP");
		}catch(oc){
			alert("Your browser broke");
			return false;
		}
	}
}
function updateAdd(number, store, pid){
	//function updateAdd(number, store, pid){
	// check empty box	
	var productCount = document.getElementById(number).value;
	if(productCount!=""){
		var stored = document.getElementById(store).innerHTML;
		var sum = parseInt(productCount) + parseInt(stored);
		document.getElementById(store).innerHTML=sum;
		// delete value from box
		var intId = document.getElementById(pid).innerHTML;
		alert(intId);
		alert(sum);
		$('#' + number).val("");
		//ProductManager.updateProductById(parseInt(intId), parseInt(sum));
		
	}
}

function updateDecrement(number, store){
	var productCount = document.getElementById(number).value;
	if(productCount!=""){
		var stored = document.getElementById(store).innerHTML;
		var sum = parseInt(stored) - parseInt(productCount);
		if(sum<0){sum = 0}
		document.getElementById(store).innerHTML=sum;
	}
}
</script>
	<div class="container2">
		<div class="prova">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Minimum</th>
					<th>Stored</th>
					<th>Add/reduce</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
		<tbody>
<%
List<Products> list = ProductManager.getProductsListByUser(user);
int index=0;
for(Products p : list){
%>
<tr>
	<td id="pid<%=index%>"><%=p.getID() %></td>
	<td><%=p.getName()%></td>
	<td><%=p.getMinimum() %></td>
	<td id="store<%=index %>"><%=p.getStored() %></td>
	<td>
	<div class="col-xs-6">
	<input type="text" id="number<%=index %>" class="form-control" aria-describedby="sizing-addon3" onkeypress='return event.charCode >=48 && event.charCode <=57'></input>
	</div>
	</td>
	<td>
	<button class="btn btn-default" type="button" id="increment<%=index %>>" value="increment" onclick="updateAdd('number<%=index %>','store<%=index %>','pid<%=index%>');">Add</button>
	</td>
	<td>
	<button class="btn btn-default" type="button" id="decrement<%=index %>" value="decrement" onclick="updateDecrement('number<%=index %>', 'store<%=index %>', 'pid<%=index%>')">Reduce</button>
	</td>
</tr>
<%index++;
} %>
</tbody>
</table>
</div>
</div>
</body>	
</html>