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
<a href="/languages">Dashboard</a>
</div>
<p>Expense Name: <c:out value="${language.name}"></c:out></p>
<p>Expense Description: <c:out value="${language.creator}"></c:out></p>
<p>Vendor: <c:out value="${language.version}"></c:out></p>
<a href="/edit/${language.id}">edit</a>
<form:form action="/${language.id}" method="post">
      <input type="hidden" name="_method" value="delete">
      <button type="submit" class="btn btn-danger">Delete</button>
    </form:form>
</body>
</html>