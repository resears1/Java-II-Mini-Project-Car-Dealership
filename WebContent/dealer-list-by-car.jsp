<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
<td><input type="radio" name="id" value="${currentlist.id}"></td>
<td><h2>${currentlist.listName}</h2></td></tr>
<tr><td colspan="3">Post Date: ${currentlist.postDate}</td></tr>
<tr><td colspan="3">Dealer: ${currentlist.dealer.dealerName}</td></tr>
<c:forEach var = "listVal" items = "${currentlist.listOfCars}">
<tr><td></td><td colspan="3">${listVal.make}, ${listVal.model}, ${listVal.year}
</td>
</tr>
</c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToCar">
<input type = "submit" value = "delete" name="doThisToCar">
<input type = "submit" value = "add" name="doThisToCar">
</form>
<a href="addCarsForListServlet">Create a new List</a>
<a href="index.html">Insert a new Car</a>
</body>
</html>