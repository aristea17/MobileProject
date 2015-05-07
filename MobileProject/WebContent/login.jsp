<%@page import="code.LoginServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>
<form action="LoginServlet">  
 <div class="container">
 <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
     <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Login</div>
                    </div> 
       <div style="padding-top:30px" class="panel-body" >    
        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>  
        	<!-- Here the code for adding the error message when login was not successful -->
       		<div style="margin-bottom:25px" class="input-group">
       			<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
     			<input type="text" class="form-control" name="txtUsername" placeholder="Username" required="" autofocus="" />  			
       		</div>      
       		<div style="margin-bottom:25px" class="input-group">
       		    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
     			<input type="password" class="form-control" name="txtPassword" placeholder="Password" required="" autofocus="" />  			
       		</div>
       		<div class="input-group">
       			<div class="checkbox">
       				<label>
       					<input type="checkbox" value="1" id="rememberMe" name="rememberMe">Remember me
       				</label>
       			</div>
       		</div>
       		<div style="margin-top:10px" class="form-group">
       			<div class="col-sm-3 controls">
       				<button class="btn btn-md btn-primary btn-block" type="submit">Login</button>
       			</div>
       		</div>
  	 </div>
 </div>
</div>
</div>
</form>		
</body>
</html>