<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="hacker.partie.model.SvcSentence"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/common-header.jsp"%>
<title>List all sentences</title>
</head>
<body>
	<%@include file="../includes/navigation.jsp"%>
	<h3>Alle Sätze listen</h3>
	<table class="table table-bordered">
		<c:forEach items="${listAll}" var="sentence">
			<tr>
				<td><c:out value="${sentence.subject} ${sentence.verb} ${sentence.complement}" />
				</td>
				<td>
					<form action="/listall" method="post">
						<input type="hidden" name="id" value="${sentence.id}"> <input type="submit" value="delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>