<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="hacker.partie.model.SvcSentence"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="includes/common-header.jsp"%>
<title>Es gilt die Umschuldsvermutung</title>
</head>

<body>
	<p id="logo_pic" align="center">
		<img src="papercutlogo.png" alt="Österreich ist-ur.org" align="middle" />
		<%@include file="includes/navigation.jsp"%>
	<h1 class="text-center pagination-centered">${randomJunk.subject}
		${randomJunk.verb} ${randomJunk.complement}</h1>
	
	<c:if test="${not empty welcomeMessage}">
		<div class="alert alert-warning alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert">
				<span area-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			${welcomeMessage}
		</div>
	</c:if>
</body>
</html>