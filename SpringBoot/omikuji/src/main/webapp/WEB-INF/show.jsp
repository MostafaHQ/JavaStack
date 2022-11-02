<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Show Page</title>
</head>
<body>
<h1>Here's Your Omikuji!</h1>
<div>
<p>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/>
with <c:out value="${person}"/> as your roommate, <c:out value="${hoppy}"/> for a living.
The next time you see a <c:out value="${type}"/>, you will have a good luck.
Also,<c:out value="${comment}"/></p>
</div>
</body>
</html>