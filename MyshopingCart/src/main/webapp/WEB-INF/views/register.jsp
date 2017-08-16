<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg');
}
</style>
</head>
<body>


	<center>This is Registration page</center>


	<form:form action="registration" method="post" commandName="user">

		<table>
			<tr>
				<td><form:label path="id">User Id</form:label></td>
				<td><form:input path="id" disabled="true" /></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">User Name</form:label></td>
				<td><form:input path="name" /></td>
			
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			
			</tr>
			
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
			
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"
					class="btn btn-default"></td>
			</tr>

		</table>
	</form:form>
</body>
</html>