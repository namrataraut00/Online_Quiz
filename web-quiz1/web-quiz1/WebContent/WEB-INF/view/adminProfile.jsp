<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Profile</title>
<link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
  <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
	<style>
	body{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
 
}

	</style></head>

<body>
<div id="wrapper" style="background-color:#FFC300" style="color:white">
		<div id="header">
			<h2>CDAC - Online Quiz Portal</h2>
		</div>
	</div>
	
<h3>Welcome to Profile</h3>
<a style="margin-left: 90%" href="<spring:url value = '/user/home'/>"><button type="button" class="btn btn-success">HOME</button></a>
<form>
1.Name:<input type="text" value="${requestScope.adminProfile.name }" readonly><br><br>

2 mail id:<input type="text" value="${requestScope.adminProfile.email }" readonly>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<spring:url value = '/user/checkPassword'/>"><button type="button" class="btn btn-danger">CHANGE MAIL</button>
</a><br>	<br>
3. password:<input type="password" value="${requestScope.adminProfile.password }" readonly>


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<spring:url value = '/user/checkPassword1'/>"><button type="button" class="btn btn-danger">CHANGE PASSWORD</button>
</a><br>	<br>
</form>	
<a style="margin-left: 90%" href="<spring:url value = '/user/logout'/>"><button type="button" class="btn btn-danger">LOGOUT</button></a><br>

</body>
</html>