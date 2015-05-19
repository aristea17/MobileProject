<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="hibernate.ProductManager" import="hibernate.Products" import="java.util.List"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> -->
<link href="CSS/validLogin.css" rel="stylesheet" type="text/css"/>
<title>Home</title>
<%@include file="header.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		$('#department').change(function(event){//the select option is triggered
			var $department = $("select#department").val();//save in department the selected value
			$.get('GetCategoryServlet', {departmentname:$department}, function(responseJson){//call the servlet passing as a parameter the selected department
				var $select = $('#category');
				$select.find('option').remove();
				$.each(responseJson, function(key, value){
					$('<option>').val(key).text(value).appendTo($select);//populate the category list
				});
			});
		});
		$("#tablediv").hide();
			$("#showTable").click(function(event){//when the 'Show Table' is clicked...
				var $category = $("select#category option:selected").text();//save the selected category value
				//var $cat = $(category).find(":selected");
				$.get('GetProductsByCategoryServlet', {categoryname:$category}, function(responseJson){
						if(responseJson!=null){
							$("#table").find("tr:gt(0)").remove();
							var table1= $("#table");
							$.each(responseJson, function(key, value){
								var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
								rowNew.children().eq(key).eq(0).text(value['[{p_id}]']);
								rowNew.children().eq(key).eq(0).text(value['{p_name}']);
								rowNew.children().eq(0).text(value['[{minimum}]']);
								rowNew.children().eq(0).text(value['stored']);
								rowNew.children().eq(0).text(value['']);//supplier
								rowNew.children().eq(1).text(value['"price"']);//price
								rowNew.children().eq(0).text(value['"batch_amount"']);
								rowNew.appendTo(table1).append('<td><div class="col-xs-3"><input type="text" class="form-control input-sm" onkeypress="return event.charCode >=48 && event.charCode <=57"></div></td>').append('<td><input id="cb" type="checkbox" /></td>');
						});
					}
				});
				$("#tablediv").show();
			});		
});
			$('#cb').click(function(){
				$('#table tr').filter(':has(:checkbox:checked)').find('<td>').each(function(){
					alert("Product added! Prova");
				});
			});
</script>
</head>
<body>
Select department:
<select id="department">
<option>Select department</option>
<option><%=user %></option>
</select>
<br/>
<br/>
Select category:
<select id="category">
<option>Select category</option>
</select>
<br/>
<br/>
<input type="button" value="Show Products" id="showTable"/>
<br/>
<br/>
<div id="tablediv">
<table class="table table-striped" cellspacing="0" id="table">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Minimum</th>
        <th scope="col">Stored</th>
        <th scope="col">Supplier</th>
        <th scope="col">Price</th> 
        <th scope="col">Batch Amount</th> 
        <th scope="col">Order Amount</th>    
        <th scope="col">Add to basket</th> 
    </tr>
</table>
</div>
</body>
</html>