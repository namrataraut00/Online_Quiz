<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD EXAM PAGE</title>
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
<div id="wrapper" style="background-color:#FFC300" >
		<div id="header">
			<h2>CDAC - Online Quiz Portal</h2>
		</div>
	</div>	
	<h4>ADD EXAM PAGE</h4>
<form method="post">
<table>
<tr><td>Exam Name:</td> <td><input type="text" name="examName" class="form-control mr-sm-2" placeholder="ExamNAme"></td></tr>

<tr><td>Exam Language:</td> <td><input type="text" class="form-control mr-sm-2" name="examLanguage" placeholder="examLanguage"></td></tr>
<tr><td><input type="submit" value="submit" class="btn btn-success"></td></tr>

</table>

</form>
</body>
</html>