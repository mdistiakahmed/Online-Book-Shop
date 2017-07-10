<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>



<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	Catagory
	<br>
	<ul>

		<li><a href="catagoryScience">Science</a></li>
		<li><a href="catagoryNovel">Novel</a></li>
		<li><a href="catagoryStory">Story</a></li>
		<li><a href="catagoryEducation">Education</a></li>
		<li><a href="catagoryMedical">Medical</a></li>
		<li><a href="catagoryEngineering">Engineering</a></li>
		<li><a href="catagoryComputer">Computer</a></li>
	</ul>
	<br>
	<c:if test="${not empty shopid}">
			Book Upload
       <br>
		<ul>

			<li><a href="addBook">Upload new Book</a></li>


		</ul>
		<br>

	</c:if>

	<c:if test="${role=='admin'}">
		All Shop
       <br>
		<ul>
			<li><a href="showAllShop">Show all shop</a></li>
		</ul>
		<br>
      
      All Users
       <br>
		<ul>
			<li><a href="showAllUser">Show all Users</a></li>
		</ul>
		<br>
		
		 All Orders
       <br>
		<ul>
			<li><a href="showOrders">Show all Orders</a></li>
		</ul>
		<br>

	</c:if>
	
	<c:if test="${not empty shopid}">
		Orders
       <br>
		<ul>

			<li><a href="showOrders">Show Orders</a></li>


		</ul>
		<br>

	</c:if>



</body>
</html>
