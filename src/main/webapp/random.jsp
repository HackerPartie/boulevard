<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="includes/common-header.jsp" />
<title>Mein Österreich ist ur org: Das Boulevard Titelblatt Generator</title>
<script>
    (function(i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function() {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o), m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js',
            'ga');

    ga('create', 'UA-3366813-3', 'auto');
    ga('send', 'pageview');
</script>
</head>

<body>
    <jsp:include page="includes/navigation.jsp" />
    <p id="logo_pic" align="center">
        <a href="/titelblatt"> <img src="papercutlogo.png" alt="Österreich ist-ur.org" align="middle" />
        </a>
    <form method="post" action="vote">
        <h1 class="text-center pagination-centered">
            <input name="subject" value="${randomJunk.subject}" type="hidden"/> 
            <input name="verb" value="${randomJunk.verb}" type="hidden"/> 
            <input name="complement" value="${randomJunk.complement}" type="hidden"/>
            <input type="submit" id="submit-form" class="hidden" type="hidden"/>
            ${randomJunk.subject} ${randomJunk.verb} ${randomJunk.complement}
        </h1>
    </form>
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