package com.perficient.bo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.PerfConstant.Constant;
import com.perficient.daoImpl.AccountDAOImpl;
import com.perficient.daoImpl.RegistrationDAOimpl;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ResponseTO;


@Component
@Service
public class RegistrationBO {

	@Autowired
	private RegistrationDAOimpl iRegistrationDAOimpl;
	
	@Autowired
	private AccountDAOImpl iAccountDAOImpl;
	

	public ResponseTO saveDetails(String userName, String pswd,String mobileNumber, String email) {
		PftUserDetails pftUserDetails = new PftUserDetails();
		pftUserDetails.setName(userName);
		pftUserDetails.setPassword(pswd);
		pftUserDetails.setEmail(mobileNumber);
		pftUserDetails.setMobileNumber(email);
		iRegistrationDAOimpl.saveDetails(pftUserDetails);
		
		PftAccountDetails pftAccountDetails = new PftAccountDetails();
		pftAccountDetails.setAccountName(Constant.INFOGEM);
		pftAccountDetails.setAccountBalance(100000);
		pftAccountDetails.setRemarks(Constant.NONE);
		pftAccountDetails.setPftUserId(new BigDecimal(pftUserDetails.getUserId()));
		pftAccountDetails.setAccountNumber("31394180414");
		return iAccountDAOImpl.saveDetails(pftAccountDetails);
	}
	
}
