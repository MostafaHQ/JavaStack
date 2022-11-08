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
<h1>New Category</h1>
<a href="/">Home</a>
<form:form action="/categories/new" method="post" modelAttribute="category">
<div class="form-group">
    <form:label path="name">Name:</form:label>
    <form:errors path="name"/>
    <form:input path="name" class="form-control"/>
  </div>
   <button type="submit" class="btn btn-primary mt-3">Submit</button>
  </form:form>
</body>
</html>