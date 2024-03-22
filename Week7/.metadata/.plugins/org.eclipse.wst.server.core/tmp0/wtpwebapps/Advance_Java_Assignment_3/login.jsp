<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login: Nagarro</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<style>
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
	width: 100px;
	margin-left: 90%;
}

.error-message {
	color: red;
	margin-left: 10px;
}

.required-field::before {
	content: "*";
	color: red;
	margin-left: 200px;
}
</style>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	%>
	<form action="Login" method="post" onsubmit="return validateForm()">
		<div class="fw-bolder fs-2 background color ">
			<!-- <hr/> -->
			<p class="mx-3">Login</p>
			<hr />
		</div>
		<div>
			<div class="d-flex mb-4">
				<p class="ms-4 fw-bolder fs-5">Username</p>
				<p class="required-field">
					<input type="text" name="uname" id="uname" class=" margins height">
					<span id="unameError" class="error-message"></span>
					<%
						if (request.getAttribute("errorMessage") != null) {
					%>
					<span id="loginError" class="error-message"> <%=request.getAttribute("errorMessage")%>
					</span>
					<%
						}
					%>
				</p>
			</div>
			<div class="d-flex mb-4">
				<p class="ms-4 fw-bolder fs-5 height">Password&nbsp;</p>
				<p class="required-field">
					<input type="password" name="pass" id="pass"
						class=" margins height"> <span id="passError"
						class="error-message"></span>
				</p>
			</div>

			<a href="ForgetPassword.jsp" class="space"> Forgotten Your
				Password? </a> <br /> <br /> <a href="register.jsp" class="space">
				New user? </a>
		</div>
		<div class="background ">
			<hr />
			<button type="submit"
				class="wid border border-dark fw-bold border-2 rounded">Login
				&gt;&gt;</button>
			<hr />
		</div>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
	<script>
		function validateForm() {
			resetErrorMessage();
			// Get form inputs
			var uname = document.getElementById("uname").value;
			var pass = document.getElementById("pass").value;

			// Validate username
			if (uname === "") {
				document.getElementById("unameError").innerHTML = "Please enter a username";
				return false;
			} else {
				document.getElementById("unameError").innerHTML = "";
			}

			// Validate password
			if (pass === "") {
				document.getElementById("passError").innerHTML = "Please enter a password";
				return false;
			} else {
				document.getElementById("passError").innerHTML = "";
			}

			var loginError = document.getElementById("loginError").textContent;
			if (loginError.trim() !== "") {
				return false;
			} else {
				resetErrorMessage();
			}

			// If both inputs are valid, submit the form
			return true;
		}

		function resetErrorMessage() {
			document.getElementById("loginError").innerHTML = "";
		}
	</script>
</body>
</html>