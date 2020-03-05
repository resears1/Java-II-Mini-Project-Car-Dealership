<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dealership Edit</title>
</head>
<body>
<h1>Edit Dealership</h1>
<form action = "editExistingListServlet" method="post">
List Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br />
Date Posted: <input type ="text" name = "month" placeholder="mm" size="4" value="${listToEdit.postDate.getMonthValue()}"> <input type ="text" name = "day" placeholder="dd" size="4" value="${listToEdit.postDate.getDayOfMonth()}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value="${listToEdit.postDate.getYear()}">
Dealership Name: <input type = "text" name = "dealerName" value="${listToEdit.dealer.dealerName}"><br />
<input type = "hidden" name = "id" value="${listToEdit.id}">
Current Cars Listed:<br />
<select name="currentCars" multiple size="6">
<c:forEach var = "listVal" items = "${listToEdit.listOfCars}">
          <option value = "${listVal.id}">${listVal.make} | ${listVal.model} | ${listVal.year}</option>          
  </c:forEach>
</select>
<br />
Remaining Cars:<br />
<select name="carsToAdd" multiple size="6">
<c:forEach items="${requestScope.allCarsToAdd}" var="currentcar">
   <option value = "${currentcar.id}">${currentcar.make} | ${currentcar.model} | ${currentcar.year}</option>
</c:forEach>
</select>

<br />
<input type = "submit" value="Edit List and Edit Cars">
</form>
<a href = "index.html">--Add New Cars--</a>
</body>

</html>