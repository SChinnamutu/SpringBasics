package com.perficient.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.daoImpl.LoginDAOImpl;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ResponseTO;


@Component
@Service
public class LoginBO {

	@Autowired
	private LoginDAOImpl iLoginDAOImpl;
	
	public ResponseTO validate(String uname,String pswd) {
		ResponseTO responseTO = new ResponseTO();
		List<PftUserDetails> iPftUserDetails = iLoginDAOImpl.validate(uname,pswd);
		if(iPftUserDetails != null && iPftUserDetails.size() > 0){
			responseTO.setStatus(ApplicationConstant.RESPONSE_SUCCESS);
			responseTO.setUserId(String.valueOf(iPftUserDetails.get(0).getUserId()));
			responseTO.setfName(iPftUserDetails.get(0).getName());
			return responseTO;
		}
		responseTO.setStatus(ApplicationConstant.RESPONSE_FAILURE);
		return responseTO;
	}
	

}
