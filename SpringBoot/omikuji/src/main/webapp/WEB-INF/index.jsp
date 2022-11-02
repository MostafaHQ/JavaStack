<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Omikuji Form</title>
</head>
<body>
<h1>Send an Omikuji!</h1>
<form action="/omikuji/post/" method="post">
<div>
<label>Pick any number from 5 to 25</label>
<input type="number" name="number" id="number" min="5" max="25"/>
</div>
<div>
<lable>Enter the name of any city</label>
<input type="text" name="city"/>
</div>
<div>
<lable>Enter the name of any real person</label>
<input type="text" name="person"/>
</div>
<div>
<lable>Enter professional endeavor or hobby</label>
<input type="text" name="hobby"/>
</div>
<div>
<lable>Enter any type of living thing</label>
<input type="text" name="type"/>
</div>
<div>
<lable>Say something nice to someone</label>
<textarea name="comment" id="comment" cols="30" rows="10"></textarea>
</div>
<button type="submit">Send</button>
</form>
</body>
</html>