<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<%--<h1>Message : ${message}</h1>--%>

	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">


		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

	<h2>User Information</h2>
	<form:form method = "POST" action = "/addUser">
		<table>
			<tr>
				<td><form:label path = "username">User Name</form:label></td>
				<td><form:input path = "username" /></td>
			</tr>
			<tr>
				<td><form:label path = "password">Age</form:label></td>
				<td><form:password path = "password" /></td>
			</tr>
			<tr>
				<td><form:label path = "address">Address</form:label></td>
				<td><form:textarea path = "address" rows = "5" cols = "30" /></td>
			</tr>
			<tr>
				<td><form:label path = "receivePaper">Subscribe Newsletter</form:label></td>
				<td><form:checkbox path = "receivePaper" /></td>
			</tr>
			<tr>
				<td><form:label path = "favoriteFrameworks">Favorite Web Frameworks</form:label></td>
				<td><form:checkboxes items = "${webFrameworkList}" path = "favoriteFrameworks" /></td>
			</tr>
			<tr>
				<td><form:label path = "gender">Gender</form:label></td>
				<td>
					<form:radiobutton path = "gender" value = "M" label = "Male" />
					<form:radiobutton path = "gender" value = "F" label = "Female" />
				</td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "submit" value = "Submit"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>