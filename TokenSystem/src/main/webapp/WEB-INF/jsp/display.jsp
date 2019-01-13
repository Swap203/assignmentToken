<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counters</title>
</head>
<body>
	
	<h1 align="center"> All Tokens</h1>
	<table border="0" align="center">
	<tr>
	    <th>Counter</th>
	    <th>|</th>
	    <th>Token Id</th>
	  </tr>
	  <tr>
	  <td>&nbsp;</td>
	  <td>&nbsp;</td>
	  <td>&nbsp;</td></tr>
	<c:forEach items="${counter}" var="element"> 
	  <tr>
	    <td>${element.counter}</td>
	    <td>&nbsp;</td>
	    <td>${element.tokenId}</td>
	  </tr>
	</c:forEach>
</table>
<script>
	setTimeout(function(){
	   window.location.reload(1);
	}, 5000);

</script>
</body>
</html>