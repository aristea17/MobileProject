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
<form class="form-horizontal">
	<div class="form-group">
	 <label for="username" class="col-sm-2 control-label">Username</label>
	   <div class="col-sm-10">
	   	<input type="text" class="form-control" id="username" value="">
	   </div>
	</div>
	<div class="form-group">
	<label for="password" class="col-sm-2 control-label">Password</label>
	   <div class="col-sm-10">
	   	<input type="password" class="form-control" id="password" value="">
	   	</div>
	</div>
	<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Login</button>
    </div>
  </div>
</form>
</body>
</html>