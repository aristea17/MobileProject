<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="hibernate.ProductManager" import="hibernate.Products" import="java.util.List"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSS/reset.css" rel="stylesheet" type="text/css">
<link href="CSS/validLogin.css" rel="stylesheet" type="text/css"/>
<title>Home</title>
<%@include file="header.jsp" %>
<script type="text/javascript">
	var count;
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
							//var count;
							$.each(responseJson, function(key, value){
								var rowNew = $("<tr><td></td><td id=\"name"+key+"\"></td><td ></td><td></td><td id=\"supplier"+key+"\"></td><td id=\"price"+key+"\"></td><td></td><td id=\"email"+key+"\"></td></tr>");
								rowNew.children().eq(0).text(value['p_id']);
								rowNew.children().eq(1).text(value['p_name']);
								rowNew.children().eq(2).text(value['p_minimum']);
								rowNew.children().eq(3).text(value['p_stored']);
								rowNew.children().eq(4).text(value['s_name']); //supplier
								rowNew.children().eq(5).text(value['price']); //price
								rowNew.children().eq(6).text(value['p_batch_amount']);
								rowNew.children().eq(7).text(value['s_email']);
								rowNew.append('<td><div class="col-xs-3"><input id="quantity'+key+'" type="text" class="form-control input-sm" onkeypress="return event.charCode >=48 && event.charCode <=57"></div></td>');
								rowNew.appendTo(table1);
								count = key;
							});
						}
				});
				$("#tablediv").show();
			});		
});	
	function addToCart(){
		var p_name;
		var s_name;
		var s_email;
		var p_price;
		var quantityInput;
		
		for(var i=0; i<=count; i++){
					
			quantityInput = document.getElementById('quantity'+i).value;  // here I get the quantity I insert in the input field
			
			if(quantityInput!=""){
				var ADD_ID = 1;
				p_name = document.getElementById('name'+i).innerHTML;
				s_name = document.getElementById('supplier'+i).innerHTML;
				s_email = document.getElementById('email'+i).innerHTML;
				p_price = document.getElementById('price'+i).innerHTML;

				$.ajax({
					url: 'ShoppingCartServlet',
					data: {
						pName : p_name,
						sName : s_name,
						sEmail : s_email,
						pPrice : p_price,
						quantity : quantityInput,
						ID : ADD_ID
					},
					async: false,
					// Debugging alert
					/*success: function(responseText){
						alert(responseText);
					}*/
				})
				
				// delete value from box
				$('#' + 'quantity'+i).val("");
			}		
		}
		alert('Products added to cart!');
	}
	
	
			
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
<br/>
Select category:
<select id="category">
<option>Select category</option>
</select>
<br/>
<br/>
<br/>
<input class="btn btn-md btn-default" type="button" value="Show Products" id="showTable"/>
<br/>
<br/>
<div id="tablediv">
<table class="table table-bordered table-striped" cellspacing="0" id="table">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Minimum</th>
        <th scope="col">Stored</th>
        <th scope="col">Supplier</th>
        <th scope="col">Price</th> 
        <th scope="col">Batch Amount</th> 
        <th scope="col">Email</th>
        <th scope="col">Order Amount</th>     
    </tr>
</table>
<input class="btn btn-md btn-default" type="button" value="Add to cart" id="cart" onclick="addToCart()"/>
</div>
</body>
</html>