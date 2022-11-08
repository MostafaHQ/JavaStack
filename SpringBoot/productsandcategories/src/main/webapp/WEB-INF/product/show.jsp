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
</body>
</html>