<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet"
          href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
    <link href='http://fonts.googleapis.com/css?family=Bree+Serif'
          rel='stylesheet' type='text/css'>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script
            src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>



    <title>Es gilt die Umschuldsvermutung</title>
</head>

<body>
<jsp:include page="includes/navigation.jsp" />

<div class="container">
    ${error}
    ${message}
    <h4> login </h4>
    <br>
    <div class="form-group" style="width: 200px">
        <form action="login" method="post" class="form-horizontal">

            <input type="text" name="username" class="form-control" placeholder="username"><br>
            <input type="password" name="password" class="form-control" placeholder="password"><br>

            <button type="submit" class="btn btn-default">Submit</button>

        </form>
    </div>
</div>

</body>
</html>
