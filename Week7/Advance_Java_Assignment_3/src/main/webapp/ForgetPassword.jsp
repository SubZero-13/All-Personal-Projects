<!Doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Forget Password</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<style>
.marg {
	margin-left: 5%;
}

.background {
	background-color: #BCD4E6;
}

.color {
	color: #00308F;
}

.space {
	margin-left: 22%;
}

.formBackground {
	background-color: #C6E6FB;
}

.height {
	height: 80%;
}

.wid {
	width: 10%;
	margin-left: 85%;
}

.required-field::before {
	content: "*";
	color: red;
	margin-left: 200px;
}

@media only screen and (max-width: 500px) {
	.wid {
		width: 45%;
		margin-left: 50%;
	}
	.required-field::before {
		content: "*";
		color: red;
		margin-left: 20px;
	}
}

@media only screen and (max-width: 338px) {
	.margins {
		width: 60%;
	}
}
</style>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	%>
	<form action="Forget" method="post">
		<div class="fw-bolder fs-2 background color ">
			<!-- <hr/> -->
			<p class="mx-3">Generate New Password</p>
			<hr />
		</div>
		<div>

			<div class="d-flex mb-4">
				<p class="ms-4 fw-bolder fs-md-5">Username</p>
				<p class="required-field marg">
					<input type="text" name="uname" class=" margins height">
				</p>
			</div>
			<div class="d-flex mb-4">
				<p class="ms-4 fw-bolder fs-md-5 height">Enter new Password</p>
				<p class="required-field">
					<input type="password" name="pass" class=" margins height">
				</p>
			</div>

		</div>
		<div class="background ">
			<hr />
			<button type="submit"
				class="wid border border-dark fw-bold border-2 rounded">Update
				New Password &gt;&gt;</button>
			<hr />
		</div>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>