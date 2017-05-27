 <link rel="stylesheet" href="${pageContext.request.contextPath}/context/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/context/css/font-awesome.css" rel="stylesheet">
  
  						<h1>Hi Dr.${fullName},  Welcome to Perficient Health Care</h1>
<script>


function getAvailableAppointDetails(){
	document.appointmentDetailsForm.action = "getRequestDetails.do";
	document.appointmentDetailsForm.submit();
}

function getServiceDetails(){
	document.createServiceForm.action = "getServiceDetails.do";
	document.createServiceForm.submit();
}
/* 
function getMyAppointmentDetails(){
	document.myAppointmentForm.action = "getRequestDetails.do";
	document.myAppointmentForm.submit();
}

function uploadFiles(){
	document.uploadFileForm.action = "uploadFiles.do";
	document.uploadFileForm.submit();
}
 */
</script> 
  
  
  <form name="appointmentDetailsForm" id="appointmentDetailsForm"></form>  
  <form name="createServiceForm" id="createServiceForm"></form>
  <!-- <form name="myAppointmentForm" id="myAppointmentForm"></form>
  <form name="uploadFileForm" id="uploadFileForm"></form>
   -->
<ul id="breadcrumb">
  <li><a href="#" onclick="getAvailableAppointDetails();"><span class="icon icon-beaker"> </span> Appointments</a></li>
  <li><a href="#" onclick="getServiceDetails();"><span class="icon icon-double-angle-right"></span> Create Service</a></li>
 <!--  <li><a href="#" onclick="getAccountDetails();"><span class="icon icon-double-angle-right"></span> Credit Amount</a></li>
  <li><a href="#" onclick="getMyAppointmentDetails();"><span class="icon icon-rocket"> </span> My Appointments</a></li>
  <li><a href="#" onclick="uploadFiles();"><span class="icon icon-rocket"> </span>Upload Reports</a></li>
 --></ul>

 
 <%-- 
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.title"/></h3>

<span style="float: right">
	<a href="?lang=en">en</a> 
	| 
	<a href="?lang=de">de</a>
</span> --%>