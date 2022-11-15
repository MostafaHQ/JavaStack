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
	<title>Login And Registration</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="test.js"></script>
</head>
<body>
<div class="container">
<h1>Welcome!</h1>
<h3>Join our growing community</h3>
</div>
<div class="d-flex justify-content-around">
<div>
<h2>Register</h2>
<form:form action="/register" method="post" modelAttribute="newUser">
<div class="form-group">
    <form:label path="userName">User Name:</form:label>
    <form:errors path="userName" style="color:red" />
    <form:input path="userName" class="form-control"/>
  </div>
  <div class="form-group">
    <form:label path="email">Email:</form:label>
    <form:errors path="email" style="color:red" />
    <form:input path="email" class="form-control"/>
  </div>
    <div class="form-group">
    <form:label path="password">Password:</form:label>
    <form:errors path="password" style="color:red" />
    <form:input type="password" path="password" class="form-control"/>
  </div>
    <div class="form-group">
    <form:label path="confirm">Confirm PW:</form:label>
    <form:errors path="confirm" style="color:red" />
    <form:input type="password" path="confirm" class="form-control"/>
  </div>
   <button type="submit" class="btn btn-primary mt-3">Submit</button>
  </form:form>
</div>
  <div>
  <h2>Log in</h2>
  <form:form action="/login" method="post" modelAttribute="newLogin">
<div class="form-group">
    <form:label path="email">Email:</form:label>
    <form:errors path="email" style="color:red" />
    <form:input path="email" class="form-control"/>
  </div>
  <div class="form-group">
    <form:label path="password">Password:</form:label>
    <form:errors path="password" style="color:red" />
    <form:input type="password" path="password" class="form-control"/>
  </div>
  <button type="submit" class="btn btn-primary mt-3">Submit</button>
  </form:form>
  </div>
</div>
</body>
</html>