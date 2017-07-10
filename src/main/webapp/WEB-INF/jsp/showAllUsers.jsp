<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>
</head>


<jsp:include page="header3.jsp"></jsp:include>
<body>


	<div class="container">
		<h2>Registered User List</h2>
		<hr>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>User Name</th>
					<th>Remove</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${accountList}" var="account">

					<c:if test="${account.role=='user'}">
						<tr>
							<td>${account.userName}</td>
							<td><a
								href="${pageContext.request.contextPath}/removeUser?name=${account.userName}">remove</a></td>
						</tr>

					</c:if>
				</c:forEach>


			</tbody>
		</table>

	</div>


	<br>
	<br>



</body>
<jsp:include page="_footer.jsp"></jsp:include>
</html>



