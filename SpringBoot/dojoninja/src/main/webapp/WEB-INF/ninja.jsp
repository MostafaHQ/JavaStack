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
<title>Add Ninja</title>
</head>
<body>
<h1>New Ninja</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
<div class="col">
    <form:label path="dojo">Dojo:</form:label>
    <form:errors path="dojo"/>
    <form:select path="dojo">
    <c:forEach var="dojo" items="${dojos}">
    <option value="${dojo.id}">${dojo.name}</option>
    </c:forEach>
    </form:select>
  </div>
  <div class="col">
    <form:label path="firstName">First Name:</form:label>
    <form:errors path="firstName"/>
    <form:input path="firstName" class="form-control col-6"/>
  </div>
   <div class="col">
    <form:label path="lastName">Last Name:</form:label>
    <form:errors path="lastName"/>
    <form:input path="lastName" class="form-control col-6"/>
  </div>
  <div class="col">
    <form:label path="age">Age:</form:label>
    <form:errors path="age"/>
    <form:input path="age" class="form-control col-6"/>
  </div>
  <button type="submit" class="btn btn-primary mt-3">Create</button>
  </form:form>
</body>
</html>