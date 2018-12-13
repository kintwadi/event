<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/bootstrap4.1.1/bootstrap3/css/bootstrap.min.css">
<script src="/webapp/resources/bootstrap4.1.1/bootstrap3/js/bootstrap.min.js" ></script>
<script src="/resources/bootstrap4.1.1/js/popper.min.js" ></script>
<script src="/resources/bootstrap4.1.1/js/jquery-3.2.1.slim.min.js" ></script>
</head>
<body>

<hr>
<br>



<div class="card" style="width: 18rem;">
  <img class="card-img-top" src=".../100px180/" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>

<input type="button"  style ="color:red"onclick="listUsers()" value ="buscar usuarios home">

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