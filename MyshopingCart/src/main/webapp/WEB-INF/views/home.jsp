<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="title" /></title>
<!-- DC Horizontal Carousel CSS -->
<link type="text/css" rel="stylesheet"
	href="http://cdn.dcodes.net/2/carousel_hor/css/dc_carousel_hor.css" />
<!-- jQuery Library (skip this step if already called on page ) -->
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/jquery.min.js"></script>
<!-- (do not call twice) -->
<!-- DC Horizontal Carousel JS -->
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/carousel_hor/js/jquery.bxslider2.min.js"></script>
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/carousel_hor/js/dc_jqcarousel.js"></script>
<!-- DC Elastislide CSS -->
<link type="text/css" rel="stylesheet"
	href="http://cdn.dcodes.net/2/carousel_hor/css/elastislide.css" />
<!-- DC Elastislide JS -->
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/carousel_hor/js/modernizr.custom.js"></script>
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/carousel_hor/js/jquerypp.custom.js"></script>
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/carousel_hor/js/jquery.elastislide.js"></script>
<!-- DC Page Header CSS -->
<link type="text/css" rel="stylesheet"
	href="http://cdn.dcodes.net/2/headers/css/dc_headers.css" />
<!-- DC Page Header JS -->
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/headers/js/dc_headers.js"></script>


<style type="text/css">
body {
	background-image: url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg');
}
</style>


<%@ include file="header.jsp"%>
</head>
<body>

	<%-- <fmt:message key="welcome" />
	&nbsp;&nbsp;${uname}
 --%>


	<%--<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
		</ol>
	</div>

	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src="resources/images/1.png">
		</div>


		<div class="item">
			<img src="resources/images/3.png">
		</div>

		<div class="item">
			<img src="resources/images/4.png">
		</div>



		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
 --%>

	<br>

	<%@ include file="footer.jsp"%>
</body>
</html>