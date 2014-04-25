<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="hacker.partie.model.Sentence"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/common-header.jsp"%>
<title>List all sentences</title>
</head>
<body>
	<%@include file="includes/navigation.jsp"%>
	<h3>List all sentences</h3>
	<table class="table table-bordered">
		<c:forEach items="${listAll}" var="sentence">
			<tr>
				<td><c:out
						value="${sentence.subject} ${sentence.verb} ${sentence.complement}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>