<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<br>

<form:form action="save" method="POST" modelAttribute="book" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Book name</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Author name</td>
			<td><form:input path="author" /></td>
		</tr>
		<tr>
			<td>Publisher name</td>
			<td><form:input path="publisher" /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><form:input path="price" /></td>
		</tr>
		
		<tr>
			<td>Genra</td>
			<td><form:input path="genra" /></td>
		</tr>
		
		
		<tr>
               <td>Upload Image</td>
               <td><input type="file" name="fileUpload" size="50" /></td>
           </tr>

		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Add" />
				
			</td>
		</tr>
	</table>
</form:form>

<br>
<br>

</body>
</html>