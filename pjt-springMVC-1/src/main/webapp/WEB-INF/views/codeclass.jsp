<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="codeclass.header.list"/></h2>

<a href="register"><spring:message code="action.new"/></a>
<table brder="1">
	<tr>
		<th align="center" width="160"><spring:message code="codeclass.classCode"/></th>
		<th align="center" width="160"><spring:message code="codeclass.className"/></th>
		<th align="center" width="160"><spring:message code="codeclass.classregdate"/></th>
	</tr>
	<c:choose>
		<c:when test="${empty list}">
			<tr>
				<td colspan="3">
					<spring:message code="common.listEmpty"/>
					
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list }" var="codeClass">
				<tr>
					<td align="center"><spring:message code="codeclass.classregdate"/></td>
					<td align="left"><a href="/codeclass/read?classCode=${codeClass.classCode}">${codeClass.className }</a></td>
					<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${codeClass.regDate }"/></td>
					
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>

<script>
	var result ="${msg}";
	
	if(result == "SUCCESS"){
		alert("<spring:message code='common.processSuccess'/>");		
	}

</script>