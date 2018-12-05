<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="java.util.Collection" %>
<%@ page import="com.sii.playground.entities.CarManager" %>
<%@ page import="com.sii.playground.entities.Car" %>
<%@ page import="com.sii.playground.web.ServletUtils" %>

<!doctype html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="robots" content="noindex, nofollow">

	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
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

<div class="container shadow" style="margin:24px;padding:24px;">
	<h3>Overview</h3>
	<table class="table table-hover">
		<thead>
		<tr>
			<th scope="col">Manufacturer</th>
			<th scope="col">Model</th>
			<th scope="col">Year of Production</th>
			<th scope="col">Milage</th>
			<th>&nbsp;</th>
		</tr>
		</thead>
		<tbody>
		<%
			Collection<? extends Car> cars=CarManager.getInstance().getAll();
			for (Car car : cars)
			{
				%>
		<tr>
			<td><%=ServletUtils.property(car.getManufacturer())%></td>
			<td><%=ServletUtils.property(car.getModel())%></td>
			<td><%=ServletUtils.property(car.getYearBuilt())%></td>
			<td><%=car.getMilage()!=null ? ServletUtils.formatInt(car.getMilage(), request.getLocale())+"&nbsp;km" : "" %></td>
			<td>
				<a href="car?id=<%=car.getId()%>"><i class="material-icons">edit</i></a>
				<a href="delete-car?id=<%=car.getId()%>"><i class="material-icons">delete</i></a>
			</td>
		</tr>
		<%
			}
		%>
		</tbody>
	</table>
	<div>
		<button id="btn-new" type="button" onclick="window.location='car?create=true'" class="btn btn-primary"><i class="material-icons">add</i> New</button>
		<button id="btn-reset" type="button" onclick="window.location='reset'" class="btn btn-secondary"><i class="material-icons">undo</i> Reset</button>
	</div>

</div>

</body>
</html>
