<!DOCTYPE html>
<html>
<head>
<jsp:include page="../includes/common-header.jsp" />
<title>Add an original sentence here</title>
</head>
<body>
	<jsp:include page="../includes/navigation.jsp" />
	<h3> Einen Satz hinzuf�gen</h3>
	<form action="add" method="post" class="form-inline">
	<input type="text" class="form-control" name="subject" placeholder="Subjekt">
	<input type="text" class="form-control" name="verb" placeholder="Verb">
	<input type="text" class="form-control" name="complement" placeholder="Erg�nzung">
	<button type="submit" class="btn btn-default"> Zur S�tzenliste hinzuf�gen</button>
	</form>
</body>
</html>