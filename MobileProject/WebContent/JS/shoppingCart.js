/* Remove the BuyProduct from the shopping Cart when remove button is clicked */
function removeProduct(supplier, product){
		var REMOVE_ID = 3;
		var p = document.getElementById(product).innerHTML;
		$.ajax({
			url: '/MobileProject/ShoppingCartServlet',
			data: {
				sName : supplier,
				pName : p,
				ID : REMOVE_ID
			},
		})
		location.reload();
	}
	
/* Reduce the quantity of the BuyPorduct object given */
function reduce(supplier, product, quantity){
	var q = document.getElementById(quantity).value;
	/* Check empty box - else do nothing */
	if(q!=""){
		q = parseInt(q);
		var UPDATE_ID = 4;
		var p = document.getElementById(product).innerHTML;
		$.ajax({
			url: '/MobileProject/ShoppingCartServlet',
			data: {
				sName : supplier,
				pName : p,
				iQuantity : q,
				ID : UPDATE_ID
			},
		})
		location.reload();
	}
}
	
/* Send the email with the order in pdf */
function send(){
	var SEND_ID = 2;
	$.ajax({
		url: '/MobileProject/ShoppingCartServlet',
		data : {
			ID : SEND_ID
		},
		success: alert('Email are being sent...'),
	})
	window.setTimeout(function(){window.location.reload()}, 800);
}
	