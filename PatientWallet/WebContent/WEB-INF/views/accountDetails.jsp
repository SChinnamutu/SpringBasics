<html>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%@ include file="comman_header.jsp" %>
	  <script>
		  $(document).ready(function() {
			  $("#accountTable").dataTable();
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
		  function addAmount(){
			  document.accountForm.action = "validateLoginCredintials.do";
			  document.accountForm.submit();
		  }
	  </script>

<body>

	 <div class="logout">
          <button type="button" class="btn btn-default" onclick="getLoginPage()">Logout</button>
    </div>
    
    <div id="header_div">
				<h2 style="color:purple;" >Medical Enrollment</h2>		
	</div>
			
	<div id="accountDataTableDiv" style="margin-top: 50px;">
	 	
	 		<table id="accountTable">
		    	
		    	<thead>
				      <tr>
				      	  <th>Account Number</th>
					      <th>Account Name</th>
					      <th>Balance</th>
					     <!--  <th>Action</th>  -->
					 </tr>
		  		 </thead>
		  		 
			    <tbody>
			      	 <c:if test="${not empty iAccountTO}">
			      	 	<c:forEach var="account" items="${iAccountTO}">
						     <tr>
						        <td>${account.accountNumber}</td>
						     	<td>${account.accountName}</td>
						     	 <%-- <c:if test="${account.accountBalance != '0.0'} ">
									      	<td>${apnt.accountBalance}</td>
								</c:if>
								 <c:if test="${account.accountBalance == '0.0'} ">
									      	<td>Please recharge your account</td>
								</c:if>	     --%>
						     	<td>${account.accountBalance}</td>
						     	 <!-- <td>
						     		 <a href="#"  data-toggle="modal" data-target="#accountModal">Add Money</a> 
						     		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
								</td> --> 
						     </tr>
						  </c:forEach>    
				      </c:if>
		      	</tbody>
		   </table>
		    <input type="hidden" id="message" name="message" value=""/>
		    <form name="logoutForm" id="logoutForm"> </form>
	</div> 
		
		
		
		   
	       
  </body>
  
  
		  <!-- <div class="container" >
		  	  <h2>Modal Example</h2>
		  		Trigger the modal with a button
	  
	
	  	  Modal
		  <div class="modal fade" tabindex="-1" id="accountModal" role="dialog">
			    <div class="modal-dialog">
			    
			      Modal content
				     <div class="modal-content">
					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h4 class="modal-title">Add Money</h4>
					        </div>
					        <div class="modal-body">
					         	<table id="availabletimeTable" class="table">
							        <thead>
											<tr>
									     		 <th>Amount</th>
									      		 <th>Remarks</th>
								      		</tr>
							        </thead>
							   		<tbody>
											<tr>
											 	<form name="accountForm" id="accountForm" method="post">
						   						   <td><input type="text" name="accountBalance" id="accountBalance"   placeholder="Please enter amount" maxlength="10" onkeypress="return isNumber(event)"/></td>
						    					   <td><input type="text" name="remarks" id="remarks"  placeholder="Please enter remarks" maxlength="10" /></td>
												</form>
											</tr>
							  		 </tbody>
					  			 </table>
					        </div>
					        <div class="modal-footer">
					          <button type="button" class="btn btn-default" onclick="addAmount();">Save</button>
					          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					        </div>
			      <
			    </div>
		  </div>
	  
		</div>
 -->
  
</html>


