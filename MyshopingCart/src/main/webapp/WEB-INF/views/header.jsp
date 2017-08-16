<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style type="text/css">
	#welcome{
	
	   color: #efefef;
	
	
	}
	
	</style>
	
</head>
<body>
	<!-- DC Page Header Start -->
	<div class="dc_gradient2">
		<h1>
			<span></span>
		</h1>
		<h2>
			<fmt:message key="title" />
		</h2>
	</div>
	<!-- DC Page Header End -->

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav ">
				<li><a href="<c:url value="/home"/>">Home</a></li>
				<li><a href="<c:url value="/aboutUs"/>">About us</a></li>
				<c:if test="${pageContext.request.userPrincipal.name !=null}">
				   <security:authorize access="hasRole('ROLE_ADMIN')">
				
				
				   <li><a href="<c:url value="/getAllProducts"/>">Products</a></li>

	               <li><a href="<c:url value="/getAllCategories"/>">
						Categories</a></li>
				   <li><a href="<c:url value="/getAllSuppliers"/>">
						Suppliers</a></li>

               </security:authorize>
               
               
               
               <security:authorize access="hasRole('ROLE_USER')">
                  <li><a href="<c:url value="/getAllProducts"/>">
						Products</a></li> 
               </security:authorize>
               
              
               </c:if>
               
               <c:url value="/j_spring_security_logout" var="logoutUrl" />
               <form action="${logoutUrl}" method="post" id="logoutForm">
		                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	            </form>
	            <script>
		              function formSubmit() {
			                          document.getElementById("logoutForm").submit();
		                 }
	            </script>
               
               <c:if test="${pageContext.request.userPrincipal.name != null}">
                       <li><a>Welcome  ${pageContext.request.userPrincipal.name}</a> </li>| 
                       <li><a href="javascript:formSubmit()"> Logout</a></li>
                      
               </c:if>
          

			
				
				<c:if test="${pageContext.request.userPrincipal.name==null}">
				  <li><a href="<c:url value="/login"/>">login</a></li>
				    <c:url value="/registration" var="url"></c:url>
				  <li><a href="${url }">Register</a></li>
               </c:if>

             
			</ul>
		</div>

	</nav>
</body>
</html>

