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
	<title>Books</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript" src="test.js"></script>
</head>
<body class="m-3">
<div class="container d-flex justify-content-between">
<h1>Add a Book to Your Shelf!</h1>
<a href="/books">back to the shelves</a>
</div>
<div class="container">
<form:form action="/books/new" method="post" modelAttribute="book">
<div class="form-group">
    <form:label path="title">Title:</form:label>
    <form:errors path="title" style="color:red" />
    <form:input path="title" class="form-control"/>
  </div>
  <div class="form-group">
    <form:label path="author">Author:</form:label>
    <form:errors path="author" style="color:red" />
    <form:input path="author" class="form-control"/>
  </div>
   <div class="form-group">
    <form:label path="thoughts">My Thoughts:</form:label>
    <form:errors path="thoughts" style="color:red" />
    <form:textarea path="thoughts" class="form-control"/>
  </div>  
  <form:input type="hidden" path="user" value="${userId}"></form:input>
  
  <button type="submit" class="btn btn-primary mt-3">Submit</button>
  </form:form>
  </div>
</body>
</html>