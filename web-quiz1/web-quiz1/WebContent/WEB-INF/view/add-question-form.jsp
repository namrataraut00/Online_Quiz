<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
  <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
<title>Add question page</title>
<style>
	body{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
 
    }
</style>
</head>
<body>
<div id="wrapper" style="background-color:#FFC300" >
		<div id="header">
			<h2>CDAC - Online Quiz Portal</h2>
		</div>
	</div>	

	<div id="container">

		<h3>Add Question</h3>

		<form:form action="addQuestion" modelAttribute="question"
			method="POST">

			<form:hidden path="q_id" name= "qid"/>

			<table>
				<tbody>

					<tr>
						<td><label>Ques Text : </label></td>
						<td><form:input path="q_text" class="form-control mr-sm-2"/></td>
					</tr>

					<tr>
						<td><label>Option A : </label></td>
						<td><form:input path="q_optA" class="form-control mr-sm-2"/></td>
					</tr>

					<tr>
						<td><label>Option B : </label></td>
						<td><form:input path="q_optB" class="form-control mr-sm-2" /></td>
					</tr>

					<tr>
						<td><label>Option C : </label></td>
						<td><form:input path="q_optC"  class="form-control mr-sm-2"/></td>
					</tr>

					<tr>
						<td><label>Option D : </label></td>
						<td><form:input path="q_optD" class="form-control mr-sm-2"/></td>
					</tr>

					<tr>
						<td><label>Ques ans : </label></td>
						<td><form:input path="q_answer"  class="form-control mr-sm-2"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						</tr>
						<tr>
						<td><input type="submit" class="btn btn-success" value="submit"></button>
</td>
					</tr>

				</tbody>
			</table>


		</form:form>
<br><br>
		<div style=""></div>

		<p>
				<a href="<spring:url value = '/questions/list?
							eid=${requestScope.examId }'/>"><button type="button" class="btn btn-info">VIEW QUESTIONS</button>
</a>
	<br>							
								
		</p>

		<p>
				<a href="<spring:url value = '/exams/addExam'/>"><button type="button" class="btn btn-warning">ADD EXAM</button>
</a>
								
		</p>


	</div>

</body>
</html>