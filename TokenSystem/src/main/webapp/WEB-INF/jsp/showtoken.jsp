<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h2 align="center">Generate Token</h2>
	<form action="token" method="post">
		
		<table align="center">
		<tr>
		<td>
			Enter Mobile Number <input type="text" name="mobileNumber"/>
		</td>
		</tr>
		<tr>
		<td>
			<input type="submit" name="generateToken" value="Generate Token" />
			</td>
			</tr>
		</table>
	
	</form> 
	



</body>
</html>