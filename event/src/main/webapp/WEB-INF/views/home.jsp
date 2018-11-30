<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
<br>
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