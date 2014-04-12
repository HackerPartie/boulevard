<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="hacker.partie.model.Sentence"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Einbinden von selbst erstellten Boulevard-Stylesheet -->
<link href="resources/css/boulevard.css" rel="stylesheet" media="screen">

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Bree+Serif'
	rel='stylesheet' type='text/css'>
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<style type="text/css">
html,body {
	background: #f06a1c;
}

h1 {
	font-size: 75px !important;
	font-family: 'Bree Serif', serif;
}
</style>

<title>Es gilt die Umschuldsvermutung</title>
</head>

<body>

	<p id="logo_pic" align="center">
		<img src="oesterreich.jpg" alt="Österreich"
			title="Österreich ist-ur.org" width=550 height=80>
	</p>

	<p id="logo_text">
		<font color="blue">i</font><font color="yellow">s</font><font
			color="green">t</font><font color="black">-</font>u<font
			color="yellow">r</font>.o<font color="green">r</font><font
			color="blue">g</font>
	</p>

	<%@include file="includes/navigation.jsp"%>

	<div class="container">
		<h1 class="text-center pagination-centered">
			${randomJunk.subject} ${randomJunk.verb} ${randomJunk.complement}</h1>
	</div>

	<div id="schlagzeile">
		<p>${randomJunk.subject} ${randomJunk.verb}
			${randomJunk.complement}
		<p>
	</div>
	
		<div id="schlagzeile2">
		<p>${randomJunk.subject} ${randomJunk.verb}
			${randomJunk.complement}
		<p>
	</div>
</body>
</html>