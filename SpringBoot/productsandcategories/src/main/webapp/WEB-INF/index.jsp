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
<title>Home</title>
</head>
<body>
<h1>Home Page</h1>
<a href="/products/new">New Product</a>
<a href="/categories/new">New Category</a>
<div class="container mt-3">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Product</th>
      <th scope="col">Category</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><ul><c:forEach var="product" items="${products}">
      <li><c:out value="${product.name}"></c:out></li>
      </c:forEach>
      </ul></td>
       <td><ul><c:forEach var="category" items="${categories}">
      <li><c:out value="${category.name}"></c:out></li>
      </c:forEach>
      </ul></td>
    </tr>
  </tbody>
</table>
</div>
</body>
</html>