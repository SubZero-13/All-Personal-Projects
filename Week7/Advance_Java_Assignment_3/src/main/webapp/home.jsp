<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.nagarro.models.Product"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE>
<html>

<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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
		<div class="fixed-header">
			<div id="title" style="text-align: center;">
				<h2>
					<b>Product Management Tool</b>
				</h2>
			</div>
			<div id="title" style="text-align: right;">
				<form action="Logout" method="post">
					Hi
					<%=session.getAttribute("username")%>&nbsp; &nbsp; <input
						type="submit" value="Logout">
				</form>
			</div>
			<b>Please Enter Product Details To Enter To Stock</b>
		</div>
		<div class="row">

			<div class="main-content col-6">
				<form action="save" method="post" enctype="multipart/form-data">
					<div class="m-3 row">
						<label for="Title" class="col-2">Title</label> <input type="text"
							class="col-4" id="Title" name="title">

					</div>
					<div class="m-3 row">
						<label for="Quantity" class="col-2">Quantity</label> <input
							type="text" class="col-4" id="Quantity" name="quantity">

					</div>
					<div class="m-3 row">
						<label for="Size" class="col-2">Size</label> <input type="text"
							class="col-4" id="Size" name="size">

					</div>
					<div class="m-3 row">
						<label for="Image" class="col-2">Image</label> <input type="file"
							id="image" class="col-4" name="image"
							accept="image/x-png,image/gif,image/jpeg,image/jpg">
					</div>


					<div class="col-12 m-3">
						<input type="submit" value="Save">
					</div>
				</form>
			</div>

		</div>

		<!-- table creation -->
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col" class="text-center">S.No</th>
					<th scope="col" class="text-center">Title</th>
					<th scope="col" class="text-center">Quantity</th>
					<th scope="col" class="text-center">Size</th>
					<th scope="col" class="text-center">Image</th>
					<th scope="col" class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>

				<!--display data from database -->
				<%
					SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
							.buildSessionFactory();
					Session session2 = factory.openSession();

					String uname = (String) session.getAttribute("username");
					Query query;

					query = session2.createQuery("from Product where uname=:uname");

					query.setParameter("uname", uname);

					List<Product> products = (List<Product>) query.list();

					int i = 1;
					int totalSize = 0;
					for (Product product : products) {
						totalSize += product.getImageSize();
				%>
				<tr>
					<th scope="row" style="text-align: center; vertical-align: middle;"><%=i++%></th>

					<td style="text-align: center; vertical-align: middle;"><%=product.getTitle()%></td>
					<td style="text-align: center; vertical-align: middle;"><%=product.getQuantity()%></td>
					<td style="text-align: center; vertical-align: middle;"><%=product.getSize()%></td>
					<td style="text-align: center; vertical-align: middle;"><img
						src="image.jsp?title=<%=product.getTitle()%>" height="100px"
						width="100px" style="display: block; margin: 0 auto;" /></td>

					<td style="text-align: center; vertical-align: middle;"><a
						href="EditProduct.jsp?title=<%=product.getTitle()%>&quantity=<%=product.getQuantity()%>&size=<%=product.getSize()%> "
						class="  text-info "> <i class="glyphicon glyphicon-pencil"
							style="font-size: 24px;"></i></a>&nbsp; &nbsp;<a
						href="DeleteProduct?title=<%=product.getTitle()%>"
						class="  text-info "><i class="glyphicon glyphicon-remove"
							style="font-size: 24px; color: black;"></i></a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>


<!-- validation for image size not exceed above 1MB -->
<script type="text/javascript">
	$(document).ready(function() {
		maxfilesize = 1 * 1024 * 1024; //1mb
		$("#image").change(function() {
			fileSize = this.files[0].size;
			if (fileSize > maxfilesize) {
				this.setCustomValidity("Upload Image Size Less Than 1 MB");
				this.reportValidity();
			} else {
				this.setCustomValidity();
			}
		});
	});
</script>

</html>