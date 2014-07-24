<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="includes/common-header.jsp" />
<title>Mein Österreich ist ur org: Die Top 10</title>
</head>
<body>
	<jsp:include page="includes/navigation.jsp" />
	<c:if test="${not empty listAll}">
		<div class="top10_member">
			<table class="table table-striped">
				<tr>
					<th>Mein Österreich ist ur org: Die Top 10</th>
					<th>Stimmen</th>
				</tr>
				<c:forEach items="${listAll}" var="favourite">
					<tr>
						<td><c:out value="${favourite.sentence.subject}" /> <c:out
								value="${favourite.sentence.verb}" /> <c:out
								value="${favourite.sentence.complement}" /></td>
						<td><c:out value="${favourite.score}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>