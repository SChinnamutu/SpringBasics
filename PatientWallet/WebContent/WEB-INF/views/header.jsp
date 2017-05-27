<link rel="stylesheet" href="${pageContext.request.contextPath}/context/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/context/css/font-awesome.css" rel="stylesheet">
  
  						<h1>Hi ${fullName},  Welcome to Perficient Health Care</h1>
<script>


function getAvailableAppointDetails(){
	document.appointmentDetailsForm.action = "getAllDetails.do";
	document.appointmentDetailsForm.submit();
}

function getAccountDetails(){
	document.accountDetailsForm.action = "getAccountDetails.do";
	document.accountDetailsForm.submit();
}

function getMyAppointmentDetails(){
	document.myAppointmentForm.action = "getRequestDetails.do";
	document.myAppointmentForm.submit();
}

function uploadFiles(){
	document.uploadFileForm.action = "uploadFiles.do";
	document.uploadFileForm.submit();
}

</script> 
  
  
  <form name="appointmentDetailsForm" id="appointmentDetailsForm"></form>  
  <form name="accountDetailsForm" id="accountDetailsForm"></form>
  <form name="myAppointmentForm" id="myAppointmentForm"></form>
  <form name="uploadFileForm" id="uploadFileForm"></form>
  
<ul id="breadcrumb">
  <li><a href="#" onclick="getAvailableAppointDetails();"><span class="icon icon-beaker"> </span> Appointments</a></li>
  <li><a href="#" onclick="getAccountDetails();"><span class="icon icon-double-angle-right"></span>Medical Enrollment</a></li>
  <li><a href="#" onclick="getMyAppointmentDetails();"><span class="icon icon-rocket"> </span> My Appointments</a></li>
  <li><a href="#" onclick="uploadFiles();"><span class="icon icon-rocket"> </span>Upload Reports</a></li>
</ul>

