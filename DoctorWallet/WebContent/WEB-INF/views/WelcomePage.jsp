<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>



<form:form method="post" action="addContact.html" commandName="signUpForm">

	<table>
	<tr>
		<td><form:label path="name"><spring:message code="label.firstname"/></form:label></td>
		<td><form:input path="name" /></td> 
	</tr>
	<tr>
		<td><form:label path="pswd"><spring:message code="label.lastname"/></form:label></td>
		<td><form:input path="pswd" /></td>
	</tr>
	<tr>
		<td><form:label path="mobilenumber"><spring:message code="label.email"/></form:label></td>
		<td><form:input path="mobilenumber" /></td>
	</tr>
	<tr>
		<td><form:label path="email"><spring:message code="label.telephone"/></form:label></td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td><form:label path="enrollmentId"><spring:message code="label.telephone"/></form:label></td>
		<td><form:input path="enrollmentId" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="label.addcontact"/>"/>
		</td>
	</tr>
</table>	
	
</form:form>
</body>
</html>