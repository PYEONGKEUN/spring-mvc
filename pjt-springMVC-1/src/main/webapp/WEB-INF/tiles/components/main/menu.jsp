<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div align="center">
	<table>
		<tr>
			<td width="80"><a href="${pageContext.request.contextPath}/"><spring:message code="header.home" /></a></td>

			<sec:authorize access="!isAuthenticated()">
				<td width="120"><a href="${pageContext.request.contextPath}/board/list"><spring:message code="menu.board.member" /></a></td>
				<td width="120"><a href="${pageContext.request.contextPath}/notice/list"><spring:message code="menu.notice.member" /></a></td>
				<td width="120"><a href="${pageContext.request.contextPath}/item/list"><spring:message code="menu.item.member" /></a></td>
				<td width="120"><a href="${pageContext.request.contextPath}/pds/list"><spring:message code="menu.pds.member" /></a></td>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">

				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td width="120"><a href="${pageContext.request.contextPath}/codeclass/list"><spring:message code="menu.codeclass.list" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/codedetail/list"><spring:message code="menu.codedetail.list" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/user/list"><spring:message code="menu.user.admin" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/board/list"><spring:message code="menu.board.admin" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/notice/list"><spring:message code="menu.notice.admin" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/item/list"><spring:message code="menu.item.admin" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/pds/list"><spring:message code="menu.pds.admin" /></a></td>
				</sec:authorize>

				<sec:authorize access="hasRole('ROLE_MEMBER')">
					<td width="120"><a href="${pageContext.request.contextPath}/board/list"><spring:message code="menu.board.member" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/notice/list"><spring:message code="menu.notice.member" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/item/list"><spring:message code="menu.item.member" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/coin/charge"><spring:message code="menu.coin.charge" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/coin/list"><spring:message code="menu.coin.list" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/useritem/list"><spring:message code="menu.useritem.list" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/coin/listPay"><spring:message code="menu.coin.listPay" /></a></td>
					<td width="120"><a href="${pageContext.request.contextPath}/pds/list"><spring:message code="menu.pds.member" /></a></td>
				</sec:authorize>
				
			</sec:authorize>

		</tr>
	</table>
</div>
<hr>
