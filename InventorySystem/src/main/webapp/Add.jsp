<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add varibles for the sql database</title>
</head>
<body>

<table style="width:50%">

<form action="${pageContext.request.contextPath}/Table" method="post">
	<label for ="PN">Product Name<br></label>
	<input type="text" id="PN" name="PN" /><br>
	<label for ="PI">Product Description<br></label>
	<input type="text" id="PI" name="PI" /><br>
	<label for ="last">Last Ordered<br></label>
	<input type="text" id="last" name="last" /><br>
	<label for ="exp">Expiration Date<br></label>
	<input type="text" id="exp" name="exp" /><br>
	<label for ="stock">Stock Amount<br></label>
	<input type="text" id="stock" name="stock" /><br>
	<label for ="supply">Supplier Details<br></label>
	<input type="text" id="supply" name="supply" /><br>
	
	<input type="submit" value="Submit" id="submitButton">
</form>

</table>

</body>
</html>