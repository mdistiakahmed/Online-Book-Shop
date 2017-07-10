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
				<h4>MyCart</h4>
				</br>

				<c:if test="${empty myCart.cartLines}">

					<h4>Cart List is empty</h4>
				</c:if>




				<c:forEach items="${myCart.cartLines}" var="cartLineInfo">

					<div class="col-lg-4 col-lg-4 col-lg-4">
						<div class="thumbnail">
							<img
								src="${pageContext.request.contextPath}/image?id=${cartLineInfo.getProductInfo().bookId}"
								class="img-thumbnail" alt="Cinque Terre"
								style="min-height: 400px; height: 400px;">
							<div class="caption">
								<h4>Name: ${cartLineInfo.getProductInfo().name}</h4>
								<h4>Quantity: ${cartLineInfo.quantity}</h4>
								<h4>Total prize: ${cartLineInfo.getAmount()} TK</h4>
								<a
									href="${pageContext.request.contextPath}/removeFromCart?code=${cartLineInfo.getProductInfo().bookId}">Remove</a>
							</div>


						</div>
					</div>

				</c:forEach>



			</div>

			<c:if test="${not empty myCart.cartLines}">
				<a href="submitCart" class="btn btn-info btn-lg"> <span
					class="glyphicon glyphicon-send"></span> Send Order
				</a>
			</c:if>

		</div>

	</div>


	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>

<%
	//<td><img src="${pageContext.request.contextPath}/image?code=${book.bookId}" width="100"/></td>
%>


