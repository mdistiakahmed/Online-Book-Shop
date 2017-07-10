<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
		<div class="container navbar-inner">


			<div class="navbar-header">
				<a href="home" class="btn btn-info btn-lg"> <span
					class="glyphicon glyphicon-home"></span> Home
				</a> <a class="navbar-brand text-muted" href="#">Online BookShop</a>
			</div>
			<div class="collapse navbar-collapse">

				<form  action ="search" method ="POST" class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search" name="bname">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>



				<ul class="nav navbar-nav navbar-right">
					<c:if test="${not empty user}">
						<li><a href="shoppingCart"><span class="glyphicon glyphicon-shopping-cart"></span>
								MyCart</a></li>
						<li><a href="#" class="btn btn-info btn-lg"> <span
								class="glyphicon glyphicon-user"></span> ${user}
						</a></li>
						<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>
								Logout</a></li>
						
					</c:if>
					<c:if test="${empty user}">

						<li><a href="/secondTry/signup"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a href="/secondTry/login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:if>

				</ul>
			</div>
		</div>
	</nav>


</body>

</html>