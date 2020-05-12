<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div align="center">
	<table>
	  <tr>
	    <td><spring:message code="codeclass.classCode"/></td>
	    <td><form:input path="classCode"/></td>
	    <td><font color="red"><form:errors path="classCode"/></font></td>
	  </tr>
	</table>
</div>
<hr/>