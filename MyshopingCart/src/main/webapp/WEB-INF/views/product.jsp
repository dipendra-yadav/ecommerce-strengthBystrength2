<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/resource/js/controller.js"></c:url>"></script>

<!-- DC Table Styles I CSS -->
<link type="text/css" rel="stylesheet"
	href="http://cdn.dcodes.net/2/tables1/css/dc_tables1.css" />
<%@ include file="header.jsp"%>

<style type="text/css">
body {
	background-image: url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg');
}
</style>

</head>
<body>

	<div data-ng-app="myapp">

		<div data-ng-controller="productController"
			data-ng-init="getAllProducts()">

			Search: <input type="text" data-ng-model="searchCondition">

            <security:authorize access="hasRole('ROLE_ADMIN')">
			<center>
				<h2>Manage Products</h2>

				<a href="/manage_product_create" class="btn btn-primary"
					role="button">Add Product</a>

			</center>
			</security:authorize>

			<br /> 





			<!-- DC Table Styles I:3 Start -->
			<center>
				<table class="dc_table_s3" summary="Sample Table" style="width: 90%">

					<thead>
						<tr>
							<th width="35%" height="35%">IMAGE</th>

							<th>NAME</th>
							<th>PRICE</th>
							<th>DESCRIPTION</th>
							<th><h5>DETAILS</h5></th>
							<th><h5>EDIT/DELETE</h5></th>

						</tr>

					</thead>
					<tbody>
						<tr data-ng-repeat="product in products | filter:searchCondition">


							<c:url value="resource/images/{{product.id}}.png" var="src" />
							<td><img src="${src}" style="width: 20%" align="middle" /></td>



							<td align="center">{{product.name}}</td>
							<td align="center">{{product.price}}</td>
							<td align="center">{{product.description}}</td>



							<td align="center"><a
								href="getProductsByProductId/{{product.id}}">{{product.id}}</a></td>

							<td align="center"><a
								href="<c:url value="/manage_product_edit/{{product.id}}"/>">Edit
									<span class="glyphicon glyphicon-edit"></span>
							</a>| <a
								href="<c:url value="/manage_product_delete/{{product.id}}"/>">
									<span class="glyphicon glyphicon-trash"></span>delete
							</a></td>
						</tr>
					</tbody>

				</table>
			</center>

			<!-- DC Table Styles I:3 End -->

		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
