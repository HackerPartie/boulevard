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
			title="Österreich ist-ur.org" width=550 height=80>
	</p>

	<p id="logo_text">
		<font color="blue">i</font><font color="yellow">s</font><font
			color="green">t</font><font color="black">-</font>u<font
			color="yellow">r</font>.o<font color="green">r</font><font
			color="blue">g</font>
	</p>

	<%@include file="includes/navigation.jsp"%>

<!-- 	<div class="container"> -->
<!-- 		<h1 class="text-center pagination-centered"> -->
<%-- 			${randomJunk.subject} ${randomJunk.verb} ${randomJunk.complement}</h1> --%>
<!-- 	</div> -->

	<div id="schlagzeile">
		<p>${randomJunk.subject} ${randomJunk.verb}
			${randomJunk.complement}
		<p>
	</div>

<!-- 	<div id="schlagzeile2"> -->
<%-- 		<p>${randomJunk.subject}${randomJunk.verb} --%>
<%-- 			${randomJunk.complement} --%>
<!-- 		<p> -->
<!-- 	</div> -->
</body>
</html>