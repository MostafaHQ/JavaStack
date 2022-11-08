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
<title>Languages</title>
</head>
<body>
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Creator</th>
      <th scope="col">Version</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="language" items="${languages}">
    <tr>
      <td><a href="${language.id}"><c:out value="${language.name}"></c:out></a></td>
      <td><c:out value="${language.creator}"></c:out></td>
      <td><c:out value="${language.version}"></c:out></td>
      <td class="d-flex justify-content-around"><a href="/edit/${language.id}">edit</a>|
      <form:form action="/${language.id}" method="post">
      <input type="hidden" name="_method" value="delete">
      <button type="submit" class="btn btn-danger">Delete</button>
    </form:form></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<form:form action="/languages" method="post" modelAttribute="language">
<div class="form-group">
    <form:label path="name">Name:</form:label>
    <form:errors path="name"/>
    <form:input path="name" class="form-control"/>
  </div>
  <div class="form-group">
    <form:label path="creator">Creator:</form:label>
    <form:errors path="creator"/>
    <form:input path="creator" class="form-control"/>
  </div>
   <div class="form-group">
    <form:label path="version">Version:</form:label>
    <form:errors path="version"/>
    <form:input type="number" path="version" class="form-control"/>
  </div>
  <button type="submit" class="btn btn-primary mt-3">Submit</button>
</form:form>
</body>
</html>