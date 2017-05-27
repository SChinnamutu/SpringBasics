function saveDetails(x){

	document.getElementById("doctorId").value = document.getElementById("userId").value;
	document.getElementById("timeFixed").value = x;
	
	document.appointForm.action = "saveTimieDetails.do";
	document.appointForm.submit();
}


function setValue(t){
	document.getElementById("userId").value = t;
}
