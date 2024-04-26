<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>

<table style="width:50%">

<form action="${pageContext.request.contextPath}/Table" method="post">
	<label for ="Delete">Product Name You Wish To Delete<br></label>
	<input type="text" id="Delete" name="Delete" /><br>
	
	<input type="submit" value="Submit" id="submitButton">
</form>

</table>

</body>
</html>