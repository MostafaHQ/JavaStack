<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<title>Success</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript" src="test.js"></script>
</head>
<body class="m-3">
<div class="container d-flex justify-content-between">
<div>
<h1>Welcome, <c:out value="${currentUser.userName}" ></c:out></h1>
<h6>Books from everyone's shelves</h6>
</div>
<div>
<a href="/logout" style="text-decoration: none;">Logout</a><br>
<a href="">+ Add a book to my shelf!</a>
</div>
</div>
<div class="container mt-3">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Posted by</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${books}">
    <tr>
    <td><c:out value="${book.id}"></c:out></td>
      <td><a href="${book.id}"><c:out value="${book.name}"></c:out></a></td>
      <td><c:out value="${book.author}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table></div>
</body>
</html>