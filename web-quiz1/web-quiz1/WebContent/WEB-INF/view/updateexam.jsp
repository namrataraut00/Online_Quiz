<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
}
	</style></head>
<body>
<div id="wrapper" style="background-color:#FFC300" style="color:white">
		<div id="header">
			<h2 style="color:white">CDAC - Online Quiz Portal</h2>
		</div>
	</div>	
	<a style="margin-left: 90%" href="<spring:url value = '/user/logout'/>"><button type="button" class="btn btn-danger">LOGOUT</button></a><br>
	
<form action="updateExam" method="post">
<table>
<tr><td>Exam ID:</td> <td><input type="text" name="examID" class="form-control mr-sm-2" value="${requestScope.exam.examID }"></td></tr>
<tr><td>Exam Name:</td> <td><input type="text" name="examName" class="form-control mr-sm-2" value="${requestScope.exam.examName }"></td></tr>
<tr><td>Exam Language:</td> <td><input type="text" name="examLanguage" class="form-control mr-sm-2" value="${requestScope.exam.language }"></td></tr>
<tr><td><input type="submit" value="submit"></td></tr>

</table>

</form>
</body>
</html>