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
<title>Edit Expense</title>
</head>
<body>
<div class="d-flex justify-content-around">
<h1>Edit Expense</h1>
<a href="/expenses">Go Back</a>
</div>
<form:form action="/edit/${expense.id}" method="post" modelAttribute="expense">
<input type="hidden" name="_method" value="put">
<div class="form-group">
    <form:label path="name">Expense Name:</form:label>
    <form:errors path="name"/>
    <form:input path="name" class="form-control"  placeholder="Expense.."/>
  </div>
  <div class="form-group">
    <form:label path="vendor">Vendor:</form:label>
    <form:errors path="vendor"/>
    <form:input path="vendor" class="form-control"  placeholder="Vendor.."/>
  </div>
   <div class="form-group">
    <form:label path="amount">Amount:</form:label>
    <form:errors path="amount"/>
    <form:input type="number" path="amount" class="form-control"  placeholder="Amount.."/>
  </div>
  <div class="form-group">
    <form:label path="description">Description:</form:label>
    <form:errors path="description"/>
    <form:textarea path="description" class="form-control"/>
  </div>
  <button type="submit" class="btn btn-primary mt-3">Submit</button>
</form:form>
</body>
</html>