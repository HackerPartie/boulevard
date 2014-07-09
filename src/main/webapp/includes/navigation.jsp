<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<a class="navbar-brand" href="/titelblatt">Meine zeitung ist ur
				org</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${not empty sessionScope.sessionUser}">
						<li><a href="/private/add">Add Headline</a></li>
						<li><a href="/private/listall">List Headlines</a></li>
						<li><a href="#">logged in as ${sessionScope.sessionUser}</a></li>
						<li><a href="/logout">Logout</a>
					</c:when>
					<c:otherwise>
						<li><a href="login">login</a></li>
						<!-- <li><a href="register">register</a></li> -->
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>
