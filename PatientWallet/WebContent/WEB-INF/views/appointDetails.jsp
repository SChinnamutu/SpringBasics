<html>
<%@ include file="comman_header.jsp" %>
	<script>
		$(document).ready(function() {
			  $("#appointmentTable").dataTable();
		});
		$(document).ready(function() {
			var errorMsg = $('#message').val();
			//alert(errorMsg)
			if(errorMsg != '' && errorMsg != null){
				alert(errorMsg);
			}
		});
		
		function saveDetails(x){
			$('#doctorId').val(x);
			document.appointmentForm.action = "saveRequestDetials.do";
			document.appointmentForm.submit();
		}
		function getLoginPage(){
			//alert("ooh");
			document.logoutForm.action = "getLoginPage.do";
			document.logoutForm.submit();
	 	}	 
	</script>



	<body>
			<div id="header_div">
				<h2 style="color:purple;" >Available Doctor Appointments</h2>		
			</div>
			
			<div class="logout">
		          <button type="button" class="btn btn-default" onclick="getLoginPage()">Logout</button>
		    </div>
			
			<div id="appointDataTableDiv" style="margin-top: 50px;">
				
				<table id="appointmentTable" >
			        <thead>
								<tr>
					   			   <th>Name</th>
					   			   <th>Location</th>
					   			   <th>Service</th>
					   			   <th>Available Date</th>
					   			   <th>Time</th>
					      		   <th>Appointment Fees</th>
					      		   <th>Action</th> 
				      			</tr>
				    
			        </thead>
			   		<tbody>
				          <c:if test="${not empty tos}">
				      	 	   <c:forEach var="apnt" items="${tos}">
								      <tr>
									      <td>${apnt.name}</td>
									      <td>${apnt.location}</td>
									      <td>${apnt.service}</td>
									      <td>${apnt.date}</td>
									      <td>${apnt.time}</td>
									      <td>${apnt.fees}</td>
									      <td><a href="#" onclick="saveDetails('${apnt.doctorId}');"> Register</a></td>
		     						 </tr> 
							  </c:forEach>    
					      </c:if>
			  		 </tbody>
			   </table>
			   <input type="hidden" id="userId" name="userId" value=""/>
			   <input type="hidden" id="message" name="message" value="${message}"/>  
			   <form name="appointmentForm" id="appointmentForm">
				<input type="hidden" id="doctorId" name="doctorId" value="" />
			   </form>
			</div> 
			   <form name="logoutForm" id="logoutForm"> </form>
			   
			<%-- <div class="modal fade" id="myModal" role="dialog">
			    <div class="modal-dialog">
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title">Fix Timings</h4>
			        </div>
			        
			        <div class="modal-body">
			         	<table id="availabletimeTable" class="table">
					        <thead>
									  <tr>
					    				<th>Time</th>
					      				<th>Action</th>
				      				  </tr>
					        </thead>
					   		<tbody>
					   				<c:if test="${not empty tos}">
								      	 		<tr>
								      	 			<td><c:out value="${tos.appointment}" /></td>
													<td>
														<a href="#" onclick="saveDetails('${ind}');">Fix It</a>
													</td>
												</tr>
				     				</c:if>

					  		 </tbody>
			  			 </table>
			        </div>
			        
			        <div class="modal-footer">
			          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        </div>
			      </div>
			    </div>
			    <form name="appointForm" id="appointForm">
			    		<input type="hidden" name="doctorId" id="doctorId"/>
			    		<input type="hidden" name="timeFixed" id="timeFixed"/>
			    </form>
			</div>
 --%>				
	</body>
</html>

