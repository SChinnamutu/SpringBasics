function validate(){
	var uname = $("#userNameL").val();
	var pswd = $("#passWordL").val();
	var pattern = /^[\s()+-]*([0-9][\s()+-]*){6,20}$/;
	
	if(uname == null || uname == ''){
		alert("Please enter username.");
		return false;
	}
	if(pswd  == null || pswd == ''){
		alert("Please enter password.");
		return false;
	}
    if (!pattern.test(uname)) {
        alert("Your mobile number : "+uname);
        return false;
    }
    if (uname.charAt(0) == "1" || uname.charAt(0) == "2" || uname.charAt(0) == "3" || uname.charAt(0) == "4" || uname.charAt(0) == "5" ){
        alert("it should start with more than 5 ");
        document.getElementById("userNameL").reset();
        return false;
    }
	document.loginForm.action = "validateLoginCredintials.do";
	document.loginForm.submit();
}

function getLoginPage(){
	document.loginForm.action = "getLoginPage.do";
	document.loginForm.submit();
}

function getSignUpPage(){
	document.signupForm.action = "getSignUpPage.do";
	document.signupForm.submit();
}

function saveSignUpDetails(){
	var uname = $("#username").val();
	var pswd = $("#pswd").val();
	var email = $("#email").val();
	var mobilenumber = $("#mobilenumber").val();
	var enrollmentId = $("#enrollmentId").val();
	
	if(uname == null || uname == ''){
		alert("Please enter username.");
		return false;
	}
	if(pswd  == null || pswd == ''){
		alert("Please enter password.");
		return false;
	}
	if(email == null || email == ''){
		alert("Please enter email.");
		return false;
	}
	if(mobilenumber  == null || mobilenumber == ''){
		alert("Please enter mobilenumber.");
		return false;
	}
	if(enrollmentId  == null || enrollmentId == ''){
		alert("Please enter enrollmentId.");
		return false;
	}
	
	document.signUpForm.action = "saveSignUpDetails.do";
	document.signUpForm.submit();
}
	
function getRegisterPage(){
	document.emptyFrom.action = "getSignUpPage.do";
	document.emptyFrom.submit();
}

function getAppoinDetails(){
	document.viewForm.action = "getAllDetails.do";
	document.viewForm.submit();
}


     
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

function saveServiceDetails(){
	
	var serviceName = $("#serviceName").val();
	var serviceCharge = $("#serviceCharge").val();
	var location = $("#location").val();
	var availDate = $("#availDate").val();
	var availTime = $("#availTime").val();
	
	if(serviceName == null || serviceName == ''){
		alert("Please enter serviceName.");
		return false;
	}
	if(serviceCharge  == null || serviceCharge == ''){
		alert("Please enter serviceCharge.");
		return false;
	}
	if(location == null || location == ''){
		alert("Please enter location.");
		return false;
	}
	if(availDate  == null || availDate == ''){
		alert("Please enter availDate.");
		return false;
	}
	if(availTime  == null || availTime == ''){
		alert("Please enter availTime.");
		return false;
	}
	
	document.serviceCreationForm.action = "saveServiceDetail.do";
	document.serviceCreationForm.submit();

	
}