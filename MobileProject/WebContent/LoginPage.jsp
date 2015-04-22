<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <form class="form-signin">       
      <h2 class="form-signin-heading">Please login</h2>
      <label for="txtUsername" class="sr-only">Username</label>
      <input type="text" class="form-control" name="txtUsername" placeholder="Username" required="" autofocus="" />
      <label for="txtPassword" class="sr-only">Password</label>
      <input type="password" class="form-control" name="txtPassword" placeholder="Password" required=""/>      
      <label class="checkbox">
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
      </label>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>   
    </form>
  </div>
</form>		
</body>
</html>