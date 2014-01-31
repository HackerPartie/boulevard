<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="hacker.partie.model.Sentence" %>	

<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link href='http://fonts.googleapis.com/css?family=Bree+Serif'
	rel='stylesheet' type='text/css'>
	<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

	<style type="text/css">
		html,body {
			background: #f06a1c;
			
		}

		h1 {
			font-size: 75px !important;
			font-family: 'Bree Serif', serif;						
		}
		

	</style>

	<title>Es gilt die Umschuldsvermutung</title>
</head>

<body>
	<div class="container">
		<h1 class="text-center pagination-centered" >		
		${randomJunk.object}
		${randomJunk.verb}
		${randomJunk.complement}		
		</h1>		
	</div>
</body>
</html>