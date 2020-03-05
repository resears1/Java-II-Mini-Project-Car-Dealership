<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Cars</title>
<style> 
	label {
	font-weight: bold;
    display: inline-block;
    float: left;
    clear: left;
    width: 80px;
    text-align: right;
    padding: 10px;
	}

	input[type=text] {
	  width: 25%;
	  height: 30px;
	  padding: 12px 20px;
	  padding-left: 50px;
	  margin: 20px 0;
	  box-sizing: border-box;
	}
	
	form {
		width: 25%;
		border: 2px dotted black;
	}
</style>
</head>
<body>
<h1>Car List</h1>
<form method="post" action="navigationServlet">
<table>
	<c:forEach items="${requestScope.allCars}" var="currentcar">
		<tr>
			<td><input type="radio" name="id" value="${currentcar.id}"></td>
			<td>${currentcar.make}</td>
			<td>${currentcar.model}</td>
			<td>${currentcar.year}</td>
		</tr>
	</c:forEach>
</table>
<br />
<div style="text-align:center; padding-top: 5px;"><p>-----------------------------</p></div>
<div style="text-align:center; padding-bottom: 10px;">
	<p>Select a Car to Edit or Delete</p>
	<input type = "submit" value="add" name="doThisToCar">
	<input type = "submit" value="edit" name="doThisToCar">
	<input type = "submit" value="delete" name="doThisToCar">
</div>
</form>
<a href="index.html"><em>Return to Homepage</em></a><br />
</body>
</html>