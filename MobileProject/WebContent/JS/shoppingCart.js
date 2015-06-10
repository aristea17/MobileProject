/* Remove the BuyProduct from the shopping Cart when remove button is clicked */
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
	
/* Reduce the quantity of the BuyPorduct object given */
function reduce(supplier, product, quantity){
	var q = document.getElementById(quantity).value;
	/* Check empty box - else do nothing */
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
	
/* Send the email with the order in pdf */
function send(){
	var SEND_ID = 2;
	$.ajax({
		url: 'ShoppingCartServlet',
		data : {
			ID : SEND_ID
		},
		//async: false,		// <--- Uncomment this line in order to make sure no action can happen until email are sent
							//		Cons: It seems the application is blocked because waiting for the "success" to return
		// Debugging alert
		success: alert('Email are being sent...'),
	})
	window.setTimeout(function(){window.location.reload()}, 800);
}
	