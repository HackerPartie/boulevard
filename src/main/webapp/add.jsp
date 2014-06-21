<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/common-header.jsp"%>
<title>Add an original sentence here</title>
</head>
<body>
	<%@include file="includes/navigation.jsp"%>
	<h3> Einen Satz hinzufügen</h3>
	<form action="add" method="post" class="form-inline">
	<input type="text" class="form-control" name="subject" placeholder="Subjekt">
	<input type="text" class="form-control" name="verb" placeholder="Verb">
	<input type="text" class="form-control" name="complement" placeholder="Ergänzung">
	<button type="submit" class="btn btn-default"> Zur Sätzenliste hinzufügen</button>
	</form>
</body>
</html>