<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
  <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>Login page</title>
	
	<style>
	body{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  color:white;
/*  background-image:url(https://www.rolandberger.com/img/Tiles/KIQuiz_Search_result_teaser_01.jpg);
 */ 
 bgcolor:white;
}
.box{
  width: 300px;
  padding: 40px;
  border-radius: 15px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  text-align: center;

}
.box h1{
 
  text-transform: uppercase;
  font-weight: 500;
}
.box input[type = "text"],.box input[type = "password"]{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #3498db;
  padding: 14px 10px;
  width: 200px;
  outline: none;
  color: white;
  border-radius: 24px;
  transition: 0.25s;
}
.box input[type = "text"]:focus,.box input[type = "password"]:focus{
  width: 280px;
  border-color: #2ecc71;
}
.box input[type = "submit"]{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #2ecc71;
  padding: 14px 40px;
  outline: none;
  color: black;
  border-radius: 24px;
  transition: 0.25s;
  cursor: pointer;
}
.box input[type = "submit"]:hover{
  background: #2ecc71;
}
	</style>
	  
</head>
<body>
	<div id="wrapper" style="background-color:#FFC300" >
		<div id="header">
			<h2>CDAC - Online Quiz Portal</h2>
		</div>
	</div>	
		
<form class="box" method="post" style="color:white">
  <h2>Login</h2>
  <input type="text"  placeholder="Username" name="email" autofocus autocomplete>
  <input type="password" placeholder="Password" name="password">
  <button type="submit"  value="Login" class="btn btn-warning">LOGIN</button><br><br>	
  <a href="register"><button type="button"  class="btn btn-danger">Register</button></a>
</form>

</body>
</html>