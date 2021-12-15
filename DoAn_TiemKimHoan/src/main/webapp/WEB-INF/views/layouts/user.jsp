<%@ page pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.opensymphony.com/sitemesh/decorator" prefix ="dec" %>

<head>
	<meta charset="utf-8">
	<title>Shop Trang Sức</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
	<link rel="stylesheet" media="all" href="<c:url value ='/resources/css/style.css'/>">
	 <link rel="stylesheet" media="all" href="<c:url value ='/resources/css/test.css'/>"> 
	
</head>
<body>

<%@ include file = "/WEB-INF/views/layouts/user/header.jsp" %>



<dec:body/>

	<%@ include file = "/WEB-INF/views/layouts/user/footer.jsp" %>
	<!-- / footer -->


	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write("<script src='js/jquery-1.11.1.min.js'>\x3C/script>")</script>
	<script src="<c:url value = '/resources/js/plugins.js'/>"></script>
	<script src="<c:url value ='/resources/js/main.js'/>"></script> 
    <script src="/script.js"></script>
	<dec:getProperty property="page.script"/>
</body>
</html>
