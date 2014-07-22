<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../includes/common-header.jsp" />
<title>List all sentences</title>
<script>
    function del(urlToDelete) {
        $.ajax({
            url : urlToDelete,
            type : 'DELETE',
            success : function(results) {
                // Refresh the page
                location.reload();
            }
        });
    }
</script>

</head>
<body>
    <jsp:include page="../includes/navigation.jsp" />
    <h3>
        Alle
        <c:out value="${fn:length(listAll)}" />
        Sätze von Model Name : Name - Partizip
    </h3>
    <table class="table table-striped">
        <c:set var="count" value="1" scope="page" />
        <c:forEach items="${listAll}" var="sentence">
            <tr>

                <td>${pageScope.count}</td>
                <td>${sentence.subject}</td>
                <td>${sentence.verb}</td>
                <td>${sentence.complement}</td>
                <td><a onclick="del('nnpadmin?id=${sentence.id}')">
                        <button type="button" class="btn">
                            <span class="glyphicon glyphicon-trash"></span> Delete
                        </button>
                </a></td>
            </tr>
            <c:set var="count" value="${count + 1}" scope="page" />
        </c:forEach>
    </table>
    <h3>Einen Satz hinzufügen</h3>
    <form action="${pageContext.request.contextPath}/private/nnpadmin" method="post">
        <input type="text" name="subject" placeholder="Subjekt"> <input type="text" name="verb" placeholder="Verb">
        <input type="text" name="complement" placeholder="Ergänzung">
        <button type="submit" class="btn btn-default">Zur Sätzenliste hinzufügen</button>
    </form>
</body>
</html>