<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>
</head>



<jsp:include page="header3.jsp"></jsp:include>
<body>
	<c:if test="${not empty shopid}">
		<h1>Orders for Shop no : ${shopid}</h1>
	</c:if>

	<c:if test="${empty shopid}">
		<h1>All Orders</h1>
	</c:if>
	<br>

	<div class="container">
		<c:if test="${not empty shopid}">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Order Id</th>
						<th>Book Id</th>
						<th>User name</th>
						<th>Remove</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderList}" var="order">
						<c:if test="${order.shopid==shopid}">
							<tr>
								<td>${order.orderid}</td>
								<td><a
									href="${pageContext.request.contextPath}/showProduct?code=${order.bookid}">
										${order.bookid} </a></td>
								<td>${order.username}</td>
								<td><a
									href="${pageContext.request.contextPath}/removeOrder?code=${order.orderid}">remove</a></td>
							</tr>
						</c:if>
					</c:forEach>


				</tbody>
			</table>

		</c:if>

		<c:if test="${empty shopid}">

			<table class="table table-hover">
				<thead>
					<tr>
						<th>Order Id</th>
						<th>Shop Id</th>
						<th>Book Id</th>
						<th>User name</th>
						<th>Remove</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderList}" var="order">
						<tr>
							<td>${order.orderid}</td>
							<td>${order.shopid}</td>
							<td><a
								href="${pageContext.request.contextPath}/showProduct?code=${order.bookid}">
									${order.bookid} </a></td>
							<td>${order.username}</td>
							<td><a
								href="${pageContext.request.contextPath}/removeOrder?code=${order.orderid}">remove</a></td>
						</tr>

					</c:forEach>


				</tbody>
			</table>

		</c:if>





	</div>


	<br>
	<br>



</body>
<jsp:include page="_footer.jsp"></jsp:include>



</html>



