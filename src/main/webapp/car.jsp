<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.sii.playground.web.ServletUtils" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="robots" content="noindex, nofollow">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
		  crossorigin="anonymous">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/sii-muster.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

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

<%
	Map<String, List<String>> fieldErrors=(Map<String, List<String>>) request.getAttribute("fieldErrors");
	if (fieldErrors==null) fieldErrors=new HashMap<>();
	Object manufacturer=request.getAttribute("manufacturer");
	Object model=request.getAttribute("model");
	Object yearBuilt=request.getAttribute("yearBuilt");
	Object milage=request.getAttribute("milage");
%>

<div class="container shadow" style="margin-top:24px;padding:24px;">
	<h3>Car</h3>
	<form action="car" method="post">
		<input type="hidden" name="id" value="<%=ServletUtils.property(request.getParameter("id"))%>">
		<input type="hidden" name="create" value="<%=ServletUtils.property(request.getParameter("create"))%>">
		<div class="form-group">
			<label for="inputManufacturer">Manufacturer</label>
			<input type="text" class="form-control <%=fieldErrors.containsKey("manufacturer") ? "is-invalid" : ""%>" id="inputManufacturer" name="manufacturer"
				   value="<%=ServletUtils.property(manufacturer)%>">
			<%
				if (fieldErrors.containsKey("manufacturer"))
				{
					out.print("<div class=\"invalid-feedback\">");
					for (String error : fieldErrors.get("manufacturer")) out.println(ServletUtils.property(error));
					out.print("</div>");
				}
			%>
		</div>
		<div class="form-group">
			<label for="inputModel">Model</label>
			<input type="text" class="form-control <%=fieldErrors.containsKey("model") ? "is-invalid" : ""%>" id="inputModel" name="model" value="<%=ServletUtils.property(model)%>">
			<%
				if (fieldErrors.containsKey("model"))
				{
					out.print("<div class=\"invalid-feedback\">");
					for (String error : fieldErrors.get("model")) out.println(ServletUtils.property(error));
					out.print("</div>");
				}
			%>
		</div>
		<div class="row">
			<div class="form-group col-md-4">
				<label for="inputYear">Year of Production</label>
				<input type="text" class="form-control <%=fieldErrors.containsKey("yearBuilt") ? "is-invalid" : ""%>" id="inputYear" name="yearBuilt" value="<%=ServletUtils.property(yearBuilt)%>">
				<%
					if (fieldErrors.containsKey("yearBuilt"))
					{
						out.print("<div class=\"invalid-feedback\">");
						for (String error : fieldErrors.get("yearBuilt")) out.println(ServletUtils.property(error));
						out.print("</div>");
					}
				%>
			</div>
			<div class="form-group col-md-4">
				<label for="inputKm">Milage</label>
				<div class="input-group mb-3">
					<input type="text" class="form-control <%=fieldErrors.containsKey("milage") ? "is-invalid" : ""%>" id="inputKm" name="milage" value="<%=ServletUtils.property(milage)%>">
					<div class="input-group-append">
						<span class="input-group-text">km</span>
					</div>
					<%
						if (fieldErrors.containsKey("milage"))
						{
							out.print("<div class=\"invalid-feedback\">");
							for (String error : fieldErrors.get("milage")) out.println(ServletUtils.property(error));
							out.print("</div>");
						}
					%>
				</div>
			</div>
		</div>
		<div>
			<button type="submit" class="btn btn-primary mr-2"><i class="material-icons">done</i> Save</button>
			<button type="button" class="btn btn-secondary" onclick="window.location='index.jsp'"><i class="material-icons">clear</i> Cancel</button>
		</div>
	</form>

</div>

</body>
</html>
