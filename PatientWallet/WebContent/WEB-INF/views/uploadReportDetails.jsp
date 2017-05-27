<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comman_header.jsp" %>
<!DOCTYPE html>
<html>

<script>
function saveReports(){
	if(document.getElementById("images").files.length == 0 ){
		alert("Please upload report");
		 return false;
	}
	var c2 = $("#myselect option:selected").val();
	if(c2 == null || c2 == "" || c2 == "Select"){
		 alert("Please raise appoint and then upload report");
		 return false;
	}
	$('#doctorId').val(c2);
	document.fileUploadForm.action = "saveReports.do";
	document.fileUploadForm.submit();
}

function getLoginPage(){
	document.loginForm.action = "getLoginPage.do";
	document.loginForm.submit();
}


//$(document ).ready(function() {
function getReportDoctor(){
	//alert("ooh")
	$.ajax({
	    url:'getReportDoctor.do',
	    type:'POST',
	    dataType: 'json',
	    success: function( json ) {
	        $.each(json, function(i, value) {
	            $('#myselect').append($('<option>').text(value).attr('value', value));
	        });
	    }
	});
}
		
//});

</script>


<body>
 	<div class="logout">
          <button type="button" class="btn btn-default" onclick="getLoginPage()">Logout</button>
    </div>
    
    <div id="global">
  	    <form:form name="loginForm" id="loginForm"> </form:form>  
        <form:form name="fileUploadForm" id="fileUploadForm"  method="post" enctype="multipart/form-data" commandName="iReport">
            <fieldset>
                <legend>Add a Report</legend>
                <p>
                    <label for="name">Report Name: </label>
                    <form:input id="name" path="name" cssErrorClass="error" />
                    <form:errors path="name" cssClass="error" />
                </p>
                <p>
                    <label for="description">Report Description: </label>
                    <form:input id="description" path="description" />
                </p>
                <p>
                    <label for="image">Report Images: </label> 
                    <input type="file" id="images" name="images" multiple="multiple" />
                </p>
                <p>
                    <label for="description">Reporting Doctor: </label>
                    	<%-- <c:forEach var="doctor" items="${doctors}">
                    		<input type="text" id="reportDoctor" id="reportDoctor" value="${doctor}" />
                    	</c:forEach> --%>
                    	<select id="myselect" name="myselect" onclick="getReportDoctor()" >
                    		<option selected="selected">Select</option>
                    	</select>
                    	
                </p>
                <p id="buttons">
                    <input id="reset" type="reset" tabindex="4"> 
                    <input id="submit" type="submit" onclick="saveReports();" tabindex="5" value="Save Report">
                </p>
            </fieldset>
            <input type="hidden" name="doctorId" id="doctorId" value="">
        </form:form>
    </div>
</body>
</html>