<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="includes/common-header.jsp" />
<jsp:include page="includes/homepage-javascript.jsp" />
<title>Mein Österreich ist ur org: Der Boulevard Titelblatt Generator</title>
</head>

<body>
    <jsp:include page="includes/navigation.jsp" />
    <p id="logo_pic" align="center">
        <a href="/titelblatt"> <img src="papercutlogo.png" alt="Österreich ist-ur.org" align="middle" />
        </a>
    <form method="post" action="top10">
        <h1 class="text-center pagination-centered">
            <input name="subject" value="${randomJunk.subject}" type="hidden"/> 
            <input name="verb" value="${randomJunk.verb}" type="hidden"/> 
            <input name="complement" value="${randomJunk.complement}" type="hidden"/>
            <input type="submit" id="submit-form" class="hidden"/>
            ${randomJunk.subject} ${randomJunk.verb} ${randomJunk.complement}
        </h1>
    </form>
    <c:if test="${not empty requestScope.welcomeMessage}">
        <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert">
                <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
            </button>
            ${welcomeMessage}
        </div>
    </c:if>
    <c:if test="${sessionScope.votes <= 5 and validVote}">
        <div class="alert alert-info alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert">
                <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
            </button>
            ${randomJunk.subject} ${randomJunk.verb} ${randomJunk.complement} wurde jetzt zu den Top10 hinzugefügt ! 
        </div>
    </c:if>
    
        <c:if test="${sessionScope.votes > 5 and not empty validVote and validVote == false}">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert">
                <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
            </button>
             Danke für deinen Enthusiasmus ! Du kannst Morgen wieder wählen.
        </div>
    </c:if>
</body>
</html>