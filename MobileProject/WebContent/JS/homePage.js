/* Used to get number of max element each time we update the shown table, in order to generate ids accordingly */
var count;

/* On load we populate drop-down with categories based on user/department */
$(document).ready(function(){
	var $department = getDep();
	$.get('/MobileProject/GetCategoryServlet', {departmentname:$department}, function(responseJson){
		var $select = $('#category');
		$select.find('option').remove();
		$.each(responseJson, function(key, value){
			$('<option>').val(key).text(value).appendTo($select); /*populate the category list */
		});
	});
	$("#tablediv").hide();
	$("#showTable").click(function(event){
		var $category = $("select#category option:selected").text();
		$.get('/MobileProject/GetProductsByCategoryServlet', {categoryname:$category, departmentname:$department}, function(responseJson){
			if(responseJson!=null){
				$("#table").find("tr:gt(0)").remove();
				var table1= $("#table");
				$.each(responseJson, function(key, value){
					var rowNew = $("<tr><td></td><td id=\"name"+key+"\"></td><td ></td><td></td><td id=\"supplier"+key+"\"></td><td id=\"price"+key+"\"></td><td></td><td id=\"email"+key+"\"></td></tr>");
					rowNew.children().eq(0).text(value['p_id']);
					rowNew.children().eq(1).text(value['p_name']);
					rowNew.children().eq(2).text(value['p_minimum']);
					rowNew.children().eq(3).text(value['p_stored']);
					rowNew.children().eq(4).text(value['s_name']);
					rowNew.children().eq(5).text(value['price']); 
					rowNew.children().eq(6).text(value['p_batch_amount']);
					rowNew.children().eq(7).text(value['s_email']);
					rowNew.append('<td><div class="col-sm-12"><input id="quantity'+key+'" type="text" class="form-control input-sm" onkeypress="return event.charCode >=48 && event.charCode <=57"></div></td>');
					rowNew.appendTo(table1);
					count = key;
				});
			}
		});
		$("#tablediv").show();
	});		
});

/* Add the selected BuyProduct object to the Shopping Cart */
function addToCart(){
	var p_name;
	var s_name;
	var s_email;
	var p_price;
	var quantityInput;
	
	/* Check all rows of the table */
	for(var i=0; i<=count; i++){
				
		quantityInput = document.getElementById('quantity'+i).value;  /* here I get the quantity I insert in the input field */
		
		/* If an input was added, we add that product to shopping cart */
		if(quantityInput!=""){
			var ADD_ID = 1;
			p_name = document.getElementById('name'+i).innerHTML;
			s_name = document.getElementById('supplier'+i).innerHTML;
			s_email = document.getElementById('email'+i).innerHTML;
			p_price = document.getElementById('price'+i).innerHTML;

			$.ajax({
				url: '/MobileProject/ShoppingCartServlet',
				data: {
					pName : p_name,
					sName : s_name,
					sEmail : s_email,
					pPrice : p_price,
					quantity : quantityInput,
					ID : ADD_ID
				},
				async: false,
			})
			
			/* delete value from box */
			$('#' + 'quantity'+i).val("");
		}		
	}
	/* Alert user of successful add */
	alert('Products added to cart!');
}

/* Gets the department name */
function getDep(){
	var dp = document.getElementById('dep').innerHTML;
	return dp;
}