<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		
		<c:choose>
		    <c:when test="${empty token.tokenId}">
		        ${message}
		    </c:when>
		    <c:otherwise>
		    	<h1 align="center"> Your Counter Token</h1>
		    	<table align="center" border="3">
			    	<tr>
				    	<td>
				        ${token.tokenId}
				        </td>
				        <td>
						<a href="delete/${counterNumber}"> Mark as Complete</a> 
						</td>
					</tr>
					
				</table>
		    </c:otherwise>
		</c:choose>
		
		
		



</body>
</html>