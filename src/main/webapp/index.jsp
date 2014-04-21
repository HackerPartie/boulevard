<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="hacker.partie.model.Sentence"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="includes/common-header.jsp"%>
<title>Es gilt die Umschuldsvermutung</title>
</head>

<body>

	<p id="logo_pic" align="center">
		<img src="oesterreich.jpg" alt="Österreich"
			title="Österreich ist-ur.org" width=500 height=70>
	</p>

	<p id="logo_text">
		<font color="black">i</font><font color="white">S</font><font
			color="green">T</font><font color="black">-</font>U<font
			color="yellow">R</font><font color="black">.</font><font
			color=#E2010F>o</font><font color="white">R</font><font color="black">G</font>
	</p>

	<%@include file="includes/navigation.jsp"%>


	<div class="container">
		<h1 class="text-center pagination-centered">
			${randomJunk.subject} ${randomJunk.verb} ${randomJunk.complement}</h1>
	</div>
	
</body>
</html>