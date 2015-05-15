<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="hibernate.ProductManager" import="hibernate.Products" import="java.util.List"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> -->
<link href="CSS/validLogin.css" rel="stylesheet" type="text/css"/>
<title>Home</title>
</head>
<body>
<%@include file="header.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#tablediv").hide();
			$("#showTable").click(function(event){
				$.get('GetProductsByCategoryServlet', function(responseJson){
					if(responseJson!=null){
						$("#table").find("tr:gt(0)").remove();
						var table1= $("#table");
						$.each(responseJson, function(key, value){
							var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
							rowNew.children().eq(0).text(value['p_id']);
							rowNew.children().eq(1).text(value['p_name']);
							rowNew.children().eq(2).text(value['minimum']);
							rowNew.children().eq(3).text(value['stored']);
							rowNew.children().eq(4).text(value['category']);
							rowNew.children().eq(5).text(value['batch_amount']);
							rowNew.appendTo(table1).append('<td><div class="col-xs-3"><input type="text" class="form-control input-sm" onkeypress="return event.charCode >=48 && event.charCode <=57"></div></td>').append('<td><input type="checkbox" /></td>');
						});
					}
				});
				$("#tablediv").show();
			});
	});
</script>
<input type="button" value="Show Table" id="showTable"/>
<div id="tablediv">
<table class="table table-striped" cellspacing="0" id="table">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Minimum</th>
        <th scope="col">Stored</th>
        <th scope="col">Category</th> 
        <th scope="col">BatchAmount</th> 
        <th scope="col">Order Amount</th>    
        <th scope="col">Add to basket</th> 
        
    </tr>
</table>
</div>
</body>
</html>