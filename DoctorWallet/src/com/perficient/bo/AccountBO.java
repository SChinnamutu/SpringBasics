package com.perficient.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.daoImpl.AccountDAOImpl;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.to.AccountTO;
import com.perficient.to.ResponseTO;


@Component
@Service
public class AccountBO {

	@Autowired
	private AccountDAOImpl iAccountDAOImpl;
	
	
	public ResponseTO saveDetails(String amount,String remarks,String userId) {
		PftAccountDetails pftAccountDetails = iAccountDAOImpl.getUserSpecificAccountDetails(new BigDecimal(userId));
		pftAccountDetails.setAccountBalance(new Double(amount));
		pftAccountDetails.setRemarks(remarks);
		pftAccountDetails.setAccountName(ApplicationConstant.INFOGEM);
		pftAccountDetails.setPftUserId(new BigDecimal(userId));
		return iAccountDAOImpl.saveDetails(pftAccountDetails);
	}


	public ResponseTO getAccountDetails(String userId) {
		ResponseTO responseTO =  new ResponseTO();
		List<PftAccountDetails> iPftAccountDetails = iAccountDAOImpl.getAccountDetails(new BigDecimal(userId));
		List<AccountTO> iAccountTOs =  new ArrayList<AccountTO>();
		PftAccountDetails iPftAccountDetail  = null;
		for (Iterator<PftAccountDetails> iterator = iPftAccountDetails.iterator(); iterator.hasNext();) {
			AccountTO accountTO = new AccountTO();
			iPftAccountDetail = (PftAccountDetails) iterator.next();
			accountTO.setAccountBalance(String.valueOf(iPftAccountDetail.getAccountBalance()));
			accountTO.setRemarks(iPftAccountDetail.getRemarks());
			accountTO.setAccountName(iPftAccountDetail.getAccountName());
			accountTO.setAccountNumber(iPftAccountDetail.getAccountNumber());
			if(iPftAccountDetail.getAccountBalance() >= 0){
				accountTO.setIsAmountAvailable(ApplicationConstant.YES);
			}else{
				responseTO.setResponseCodeDescription(ApplicationConstant.INSUFFICIENT_WALLET_BALANCE);
			}
			iAccountTOs.add(accountTO);
		}
		responseTO.setiAccountTOs(iAccountTOs);
		responseTO.setStatus(ApplicationConstant.RESPONSE_SUCCESS);
		return responseTO;
		
	}

}
