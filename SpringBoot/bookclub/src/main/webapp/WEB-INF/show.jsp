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
	<title>Show Book</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript" src="test.js"></script>
</head>
<body class="m-3">
<div class="container d-flex justify-content-between">
<h1>${book.title}</h1>
<a href="/books">back to the shelves</a>
</div>
<div class="container">
<c:choose>
<c:when test="${book.user.id == userId}">
<h4>You read <span style="color:purple">
    ${book.title}</span> by <span style="color:green">${book.author}</span></h4> 
    <h4>Here are your thoughts:</h4>
    <p>${book.thoughts}</p>
    
   	<div class="d-flex edit_delete">
    <a class="btn btn-primary" href="/books/${book.id}/edit">Edit</a>
     
    <a class="btn btn-danger" href="/delete/${book.id}">Delete</a>
    </div>
</c:when>
<c:otherwise>
 <h4><span style="color:red">${book.user.userName}</span> read <span style="color:purple">
    ${book.title}</span> by <span style="color:green">${book.author}</span></h4> 
    <h4>Here are ${book.user.userName}'s thoughts:</h4>
    <p>${book.thoughts}</p>
    </c:otherwise>
</c:choose>
</div>
</body>
</html>