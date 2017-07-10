<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>
</head>
<body>

	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<jsp:include page="_header.jsp"></jsp:include>
			<nav class="col-sm-2">
				<jsp:include page="_left_catagory.jsp"></jsp:include>
			</nav>

			<div class="col-sm-10">

				<div class="col-lg-4 col-lg-4 col-lg-4">
					<div class="thumbnail">
						<img
							src="${pageContext.request.contextPath}/image?id=${book.bookId}"
							class="img-thumbnail" alt="Cinque Terre"
							style="min-height: 400px; height: 400px;">

					</div>
				</div>

				<h4>Name  :  ${book.name}</h4>
				<h4>Author  :  ${book.author}</h4>
				<h4>Price  :  ${book.price}</h4>
				<h4>Publisher  :  ${book.publisher}</h4>
				<h4>Genra  :  ${book.genra}</h4>
				
				<p><a href="${pageContext.request.contextPath}/buyProduct?code=${book.bookId}">Buy Now</a></p>
				
				<c:if test="${role=='shop' || role=='admin'}">
					<p><a href="${pageContext.request.contextPath}/delete?code=${book.bookId}">Delete</a></p>
					
				</c:if>

			</div>

		</div>


		<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>

<%
	//<td><img src="${pageContext.request.contextPath}/image?code=${book.bookId}" width="100"/></td>
%>


