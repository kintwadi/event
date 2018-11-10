
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<spring:url value="/login" var ="login"/>

<form action="${login}" method="post">

  user name:<br><input type="text" name="userName" ><br>
  Email:<br><input type="text" name="email"><br>
  Password:<br><input type="text" name="password"><br>
  <input type="submit" value="login">
  
 
  
</form> 

 ${msg}
<script>

function loadDoc(root) {
	
	
	  var xhttp = new XMLHttpRequest();
	  var userName = document.getELementById("username");
	  var email = document.getElementById("email");
	  var password = document.getElementById("password");
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	     		document.getElementById("demo").innerHTML = this.responseText;
	    }
	  };
	  var url = root+"?login&username="+userName"&email="+email+"&passowrd="+password;
	  xhttp.open("POST", url, true);
	  xhttp.send();
	}


</script>



</body>
</html>