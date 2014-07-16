<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="includes/common-header.jsp" />
<title>Mein Österreich ist ur org: Das Boulevard Titelblatt Generator</title>
</head>

<body>
	<jsp:include page="includes/navigation.jsp" />
	<p id="logo_pic" align="center">
	<a href="/titelblatt">
		<img src="papercutlogo.png" alt="Österreich ist-ur.org" align="middle" />
	</a>		
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