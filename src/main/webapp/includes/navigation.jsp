<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>  
<nav class="navbar navbar-default navbar-fixed-bottom">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="${context}/titelblatt" class="btn btn-success btn-lg">Titelblatt Generieren</a>
                <c:if test="${not empty randomJunk}">
                <label for="submit-form"><span class="btn btn-info btn-lg">Für die Top 10 wählen</span></label>
                </c:if>
            <a href="${context}/top10" class="btn btn-primary btn-lg">Top 10 Anschauen</a>    
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${not empty sessionScope.sessionUser}">
						<li><a href="${context}/private/svcadmin">Edit SVC headlines</a></li>
                        <li><a href="${context}/private/nnpadmin">Edit NNP headlines</a></li>
						<li><a href="#">logged in as ${sessionScope.sessionUser}</a></li>
						<li><a href="${context}/logout">Logout</a>
					</c:when>
					<c:otherwise>
						<li><a href="${context}/login">login</a></li>
						<!-- <li><a href="register">register</a></li> -->
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>
