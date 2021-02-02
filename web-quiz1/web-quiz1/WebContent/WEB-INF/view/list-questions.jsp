<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>List of Users</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/darkly/bootstrap.min.css">
<link rel="stylesheet"
	href="https://bootswatch.com/4/darkly/bootstrap.css">
<style>
body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
}
</style>
</head>

<body>

	<div id="wrapper" style="background-color: #FFC300" style="color:white">
		<div id="header">
			<h2 style="color: white">CDAC - Online Quiz Portal</h2>
		</div>
	</div>
	<a style="margin-left: 90%" href="<spring:url value = '/user/logout'/>"><button
			type="button" class="btn btn-danger">LOGOUT</button></a>
	<br>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Exam Name:</th>
					<th>Question Number</th>
					<th>Question Text</th>
					<th>Option A</th>
					<th>Option B</th>
					<th>Option C</th>
					<th>Option D</th>
					<th>Action</th>
				</tr>

				<c:forEach var="tempQuestions" items="${questions}">
					<tr>
						<td>${tempQuestions.exam.examName}</td>
						<td>${tempQuestions.q_id}</td>
						<td>${tempQuestions.q_text}</td>
						<td>${tempQuestions.q_optA}</td>
						<td>${tempQuestions.q_optB}</td>
						<td>${tempQuestions.q_optC}</td>
						<td>${tempQuestions.q_optD}</td>
						<td><a
							href="<spring:url value = '/questions/showformforUpdate?q_id=${tempQuestions.q_id}'/>"><button
									type="button" class="btn btn-info">UPDATE</button></a> <a
							href="<spring:url value = '/questions/delete?q_id=${tempQuestions.q_id}'/>"><button
									type="button" class="btn btn-danger">DELETE</button></a></td>
					</tr>

				</c:forEach>
			</table>

		</div>
	</div>


</body>
</html>