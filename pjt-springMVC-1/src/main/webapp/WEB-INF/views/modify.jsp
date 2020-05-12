<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2><spring:message code="codeclass.header.modify"/></h2>

<form:form modelAttribute="codeCLass" action="modify">

	<table>
	  <tr>
	    <td><spring:message code="codeclass.classCode"/></td>
	    <td><form:input path="classCode"/></td>
	    <td><font color="red"><form:errors path="classCode"/></font></td>
	  </tr>
	  <tr>
	    <td><spring:message code="codeclass.className"/></td>
	    <td><form:input path="className"/></td>
	    <td><font color="red"><form:errors path="className"/></font></td>
	  </tr>  
	</table>
	
	<div>
		<button type="submit" id="btnModify"><spring:message code="action.modify"/></button>
		<button type="submit" id="btnList"><spring:message code="action.list"/></button>	
	</div>
</form:form>
<script>
$(document).ready( function name() {
	var formObj = $("#codeClass");
	
	$("#btnmodify").on("click",function(){
		formObj.submit();
	});

	$('#btnList').on("click",function(){
		self.loaction = "list";
	});
	
	  
});
</script>