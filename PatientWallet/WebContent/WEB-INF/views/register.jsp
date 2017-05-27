<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/context/js/index.js"></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/context/css/style.css">
 --%>
<%@ include file="header_guest.jsp" %>
<html>

<script type="text/javascript">

$(document).ready(function() {
	var errorMsg = $('#message').val();
	if(errorMsg != '' && errorMsg == null){
		alert(errorMsg);
	}
});


function checkMobileAlreadyNumberExist(userNumber){
	if(userNumber != null && userNumber !=''){
		 alert("ooh "+userNumber);
		 $.ajax({
	     type: "POST",
		 url : "checkMobileAlreadyNumberExist.do",
		 data:{mobileNumber:userNumber},
		 contentType: 'application/json; charset=utf-8',
		 dataType: 'text json',
		 cache: false,
		 success: function(response){
			 	alert(response)
				alert("ooh Mobile number is already exist in system.Please enter new number");
		  },error: function(e){
			     alert('Error: ' + e);
			     alert(e)
				 alert("ooh No . Mobile number is not exist in system.");
				 document.getElementById("mobilenumber").value = "";
		 }
	   }); 

	}
}

</script>

	<body>
	<h1>Perficient Health Care</h1>
	
	<div id="header_div">
		<h2 style="color:purple;" >Register</h2>	
	</div>
	
	<div class="signup">
 		 <div class="form">
  
		    <form:form  name="signUpForm" id="signUpForm" method="post" commandName="iSignUpForm">
		      <form:input type="text" name="username" id="username" path="name" placeholder="Please enter full name" value=""></form:input>
		      <form:input type="password" name="password" id="pswd" path="pswd" placeholder="Please enter password" value=""></form:input>
		      <form:input type="text" name="email" id="email" placeholder="Please enter email" path="email" value=""></form:input>
		      <form:input type="text" name="mobilenumber" id="mobilenumber" placeholder="Please enter mobile number" path="mobilenumber"  value=""></form:input>
		       <form:input type="text" name="claimId" id="claimId" placeholder="Please enter claimId" path="claimId"  value=""></form:input>
		      <input type="submit" value="Submit" onclick="saveSignUpDetails();"/>
		      <p class="message">Already registered? <a href="#" onclick="getLoginPage()">Sign In</a></p>
		    </form:form>
		     <input type="hidden" name="message" id="message" value="${errorMsg}"/>
			<form:form name="loginForm" id="loginForm"> </form:form>   
 		 </div>
	</div>
    </body>
</html>