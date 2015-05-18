<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function(){
		$('#department').change(function(event){
			var $department = $("select#department").val();
			$.get('GetCategoryServlet', {departmentname:$department}, function(responseJson){
				var $select = $('#category');
				$select.find('option').remove();
				$.each(responseJson, function(key, value){
					$('<option>').val(key).text(value).appendTo($select);
				});
			});
		});
	});
</script>  
</head>
<body>
Select department:
<select id="department">
<option>Select department</option>
<option>administrator</option>
<option>kitchen</option>
<option>clean</option>
</select>
<br/>
<br/>
Select category:
<select id="category">
<option>Select category</option>
</select>
</body>
</html>