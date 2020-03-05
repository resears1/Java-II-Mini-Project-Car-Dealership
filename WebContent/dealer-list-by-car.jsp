<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style> 
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
<h1>List of Dealerships</h1>
<p>This is our manually-updated list of car dealerships in the area with current vehicles.</p>
<form method = "post" action = "listNavigationServlet">
<div style="text-align:center; padding-bottom: 10px;">
<table>
	<c:forEach items="${requestScope.allLists}" var="currentlist">
		<tr>
		<td><input type="radio" name="id" value="${currentlist.id}"></td>
		<td><h2 style="text-decoration:underline">${currentlist.listName}</h2></td></tr>
		<tr><td colspan="3"><strong>Post Date:</strong> ${currentlist.postDate}</td></tr>
		<tr><td colspan="3"><strong>Dealer:</strong> ${currentlist.dealer.dealerName}</td></tr>
		<c:forEach var = "listVal" items = "${currentlist.listOfCars}">
			<tr><td></td><td colspan="3" style="text-decoration:underline">${listVal.make}, ${listVal.model}, ${listVal.year}
			</td>
			</tr>
		</c:forEach>
	</c:forEach>
</table>
</div>
<div style="text-align:center; padding-bottom: 10px;">
<input type = "submit" value = "add" name="doThisToCar">
<input type = "submit" value = "edit" name="doThisToCar">
<input type = "submit" value = "delete" name="doThisToCar">
</div>
</form>
<a href="addCarsForListServlet">Add a new Dealer</a> <br />
<a href="index.html">Add a new Car/ Return Home</a><br />
</body>
</html>