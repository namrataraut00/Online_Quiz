<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
  <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
<meta charset="UTF-8">
<title>No Exams</title>

	<style>
	body{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  background-color:black;
  
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
  color: white;
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
  color: white;
  border-radius: 24px;
  transition: 0.25s;
  cursor: pointer;
}
.box input[type = "submit"]:hover{
  background: #2ecc71;
}
	</style></head>
<body style="color:white"> 
<div id="wrapper" style="background-color:#FFC300" style="color:white">
		<div id="header">
			<h2>CDAC - Online Quiz Portal</h2>
		</div>
	</div>
	<a style="margin-left: 90%" href="<spring:url value = '/user/logout'/>"><button type="button" class="btn btn-danger">LOGOUT</button></a><br>
	<br><br>
<center><h1 style="color:white">${requestScope.message}</h1></center>
<br>
<center><a href="<spring:url value = '/user/home'/>"><button type="button" class="btn btn-info" align="center">HOME</button></a><br>
</center>
</body>
</html>