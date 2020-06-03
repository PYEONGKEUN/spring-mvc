<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
	<title><tiles:getAsString name="title" /></title>
</head>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>

<body>

	<tiles:insertAttribute name="header" />
	
	<div align="center">
		<tiles:insertAttribute name="content" />
	</div>
	
</body>
</html>
