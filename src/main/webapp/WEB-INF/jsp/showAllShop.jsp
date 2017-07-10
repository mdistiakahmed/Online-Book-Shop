<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>

<html>
<head>
<title>Book Store</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
body {
	background-color: red;
}
</style>

</head>

<jsp:include page="header3.jsp"></jsp:include>
<body>


	<div class="container">
				<h2>Registered Shop List</h2>
				<hr>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Shop Id</th>
							<th>Manager Name/Shop Name</th>
							<th>Remove</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${shopList}" var="shop">
							<tr>
								<td>${shop.shopid}</td>
								<td>${shop.managername}</td>
								<td><a
									href="${pageContext.request.contextPath}/removeShop?name=${shop.managername}">remove</a></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>

	</div>


	<br>
	<br>



</body>
<jsp:include page="_footer.jsp"></jsp:include>
</html>



