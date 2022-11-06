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
<title>Show Expense</title>
</head>
<body>
<div class="d-flex justify-content-around">
<h1>Expense Details</h1>
<a href="/expenses">Go Back</a>
</div>
<p>Expense Name: <c:out value="${expense.name}"></c:out></p>
<p>Expense Description: <c:out value="${expense.description}"></c:out></p>
<p>Vendor: <c:out value="${expense.vendor}"></c:out></p>
<p>Amount: <c:out value="${expense.amount}"></c:out></p>
</body>
</html>