<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
  <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
	
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
<div id="wrapper" style="background-color:#FFC300" style="color:white">
		<div id="header">
			<h2 style="color:white">CDAC - Online Quiz Portal</h2>
		</div>
	</div>	
	<a style="margin-left: 90%" href="<spring:url value = '/user/logout'/>"><button type="button" class="btn btn-danger">LOGOUT</button></a><br>
	
	<table style="color:white" border="2px">
				<tr>
				<th>Exam Id:</th>
					<th>Exam Name:</th>
					<th>Exam Language</th>
					<th>Marks obtained</th>
					<th>Exam date</th>
					<th>Answers</th>
				</tr>

				<c:forEach var="report" items="${requestScope.reports}">
					<tr>
					<td>${report.eid}</td>
						<td>${report.ename}</td>
						<td>${report.language}</td>
						<td>${report.marks}</td>
						<td>${report.testdate}</td>
					<td><a href="<spring:url value = '/questions/listQuestionsAndAnswerforu?eid=${report.eid}'/>">View answers</a> <br></td>
					</tr>
						

				</c:forEach>
			</table>

</body>
</html>