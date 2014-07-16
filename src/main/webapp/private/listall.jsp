<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../includes/common-header.jsp" />
<title>List all sentences</title>
</head>
<body>
    <jsp:include page="../includes/navigation.jsp" />
    <h3>Alle Sätze von Model Subject - Verb - Complement</h3>
    <table class="table table-striped">
        <c:forEach items="${listAll}" var="sentence">
            <tr>
                <td>${sentence.subject}</td>
                <td>${sentence.verb}</td>
                <td>${sentence.complement}</td>
                <td>
                    <form action="/private/listall" method="post">
                        <input type="hidden" name="id" value="${sentence.id}"> <input type="submit" value="delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h3>Einen Satz hinzufügen</h3>
    <form action="add" method="post">
        <input type="text" name="subject" placeholder="Subjekt"> <input type="text" name="verb" placeholder="Verb">
        <input type="text" name="complement" placeholder="Ergänzung">
        <button type="submit" class="btn btn-default">Zur Sätzenliste hinzufügen</button>
    </form>
</body>
</html>