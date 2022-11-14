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
	<title>Bookmarket</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript" src="test.js"></script>
</head>
<body class="m-3">
<div class="container d-flex justify-content-between">
<h4>Hello, <c:out value="${currentUser.userName}"></c:out>. Welcome to..</h4>
<a href="/books">back to the shelves</a>
</div>
<div class="container">
<h1>The Book Broker</h1>
</div>
<div class="container mt-3">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Owner</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${books}">
    <tr>
    <td><c:out value="${book.id}"></c:out></td>
      <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
      <td><c:out value="${book.author}"></c:out></td>
      <c:choose>
	  <c:when test="${book.user.id == userId}">
	  <td><a href="/books/${book.id}/edit">edit</a>
    	<a href="/delete/${book.id}">delete</a></td>
	  </c:when>
	  <c:otherwise>
	  <a href="">borrow</a>
	  </c:otherwise>
	  </c:choose>
    </tr>
    </c:forEach>
  </tbody>
</table></div>
</body>
</html>