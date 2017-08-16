<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- DC Table Styles I CSS -->
<link type="text/css" rel="stylesheet"
	href="http://cdn.dcodes.net/2/tables1/css/dc_tables1.css" />

<style type="text/css">
body {
	background-image: url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg');
}
</style>
<%@ include file="header.jsp"%>

</head>
<body>
	<center>
		<h2>Manage Category</h2>
		<a href="manage_category_create" class="btn btn-primary" role="button">Add
			Category</a>
	</center>

			<br /> 



	<!-- DC Table Styles I:3 Start -->
	<center>
	<table class="dc_table_s3" summary="Sample Table" style="width: 90%">

		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Description</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		
		<tbody>		
		  <c:forEach var="category" items="${categoryList}">
			<tr>
				<td align="center">${category.id}</td>
				<td align="center">${category.name}</td>
				<td align="center">${category.description}</td>

				<td align="center">
						<a href="<c:url value="manage_category_edit/${category.id}"/>">Edit
							<span class="glyphicon glyphicon-edit"></span>
						</a>| <a href="<c:url value="manage_category_delete/${category.id}"/>">
							<span class="glyphicon glyphicon-trash"></span>delete
						</a>
				</td>
					
			</tr>
		</c:forEach>
		</tbody>
		

	</table>
	</center><!-- DC Table Styles I:3 End -->
	<%@ include file="footer.jsp"%>

</body>
</html>
