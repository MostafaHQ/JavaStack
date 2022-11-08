<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
<h1>${product.name}</h1>
<a href="/">Home</a>
<h2>Products:</h2>
<ul>
<c:forEach var="product" items="${products}">
      <li><c:out value="${product.category.name}"></c:out></li>
      </c:forEach>
</ul>
<h2>Add Category</h2>
<form:form action="/products/${id}" method="post" modelAttribute="categoryProduct">  
  <form:select class="form-control" path="category">
        <c:forEach var="category" items="${categories}">
        <form:option value="${category.id}"><c:out value="${category.name}"></c:out></form:option>
    	</c:forEach>
        </form:select>
        <button type="submit" class="btn btn-primary mt-3">Add</button>
</form:form>
</body>
</html>