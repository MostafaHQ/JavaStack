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
<title>New Category</title>
</head>
<body>
<h1>${category.name}</h1>
<a href="/">Home</a>
<h2>Categories:</h2>
<ul>
<c:forEach var="category" items="${categories}">
      <li><c:out value="${category.product.name}"></c:out></li>
      </c:forEach>
</ul>
<h2>Add Product</h2>
<form:form action="/categories/${id}" method="post" modelAttribute="categoryProduct">  
  <form:select class="form-control" path="product">
        <c:forEach var="product" items="${products}">
        <form:option value="${product.id}"><c:out value="${product.name}"></c:out></form:option>
    	</c:forEach>
        </form:select>
        <button type="submit" class="btn btn-primary mt-3">Add</button>
</form:form>
</body>
</html>