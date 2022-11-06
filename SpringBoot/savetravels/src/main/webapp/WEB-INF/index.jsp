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
<title>Insert title here</title>
</head>
<body>
<h1>Save Travels</h1>
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Expenses</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="expense" items="${expenses}">
    <tr>
      <td><c:out value="${expense.name}"></c:out></td>
      <td><c:out value="${expense.vendor}"></c:out></td>
      <td><c:out value="${expense.amount}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<h2>Add an expense:</h2>
<form:form action="/expenses" method="post" modelAttribute="expense">
<div class="form-group">
    <form:label path="name">Expense Name:</form:label>
    <form:errors path="name"/>
    <form:input path="name" class="form-control"  placeholder="Expense"/>
  </div>
  <div class="form-group">
    <form:label path="vendor">Vendor:</form:label>
    <form:errors path="vendor"/>
    <form:input path="vendor" class="form-control"  placeholder="Vendor"/>
  </div>
   <div class="form-group">
    <form:label path="amount">Amount:</form:label>
    <form:errors path="amount"/>
    <form:input type="number" path="amount" class="form-control"  placeholder="Amount"/>
  </div>
  <div class="form-group">
    <form:label path="description">Description:</form:label>
    <form:errors path="description"/>
    <form:textarea path="description" class="form-control"  placeholder="Amount"/>
  </div>
  <button type="submit">Submit</button>
</form:form>
</body>
</html>