<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList "%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/styles.css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%
	/*mobile fitting and zooming*/
%>
<meta name="description" content="">
<meta name="author" content="">

<title>Book Shopping</title>

<!-- Bootstrap Core CSS -->
<link href="resources/bootstrap.min.css" rel="stylesheet">

<link href="resources/shop-homepage.css" rel="stylesheet">




<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>


<body>

	<c:if test="${not empty shopid}">
		<c:forEach items="${bookList}" var="book">

			<c:if test="${book.storeId==shopid}">

				<div class="col-lg-4 col-lg-4 col-lg-4">
					<div class="thumbnail">
						<p>ID: ${book.bookId}</p>
						<img
							src="${pageContext.request.contextPath}/image?id=${book.bookId}"
							class="img-thumbnail" alt="Cinque Terre"
							style="min-height: 400px; height: 400px;">
						<div class="caption">
							<p>Name: ${book.name}</p>
							<p>Author:${book.author}</p>
							<p>Price:${book.price}</p>
							<a
								href="${pageContext.request.contextPath}/showProduct?code=${book.bookId}">Buy
								Now</a>
								<a
									href="${pageContext.request.contextPath}/showProduct?code=${book.bookId}">Delete</a>
						</div>
					</div>
				</div>
			</c:if>

		</c:forEach>
	</c:if>


	<c:if test="${empty shopid}">

		<c:forEach items="${bookList}" var="book">

			<div class="col-lg-4 col-lg-4 col-lg-4">
				<div class="thumbnail">
					<p>ID: ${book.bookId}</p>
					<img
						src="${pageContext.request.contextPath}/image?id=${book.bookId}"
						class="img-thumbnail" alt="Cinque Terre"
						style="min-height: 400px; height: 400px;">
					<div class="caption">
						<p>Name: ${book.name}</p>
						<p>Author:${book.author}</p>
						<p>Price:${book.price}</p>
						<a
							href="${pageContext.request.contextPath}/showProduct?code=${book.bookId}">Buy
							Now</a>

						<c:if test="${role=='admin'}">
							<a
								href="${pageContext.request.contextPath}/showProduct?code=${book.bookId}">Delete</a>
						</c:if>
					</div>
				</div>
			</div>

		</c:forEach>

	</c:if>


</body>

</html>