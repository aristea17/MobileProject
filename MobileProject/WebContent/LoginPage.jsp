<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Login.css" rel="stylesheet" type="text/css" />
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>
<form action="LoginServlet">  
 <div class="wrapper">
    <form class="form-signin">       
      <h2 class="form-signin-heading">Please login</h2>
      <input type="text" class="form-control" name="txtUsername" placeholder="Username" required="" autofocus="" />
      <input type="password" class="form-control" name="txtPassword" placeholder="Password" required=""/>      
      <label class="checkbox">
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
      </label>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>   
    </form>
  </div>
  <!--  
	<label for="txtUsername">Username</label>
	<input type="text" name="txtUsername" value=""/>
	
	<label for="txtPassword">Password</label>
	<input type="password" name="txtPassword" value=""/>	
	
	<input type="submit" value="check" /> -->
</form>		
</body>
</html>