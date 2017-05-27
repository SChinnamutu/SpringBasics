<html>
<%@ include file="comman_header.jsp" %>	
	<script>
	    $(document).ready(function() {
			  $("#fixedAppointmentTable").dataTable();
		});
		$(document).ready(function() {
			var errorMsg = $('#message').val();
			if(errorMsg != '' && errorMsg != null){
				alert(errorMsg);
			}
		});
		function getLoginPage(){
			//alert("ooh");
			document.logoutForm.action = "getLoginPage.do";
			document.logoutForm.submit();
 		 }
		
		function acceptRequest(id){
			$('#id').val(id);
			document.acceptForm.action = "acceptRequest.do";
			document.acceptForm.submit();
 		 }
		
		function declineRequest(id){
			$('#id').val(id);
			document.acceptForm.action = "declineRequest.do";
			document.acceptForm.submit();
 		 }
		
		function downloadReport(id){
			$('#id').val(id);
			document.acceptForm.action = "downloadReport.do";
			document.acceptForm.submit();
 		 }
	</script>


	<body>
			<div id="header_div">
				<h2 style="color:purple;" >Fixed Appointments</h2>		
			</div>
			
			<div class="logout">
		          <button type="button" class="btn btn-default" onclick="getLoginPage()">Logout</button>
		    </div>
			
			  <form name="acceptForm" id="acceptForm"> 
			  	<input type="hidden" id="id" name="id" value=""></input>
			  </form>
			<div id="fixedAppointDataTableDiv" style="margin-top: 50px;">
				
				<table id="fixedAppointmentTable" >
			        <thead>
							<tr>
								  <th>Patient Name</th>
								  <th>Patient Mobile Number</th>	
							      <th>Appointment Date</th>
							      <th>Appointment Time</th>
							      <th>Raised Date</th>
							      <th>Action</th>
				     		</tr>
				    
			        </thead>
			   		<tbody>
					       <c:if test="${not empty tos}">
				      	 	   <c:forEach var="apnt" items="${tos}">
					      	 		 <tr>
									     <td>${apnt.patientName}</td>
									     <td>${apnt.patientNumber}</td>
									     <td>${apnt.appointmentDate}</td>
									     <td>${apnt.fixedTime}</td>
									     <td>${apnt.raisedDate}</td>
									     <td>
									     	<input type="button" name="accept" id="accept" value="Accept" onclick="acceptRequest('${apnt.requestId}')"/>
									     	<input type="button" name="decline" id="decline" value="Decline" onclick="declineRequest('${apnt.requestId}')"/>
									     	<c:if test="${apnt.fileAvailable == 'Y'}">
									     		<input type="button" name="download" id="download" value="DownloadReport" onclick="downloadReport('${apnt.doctorId}')"/>
									     	</c:if>
									     	
									     </td>
								     </tr> 
							  </c:forEach>    
					      </c:if>
						 
			  		 </tbody>
			   </table>
			</div> 
			 <input type="hidden" id="message" name="message" value="${message}"/> 
			<form name="logoutForm" id="logoutForm"> </form>
	</body>
</html>


