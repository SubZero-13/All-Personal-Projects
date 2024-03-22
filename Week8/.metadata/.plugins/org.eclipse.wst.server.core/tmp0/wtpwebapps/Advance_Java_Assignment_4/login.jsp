<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login: Nagarro</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<style>
body {
	background-color: #BCD4E6;
}

.container {
	background-color: #C6E6FB;
	border-radius: 10px;
	padding: 40px;
	margin-top: 50px;
}

.form-control:focus {
	border-color: #00308F;
	box-shadow: 0 0 0 0.25rem rgba(0, 48, 143, 0.25);
}

.error-message {
	color: red;
}

.required-field::before {
	content: "*";
	color: red;
	margin-right: 5px;
}
h1 {
	display: flex;
	align-items: center;
}

#logo {
	width: 50px;
	height: 50px;
	margin-right: 10px;
}
.register-btn {
	background-color: #00308F;
	color: #FFFFFF;
	border: none;
	font-size: 16px;
	font-weight: bold;
	padding: 12px 24px;
	border-radius: 5px;
	cursor: pointer;
	margin-top: 20px;
	transition: background-color 0.3s ease;
}

.register-btn:hover {
	background-color: #00227A;
}
</style>
</head>
<body>
	<div class="container">
		<form action="Login" method="post" onsubmit="return validateForm()">
			<h1 class="text-center mb-4">
				<img
					src="https://companieslogo.com/img/orig/NA9.DE-ebeff140.png?t=1664248024"
					alt="Logo" id="logo">Login
			</h1>
			<div class="mb-3">
				<label for="uname" class="form-label required-field">Username</label>
				<input type="text" name="uname" id="uname" class="form-control"
					required> <span id="unameError" class="error-message"></span>
				<%
					if (request.getAttribute("errorMessage") != null) {
				%>
				<span id="loginError" class="error-message"><%=request.getAttribute("errorMessage")%></span>
				<%
					}
				%>
			</div>
			<div class="mb-3">
				<label for="pass" class="form-label required-field">Password</label>
				<input type="password" name="pass" id="pass" class="form-control"
					required> <span id="passError" class="error-message"></span>
			</div>
			<div class="mb-3">
				<a href="forgetPassword.jsp" class="text-decoration-none">Forgotten
					your password?</a>
			</div>
			<button type="submit" class="btn btn-primary btn-block register-btn">Login</button>
			<div class="mt-3 text-center">
				<p>
					Not a member? <a href="register.jsp" class="text-decoration-none">Register</a>
				</p>
			</div>
		</form>
	</div>
	<!-- Bootstrap JS -->
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
			return true;
		}

		function resetErrorMessage() {
			document.getElementById("loginError").innerHTML = "";
		}
	</script>
</body>
</html>