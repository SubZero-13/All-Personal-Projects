<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Forget Password</title>
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

h1 {
	display: flex;
	align-items: center;
}

.error-message {
	color: red;
}

.required-field::before {
	content: "*";
	color: red;
	margin-left: 5px;
}

.background {
	background-color: #C6E6FB;
	border-radius: 10px;
	padding: 40px;
	margin-top: 50px;
}

.color {
	color: #00308F;
}

.marg {
	margin-left: 5%;
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
	margin-right: 5px;
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
	padding: 8px 16px;
	border-radius: 5px;
	cursor: pointer;
	margin-top: 20px;
	transition: background-color 0.3s ease;
	margin-left: 0.8rem;
}

.register-btn:hover {
	background-color: #00227A;
}
</style>
</head>
<body>
	<div class="container">
		<form action="Forget" method="post">
			<div class="background">
				<h1 class="mx-3">
					<img
						src="https://companieslogo.com/img/orig/NA9.DE-ebeff140.png?t=1664248024"
						alt="Logo" id="logo"> Generate New Password
				</h1>
			</div>
			<div class="form-group d-flex mb-3">
				<label for="uname" class="form-label required-field">Username
				</label>&nbsp; &nbsp; <input type="text" name="uname" id="uname"
					class="form-control" required> <span id="unameError"
					class="error-message"></span>
			</div>
			<div class="form-group d-flex mb-3">
				<label for="pass" class="form-label required-field">Password
				</label>&nbsp; &nbsp; <input type="password" name="pass" id="pass"
					class="form-control" required> <span id="passError"
					class="error-message"></span>
			</div>
			<button type="submit" class=" register-btn">Update Password</button>
		</form>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
			crossorigin="anonymous"></script>
</body>
</html>