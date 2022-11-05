<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>All Books</title>
</head>
<body>
<h1>All Books</h1>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Language</th>
      <th scope="col">Number of Pages</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="book" items="${books}">
    <tr>
      <th scope="row"><c:out value="${book.id}"></c:out></th>
      <td><c:out value="${book.title}"></c:out></td>
      <td><c:out value="${book.language}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>