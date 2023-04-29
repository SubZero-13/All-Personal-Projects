<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="com.nagarro.entities.*"%>
<%@page import="com.nagarro.enums.*"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
#not-found-msg {
	display: block;
	width: 35%;
	margin: 0 auto;
	color: red;
	font-size: 24px;
}
</style>

</head>

<body>

	<!-- to prevent access before login and to prevent going back after logout-->
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (session.getAttribute("username") == null)
			response.sendRedirect("login.jsp");
	%>
	<div class="container-fluid">
		<div
			class="fixed-header d-flex justify-content-between align-items-center bg-dark text-light p-3">
			<div class="text-center">
				<h2>
					<b>Search Your Favorite T-shirts</b>
				</h2>
			</div>
			<div class="text-right">
				<form action="Logout" method="post">
					Hi
					<%=session.getAttribute("username")%>&nbsp;&nbsp; <input
						type="submit" class="btn btn-danger" value="Logout">
				</form>
			</div>
		</div>
		<div class="row justify-content-center mt-5">
			<div class="main-content col-md-6 mt-4 p-4 rounded shadow-lg">
				<form action="Search" method="post">
					<div class="form-group row">
						<label for="Color"
							class="col-md-2 col-form-label text-md-end font-weight-bold">Color:</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="Color" name="colour">
						</div>
					</div>
					<div class="form-group row">
						<fieldset class="row mb-3">
							<legend class="col-md-2 col-form-label pt-0 font-weight-bold"
								style="margin-left: 1.3rem;">Size:</legend>
							<div class="col-md-8" style="margin-left: 1.5rem;">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="size" id="S"
										value="S" checked> <label class="form-check-label"
										for="S" style="font-weight: bold;">S</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="size" id="M"
										value="M"> <label class="form-check-label" for="M"
										style="font-weight: bold;">M</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="size" id="L"
										value="L"> <label class="form-check-label" for="L"
										style="font-weight: bold;">L</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="size"
										id="XL" value="XL"> <label class="form-check-label"
										for="XL" style="font-weight: bold;">XL</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="size"
										id="XXL" value="XXL"> <label class="form-check-label"
										for="XXL" style="font-weight: bold;">XXL</label>
								</div>
							</div>
						</fieldset>

						<fieldset class="row mb-3">
							<legend class="col-form-label col-2 pt-0 mx-4 font-weight-bold">Gender:</legend>
							<div class="col-sm-8">
								<div class="form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="MaleGender" value="M" checked> <label
										class="form-check-label" for="MaleGender">M</label>
								</div>
								<div class="form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="FemaleGender" value="F"> <label
										class="form-check-label" for="FemaleGender">F</label>
								</div>
								<div class="form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="OtherGender" value="U"> <label
										class="form-check-label" for="OtherGender">U</label>
								</div>
							</div>
						</fieldset>

						<fieldset class="row mb-3">
							<legend class="col-form-label col-2 pt-0 mx-4 font-weight-bold">Output
								Preference</legend>
							<div class="col-sm-8">
								<div class="form-check-inline">
									<input class="form-check-input" type="radio"
										name="outputPreference" id="PriceRadio" value="1" checked>
									<label class="form-check-label" for="PriceRadio">Price</label>
								</div>
								<div class="form-check-inline">
									<input class="form-check-input" type="radio"
										name="outputPreference" id="RatingRadio" value="2"> <label
										class="form-check-label" for="RatingRadio">Rating</label>
								</div>
								<div class="form-check-inline">
									<input class="form-check-input" type="radio"
										name="outputPreference" id="BothRadio" value="3"> <label
										class="form-check-label" for="BothRadio">Both</label>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-12">
						<!-- <input type="submit" value="Search" id="btn"> -->
						<input type="submit" class="btn btn-danger" value="Search">

					</div>
				</form>
			</div>
		</div>
		<br> <br>

		<!-- table creation -->
		<table class="table table-bordered" id="tshirtTable">
			<c:if test="${not empty tshirts}">
				<%
					List<Tshirt> tshirts = (List<Tshirt>) session.getAttribute("tshirts");
						if (tshirts != null && tshirts.size() != 0) {
				%>
				<thead>
					<tr>
						<th scope="col" class="text-center">S.No</th>
						<th scope="col" class="text-center">Id</th>
						<th scope="col" class="text-center">Name</th>
						<th scope="col" class="text-center">Color</th>
						<th scope="col" class="text-center">Gender</th>
						<th scope="col" class="text-center">Size</th>
						<th scope="col" class="text-center">Price</th>
						<th scope="col" class="text-center">Rating</th>
					</tr>
				</thead>
				<tbody>

					<!--display data from database -->
					<%
						int i = 1;
								for (Tshirt tshirt : tshirts) {
					%>
					<tr>
						<th scope="row"
							style="text-align: center; vertical-align: middle;"><%=i++%></th>

						<td style="text-align: center; vertical-align: middle;"><%=tshirt.getId()%></td>
						<td style="text-align: center; vertical-align: middle;"><%=tshirt.getName()%></td>
						<td style="text-align: center; vertical-align: middle;"><%=tshirt.getColor()%></td>
						<td style="text-align: center; vertical-align: middle;"><%=tshirt.getGender()%></td>
						<td style="text-align: center; vertical-align: middle;"><%=tshirt.getSize()%></td>
						<td style="text-align: center; vertical-align: middle;"><%=tshirt.getPrice()%></td>
						<td style="text-align: center; vertical-align: middle;"><%=tshirt.getRating()%></td>
					</tr>
					<%
						}
							}
					%>
				
			</c:if>
			</tbody>
		</table>
		<c:if test="${empty tshirts}">
			<div id="not-found-msg">
				<p>T-shirt not Available. Find Other Tshirts</p>
			</div>
		</c:if>
	</div>
	<script>
		
	</script>
</body>
</html>