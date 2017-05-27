<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comman_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Add Product Form</title>
</head>

<script>
function saveReports(){
	document.fileUploadForm.action = "saveReports.do";
	document.fileUploadForm.submit();
}

function getLoginPage(){
	document.loginForm.action = "getLoginPage.do";
	document.loginForm.submit();
}
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
                    <input type="file" name="images" multiple="multiple"/>
                </p>
                <p id="buttons">
                    <input id="reset" type="reset" tabindex="4"> 
                    <input id="submit" type="submit" onclick="saveReports();" tabindex="5" value="Save Report">
                </p>
            </fieldset>
        </form:form>
    </div>
</body>
</html>