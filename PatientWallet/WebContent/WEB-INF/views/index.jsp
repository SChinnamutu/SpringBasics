<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/context/css/style.css">
<!-- <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery-1.8.2.min.js'></script>
 -->
 <script type="text/javascript" charset="utf8"  src="${pageContext.request.contextPath}/context/js/jquery-1.8.2.min.js"></script>
 <script src="${pageContext.request.contextPath}/context/js/index.js"></script>
 --%>
<%@ include file="header_guest.jsp" %>
<html >

<script type="text/javascript">

$(document).ready(function() {
	var errorMsg = $('#message').val();
	if(errorMsg != '' && errorMsg != null){
		alert(errorMsg);
	}
});


</script>


  <body>
  	<!-- <h1>Welcome to Perficient Health Care</h1> -->
  	<h1>Perficient Health Care</h1>
 	<div class="login-page">
 		 <div class="form">
		    <form class="login-form" name="loginForm" id="loginForm" method="post">
		      <input type="text" name="uname" id="userNameL"   placeholder="Please enter mobile number" maxlength="10" onkeypress="return isNumber(event)"/>
		      <input type="password" name="pswd" id="passWordL"  placeholder="Please enter password" maxlength="10" />
		      <input type="submit" value="Login" onclick="validate();"/> 
		      <p class="message">Not registered? <a href="#" onclick="getSignUpPage()">Create an account</a></p>
		    </form>
		     <form name="signupForm" id="signupForm"> </form>
		     <form name="viewForm" id="viewForm"> </form>
		    <input type="hidden" name="message" id="message" value="${message}"/>
 		 </div>
	</div>
  </body>
</html>
