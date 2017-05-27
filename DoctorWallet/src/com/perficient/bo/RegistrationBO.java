package com.perficient.bo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.daoImpl.AccountDAOImpl;
import com.perficient.daoImpl.RegistrationDAOimpl;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ResponseTO;
import com.perficient.to.SignUpForm;


@Component
@Service
public class RegistrationBO {

	@Autowired
	private RegistrationDAOimpl iRegistrationDAOimpl;
	
	@Autowired
	private AccountDAOImpl iAccountDAOImpl;
	
	
	public ResponseTO saveDetails(SignUpForm iSignUpForm) {
		PftUserDetails pftUserDetails = new PftUserDetails();
		pftUserDetails.setName(iSignUpForm.getName());
		pftUserDetails.setPassword(iSignUpForm.getPswd());
		pftUserDetails.setEmail(iSignUpForm.getEmail());
		pftUserDetails.setMobileNumber(iSignUpForm.getMobilenumber());
		pftUserDetails.setRoleId(ApplicationConstant.DOCTOR);
		iRegistrationDAOimpl.saveDetails(pftUserDetails);
		
		PftAccountDetails pftAccountDetails = new PftAccountDetails();
		pftAccountDetails.setAccountName(ApplicationConstant.INFOGEM);
		pftAccountDetails.setAccountBalance(100000);
		pftAccountDetails.setRemarks(ApplicationConstant.NONE);
		pftAccountDetails.setPftUserId(new BigDecimal(pftUserDetails.getUserId()));
		pftAccountDetails.setAccountNumber("31394180414");
		return iAccountDAOImpl.saveDetails(pftAccountDetails);
	}


	public String checkMobileAlreadyNumberExist(String mobileNumber) {
		List<PftUserDetails> iPftUserDetails = iRegistrationDAOimpl.getUserDetails(mobileNumber);
		if(iPftUserDetails.size() > 0){
			return ApplicationConstant.RESPONSE_SUCCESS;
		}else{
			return ApplicationConstant.RESPONSE_FAILURE;
		}
	}
	
}
