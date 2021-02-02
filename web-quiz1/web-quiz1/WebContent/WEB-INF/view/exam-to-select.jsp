<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
  <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
	<style>
	body{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
 /* background-image:url(https://www.rolandberger.com/img/Tiles/KIQuiz_Search_result_teaser_01.jpg); */
}
.box{
  width: 300px;
  padding: 40px;
  border-radius: 15px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  background: #191919;
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

<body>
	<div id="wrapper" style="background-color:#FFC300">
		<div id="header">
			<h2>CDAC - Online Quiz Portal</h2>
		</div>
	</div>
	
<br><a style="margin-left: 90%" href="<spring:url value = '/user/logout'/>"><button type="button" class="btn btn-danger">LOGOUT</button></a><br>
<a href="<spring:url value = '/user/profileUser'/>"><button type="button" class="btn btn-primary">Profile</button></a>
<br><br>	<div id="container">
		<div id="content">
	
			<br>
			<table>
				<tr>
					<th>Exam Name:</th>
					<th>Exam Language</th>
					<th>Action</th>
				</tr>

				<c:forEach var="exam" items="${requestScope.examDetails}">

					<tr>
						<td>${exam.examName}</td>
						<td>${exam.language}</td>
					<td><a href="<spring:url value = '/questions/takeQuiz?eid=${exam.examID}'/>"><button type="button" class="btn btn-warning">TAKE QUIZ</button>
</a> <br></td>
					</tr>

				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>



