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
	/*$.ajax({
		type: "POST",
		url : "validateLoginCredintials.do",
		data:{uname:uname,pswd:pswd},
		dataType: 'json',
		success     : function(data){
            console.log(" ooh2 " +data.status); //to print name of employee
			document.viewForm.action = "getAllDetails.do";
			document.viewForm.submit();
			alert("ooh");
			alert("ooh " +data.status);
		}
       }); */
	
	
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
	var claimId = $("#claimId").val();
	
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
	if(claimId  == null || claimId == ''){
		alert("Please enter claimId.");
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

