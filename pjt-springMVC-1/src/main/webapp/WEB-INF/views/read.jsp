<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<h2><spring:message code="codeclass.header.read"/></h2>
<form:form modelAttribute="codeClass" action="read">

	<table>
	  <tr>
	    <td><spring:message code="codeclass.classCode"/></td>
	    <td><form:input path="classCode" readonly="true"/></td>
	    <td><font color="red"><form:errors path="classCode"/></font></td>
	  </tr>
	  <tr>
	    <td><spring:message code="codeclass.className"/></td>
	    <td><form:input path="className" readonly="true"/></td>
	    <td><font color="red"><form:errors path="className"/></font></td>
	  </tr>  
	</table>

</form:form>
<div>
	<button type="submit" id="btnEdit"><spring:message code="action.edit"/></button>
	<button type="submit" id="btnRemove"><spring:message code="action.remove"/></button>
	<button type="submit" id="btnList"><spring:message code="action.list"/></button>
			
</div>

<script>
	$(document).ready( function name() {
		var formObj = $("#codeClass");
		
		  
	});
</script>

