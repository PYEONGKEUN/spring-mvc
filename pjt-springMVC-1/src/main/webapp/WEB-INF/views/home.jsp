<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	<spring:message code="common.homeWelcome"/>
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
