<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<tiles:getAsString name="title"></tiles:getAsString>
</head>
<script src="/resources/js/jquery-3.5.1.min.js"></script>
<body>

	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="menu"/>
	<div align="center">
		<tiles:insertAttribute name="content"/>
	</div>
	<tiles:insertAttribute name="footer"/>

</body>
</html>