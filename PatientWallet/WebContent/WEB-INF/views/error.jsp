<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<script type="text/javascript">

function saveSignUpDetails(){
	alert("ooh");
	document.loginPageForm.action = "getLoginPage.do";
	document.loginPageForm.submit();
}

</script>


<body>

<form:form name="loginPageForm" id="loginPageForm"></form:form>

<h2>Application Error Occured. Please afetr sometime</h2>

<a onclick="">Please click here to go to login Page</a>

</body>
</html>