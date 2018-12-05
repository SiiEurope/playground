<%@ page contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="robots" content="noindex, nofollow">

	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
		  crossorigin="anonymous">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/main.css">

	<link rel="shortcut icon" href="<%=request.getContextPath()%>/public/pics/favicon.ico">

	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
			crossorigin="anonymous"></script>

	<title>Playground</title>
</head>
<body>

<nav class="navbar navbar-light bg-light sii-main-navbar">
	<a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp" style="font-size:36px;line-height:30px;">
		<img src="<%=request.getContextPath()%>/public/pics/logo-sii.png" height="30" class="d-inline-block align-bottom" alt="">
		Playground
	</a>
</nav>

<div class="container" style="margin-top:24px">
	<div class="alert alert-danger" role="alert">
		<%=request.getAttribute("error")%>
	</div>
</div>

</body>
</html>
