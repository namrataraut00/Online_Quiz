<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
  color:white;
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
#wrapper
{
 color:white;
}

	</style>
	</head>
<body style="color:black">
<div id="wrapper" style="background-color:#FFC300" >
		<div id="header">
			<h2>CDAC - Online Quiz Portal</h2>
		</div>
	</div>
<form method="post" class="box" style="color:white"> 
<input type=password name="password" style="color:white" placeholder="Password" >
<input type=password name="cpassword" style="color:white"  placeholder="Re-Password">
<input type="submit" style="color:black" class="btn btn-warning">
</form>
</body>
</html>