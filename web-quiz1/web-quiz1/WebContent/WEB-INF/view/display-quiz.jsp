<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<style>
	body{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
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
	</style>

<script>


var date = new Date();
var endTimerDate = new Date();
endTimerDate.setTime(date.getTime() + (10 * 60 * 1000));
var resultCounter=0;
var myfunc = setInterval(function() {

var now = new Date().getTime();
var timeleft = endTimerDate.getTime() - now;
    
// Calculating the days, hours, minutes and seconds left
/* var hours = Math.floor((timeleft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
 */var minutes = Math.floor((timeleft % (1000 * 60 * 60)) / (1000 * 60));
var seconds = Math.floor((timeleft % (1000 * 60)) / 1000);
    
// Result is output to the specific element
/* document.getElementById("hours").innerHTML = hours + "h " 
 */document.getElementById("mins").innerHTML = minutes + "m " 
document.getElementById("secs").innerHTML = seconds + "s " 
    
// Display the message when countdown is over
if (timeleft < 0) {
    clearInterval(myfunc);
    document.getElementById("mins").innerHTML = ""
    document.getElementById("secs").innerHTML = ""
    	document.getElementById("content").innerHTML = "Exam Finished. Result="+resultCounter;
	document.getElementById("content").innerHTML += "<form name=\"generateresult\"action=\"goBackTolistExam\" method=\"post\"><input type=\"button\" onclick=\"submitResult1()\" value=\"go to list all exams\"><input type=\"hidden\" id=\"result\" name=\"result\"></form>";

document.getElementById("content").innerHTML += "<form name=\"generateresultnlogout\"action=\"logout\" method=\"post\"><input type=\"button\" onclick=\"submitResult()\" value=\"logout\"><input type=\"hidden\" id=\"result\" name=\"result\"></form>";
}
}, 1000);


var question = [];
var opta = new Array();
var optb = new Array();
var optc = new Array();
var optd = new Array();
var answer=new Array();
        <c:forEach var="tempQuestions" items="${qlist}">
        question.push("${tempQuestions.q_text}");
        console.log(question);
			opta.push("${tempQuestions.q_optA}");
			optb.push("${tempQuestions.q_optB}");
			optc.push("${tempQuestions.q_optC}");
			optd.push("${tempQuestions.q_optD}");
			answer.push("${tempQuestions.q_answer}")
        </c:forEach>
        var counter=1;
        
function myfunction () {	
		var ques = document.querySelectorAll(".que");
		console.log(question.length);

		ques[0].innerHTML = question[0];
		ques[1].innerHTML = "<input type=radio name=\"option\" value=\""+opta[0]+"\">"+opta[0];
		ques[2].innerHTML = "<input type=radio name=\"option\" value=\""+optb[0]+"\">"+optb[0];
		ques[3].innerHTML = "<input type=radio name=\"option\" value=\""+optc[0]+"\">"+optc[0];
		ques[4].innerHTML = "<input type=radio name=\"option\" value=\""+optd[0]+"\">"+optd[0];
		//document.getElementById("showresult").innerHTML =resultCounter;

}
function submitResult2(){
	document.getElementById('endexamResult').value = resultCounter;
console.log("inside submit result funct");
	document.forms["generateresult"].submit();
}

function submitResult(){
	document.getElementById('result').value = resultCounter;
console.log("inside submit result funct");
	document.forms["generateresultnlogout"].submit();
}
function submitResult1(){
	document.getElementById('result').value = resultCounter;
console.log("inside submit result funct");
	document.forms["generateresult"].submit();
}

function submitFunction2()
{
	clearInterval(myfunc);
    document.getElementById("mins").innerHTML = ""
    document.getElementById("secs").innerHTML = ""
   
document.getElementById("content").innerHTML = "Exam Finished. Result="+resultCounter;
document.getElementById("content").innerHTML += "<form name=\"generateresult\"action=\"goBackTolistExam\" method=\"post\"><input type=\"button\" onclick=\"submitResult1()\" value=\"go to list all exams\"><input type=\"hidden\" id=\"result\" name=\"result\"></form>";

document.getElementById("content").innerHTML += "<form name=\"generateresultnlogout\"action=\"logout\" method=\"post\"><input type=\"button\" onclick=\"submitResult()\" value=\"logout\"><input type=\"hidden\" id=\"result\" name=\"result\"></form>";

}

function submitFunction() {
	var q_opt = document.getElementsByName('option');
	var q_ans;
	for(var i = 0; i < q_opt.length; i++){
	    if(q_opt[i].checked){
	    	q_ans = q_opt[i].value;
	    	if(q_ans==answer[counter-1])
	    		resultCounter++;
	    }
	}
    var que = document.querySelectorAll(".que");

    que[0].innerHTML= question[counter];
		que[1].innerHTML = "<input type=radio name=\"option\" value=\""+opta[counter]+"\">"+opta[counter];
		que[2].innerHTML = "<input type=radio name=\"option\" value=\""+optb[counter]+"\">"+optb[counter];
		que[3].innerHTML = "<input type=radio name=\"option\" value=\""+optc[counter]+"\">"+optc[counter];
		que[4].innerHTML = "<input type=radio name=\"option\" value=\""+optd[counter]+"\">"+optd[counter];
		
    if(question.length==counter)
    	{
    	 clearInterval(myfunc);
    	    document.getElementById("mins").innerHTML = ""
    	    document.getElementById("secs").innerHTML = ""
    	   
    	document.getElementById("content").innerHTML = "Exam Finished. Result="+resultCounter;
		document.getElementById("content").innerHTML += "<form name=\"generateresult\"action=\"goBackTolistExam\" method=\"post\"><input type=\"button\" class=\"btn btn-success\" onclick=\"submitResult1()\" value=\"go to list all exams\"><input type=\"hidden\" id=\"result\" name=\"result\"></form>";

	document.getElementById("content").innerHTML += "<form name=\"generateresultnlogout\"action=\"logout\" method=\"post\"><input type=\"button\"  class=\"btn btn-danger\" onclick=\"submitResult()\" value=\"logout\"><input type=\"hidden\" id=\"result\" name=\"result\"></form>";
    	}
    counter++;
}
</script>
</head>
<link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
  <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
<body onload="myfunction()">
	<div id="wrapper" style="background-color:#FFC300">
		<div id="header">
			<h2>CDAC - Online Quiz Portal</h2>
		</div>
	</div>
	
		<h4 style="color:white">Exam Name: ${exam.examName }</h4>

	<div >
		
		<p id="mins" style="color:white"></p>
		<p id="secs" style="color:white"></p>
	</div>
	
			<br>
			<!--  <form>   -->
			<div id="content">
			<table>

				<tr>
					<td class="que"></td>
				</tr>
				<tr>
					<td class="que"></td>
				</tr>
				<tr>
					<td class="que"></td>
				</tr>
				<tr>
					<td class="que"></td>
				</tr>

				<tr>
					<td class="que"></td>
				</tr>

				<tr>
					<td><button onclick="submitFunction()" class="btn btn-success">NEXT</button></td>
				</tr>

		

		</table>
		</div>
</body>
</html>