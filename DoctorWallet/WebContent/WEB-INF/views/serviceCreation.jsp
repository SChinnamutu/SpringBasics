<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comman_header.jsp" %>
<html>

	<script type="text/javascript">
		$(document).ready(function() {
			var errorMsg = $('#message').val();
			if(errorMsg != '' && errorMsg == null){
				alert(errorMsg);
			}
		});
	</script>

	<body>
	<div id="header_div">
				<h2 style="color:purple;" >Service Creation</h2>		
	</div>
	
	<div class="signup">
 		 <div class="form">
		    <form:form  name="serviceCreationForm" id="serviceCreationForm" method="post" commandName="iServiceCreationForm">
		      <form:input type="text" name="serviceName" id="serviceName" path="serviceName" placeholder="Enter service name" value=""></form:input>
		      <form:input type="text" name="serviceCharge" id="serviceCharge" path="serviceCharge" placeholder="Enter service charge" value=""></form:input>
		      <form:input type="text" name="location" id="location" path="location" placeholder="Enter service location" value=""></form:input>
		      <form:input type="text" name="availDate" id="availDate" placeholder="Please enter avail date" path="availDate" value="05/06/2017"></form:input>
		      <form:input type="text" name="availTime" id="availTime" placeholder="Please enter time" path="availTime" value=""></form:input>
		      <input type="submit" value="Submit" onclick="saveServiceDetails();"/>
		    </form:form>
		     <input type="hidden" name="message" id="message" value="${message}"/>
 		 </div>
	</div>
    </body>
</html> 

