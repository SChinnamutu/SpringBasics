function addAmount(){
	var amount = $('#amount').val();
	if(amount == null || amount == '' || amount == '0'){
		alert("Please enter amount");
		return false;
	}
	if(amount == '0'){
		alert("Please enter amount more than the zero");
		return false;
	}
	document.accountForm.action = "addMoney.do";
	document.accountForm.submit();
}

function validateAmount(enteredAmount){
	if(enteredAmount == '0'){
		alert("Please enter amount");
		$('#amount').reset();
		return false;
	}
}


