<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="includes/common-header.jsp" />
<title>List all sentences</title>


</head>
<body>
    <jsp:include page="includes/navigation.jsp" />
    <h3>Top 10</h3>
    <c:if test="${not empty listAll}">
    <table class="table table-striped">
        <c:forEach items="${listAll}" var="favourite">
            <tr>
                <td>${favourite.sentence.subject}</td>
                <td>${favourite.sentence.verb}</td>
                <td>${favourite.sentence.complement}</td>
                <td>${favourite.score}</td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
</body>
</html>