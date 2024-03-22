<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register: Nagarro</title>
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

.form-control:focus {
	border-color: #00308F;
	box-shadow: 0 0 0 0.25rem rgba(0, 48, 143, 0.25);
}

.error-message {
	color: red;
	font-size: 12px;
	margin-top: 5px;
}

.required-field::before {
	content: "*";
	color: red;
	margin-right: 5px;
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

.space {
	text-decoration: none;
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
</style>
</head>
<body>
	<div class="container">
		<form action="Register" method="post" onsubmit="return validateForm()">
			<h1 class="text-center mb-4">
				<img
					src="https://companieslogo.com/img/orig/NA9.DE-ebeff140.png?t=1664248024"
					alt="Logo" id="logo"> Register
			</h1>
			<div class="mb-3">
				<label for="uname" class="form-label required-field">Username</label>
				<input type="text" name="uname" id="uname" class="form-control"
					required> <span id="unameError" class="error-message"></span>
			</div>
			<div class="mb-3">
				<label for="pass" class="form-label required-field">Password</label>
				<input type="password" name="pass" id="pass" class="form-control"
					required> <span id="passError" class="error-message"></span>
			</div>
			<button type="submit" class="register-btn">Register</button>
		</form>
		<br> <a href="login.jsp" class="space"> Already a user? </a>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>
