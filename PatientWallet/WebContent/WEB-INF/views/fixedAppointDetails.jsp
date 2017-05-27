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
	</script>


	<body>
			<div id="header_div">
				<h2 style="color:purple;" >My Fixed Appointments</h2>		
			</div>
			
			<div class="logout">
		          <button type="button" class="btn btn-default" onclick="getLoginPage()">Logout</button>
		    </div>
			
			<div id="fixedAppointDataTableDiv" style="margin-top: 50px;">
				
				<table id="fixedAppointmentTable" >
			        <thead>
							<tr>
								  <th>Doctor Id</th> 		
							      <th>Doctor Name</th>
							      <th>Doctor Location</th>
							      <th>Date</th>
							      <th>Time</th>
							      <th>Raised Date</th>
							      <th>Status</th>
				     		</tr>
				    
			        </thead>
			   		<tbody>
					       <c:if test="${not empty tos}">
				      	 	   <c:forEach var="apnt" items="${tos}">
					      	 		 <tr>
									     <td>${apnt.doctorId}</td>
									     <td>${apnt.doctorName}</td>
									     <td>${apnt.doctorLocation}</td>
									     <td>${apnt.appointmentDate}</td>
									     <td>${apnt.fixedTime}</td>
									     <td>${apnt.raisedDate}</td>
									     <td>${apnt.status}</td>
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


