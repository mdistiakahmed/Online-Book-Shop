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
				<jsp:include page="show_all_book.jsp"></jsp:include>
				
			</div>
				

		</div>

	</div>


	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>

<%  //<td><img src="${pageContext.request.contextPath}/image?code=${book.bookId}" width="100"/></td> %>


