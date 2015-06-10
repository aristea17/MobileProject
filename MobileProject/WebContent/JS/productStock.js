/* Function to increment productStock in the DB */
function updateAdd(number, store, pid){	
	var productCount = document.getElementById(number).value;
	 
	/* Check empty box - else do nothing */
	if(productCount!=""){
		
		/* Compute sum and update the HTML table */
		var stored = document.getElementById(store).innerHTML;
		var sum = parseInt(productCount) + parseInt(stored);
		document.getElementById(store).innerHTML=sum;
		
		/* get Id of the element to access element in the DB */
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
		
		/* Delete value from input-box */
		$('#' + number).val("");
	}
}

/*Function to update and reduce productStock in the DB */
function updateReduce(number, store, pid){
	var productCount = document.getElementById(number).value;
	
	/* Check empty box - else do nothing */
	if(productCount!=""){
		
		/* Compute sum and update in HTML table (if less than 0 stock is set to 0 by default) */
		var stored = document.getElementById(store).innerHTML;
		var sum = parseInt(stored) - parseInt(productCount);
		if(sum<0){sum = 0}
		document.getElementById(store).innerHTML=sum;
		
		/* We get Id of the element to access element in the DB */
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
			
		/* Delete value from input-box */
		$('#' + number).val("");
	}
}

/* Change color of stored-field in table if it is less than min-field */
function checkStored(store, min){
	var s = parseInt(document.getElementById(store).innerHTML);
	var m = parseInt(document.getElementById(min).innerHTML);
	if(s<m){
		$('#' + store).css('color', 'red');
	}
	/* We update to black in any case, because we don't know if it was set to "red" before */
	else{
		$('#' + store).css('color', 'black');
	}
}