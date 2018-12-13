
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

<spring:url value="/register_user" var="register_user"/>


<hr>
<br>
<input type="button" onclick="listUsers()" value ="buscar usuarios">

 <div id = "conteudo"></div>
<script>



function listUsers() {
	
	
	  var xhttp = new XMLHttpRequest();
	  
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	   var conteudo = document.getElementById("conteudo");
	    	   
	    	    var data = JSON.parse(this.responseText);
	    	    console.log(this.responseText);
	    	    for(let i = 0; i < data.length; i++){
	    	    	
	    	    	conteudo.innerHTML +=" <br> nome: "+ data[i]["userName"] ;
	  	    	    conteudo.innerHTML +=" <br> email: "+ data[i]["email"] ;
	  	    	    conteudo.innerHTML +="<br> password: "+data[i]["password"] ;
	  	    	    conteudo.innerHTML +="<br> telef: "+data[i]["cellphone"] ;
	  	    	    conteudo.innerHTML +="<br> país: "+ data[i]["country"] ;
	  	    	    conteudo.innerHTML +="<br> provincia: "+ data[i]["city"] ;
	  	    	    conteudo.innerHTML += "<br> cidade: "+data[i]["street"] ;
	  	    	  	conteudo.innerHTML += "<hr>" ;
	    	    	
	    	    }
	    	    
	    	  
	    }
	  };
	  var url = "http://localhost:8181/event/get_users";
	  xhttp.open("GET", url, true);
	  xhttp.send();
	}


</script>



</body>
</html>