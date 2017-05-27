package com.perficient.bo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.PerfConstant.Constant;
import com.perficient.daoImpl.LoginDAOImpl;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ResponseTO;
import com.perficient.util.ServiceCommanUtil;


@Component
@Service
public class LoginBO {

	@Autowired
	private LoginDAOImpl iLoginDAOImpl;
	
	private ResponseTO responseTO = new ResponseTO();
	
	public ResponseTO validate(String uname,String pswd) {
		List<PftUserDetails> iPftUserDetails = iLoginDAOImpl.validate(uname,pswd);
		if(iPftUserDetails != null && iPftUserDetails.size() > 0){
			responseTO.setStatus(Constant.RESPONSE_SUCCESS);
			responseTO.setUserId(String.valueOf(iPftUserDetails.get(0).getUserId()));
			responseTO.setFnamme(iPftUserDetails.get(0).getName());
			return responseTO;
		}
		responseTO.setStatus(Constant.RESPONSE_FAILURE);
		return responseTO;
	}

	public ResponseTO readDCN(String text) throws Exception{
		List<String> dcnList = null;
		if(text != null && !"".equalsIgnoreCase(text)){
			String dcnListAsStr = ServiceCommanUtil.decrypt(text);
			dcnList = Arrays.asList(dcnListAsStr.split(","));
			if(dcnList != null && dcnList.size() > 0 && dcnList.size() <= Constant.MAX_LIMIT){
				responseTO.setStatus(Constant.RESPONSE_SUCCESS);	
				responseTO.setResponseCodeDescription(Constant.DCN_RETRIVE_SUCCESS);
			}else if(dcnList != null && dcnList.size() > 0 && dcnList.size() >= Constant.MAX_LIMIT){
				responseTO.setStatus(Constant.REQUEST_SUCCCESS);
				responseTO.setResponseCodeDescription(Constant.DCN_REQUEST_PENDING);
			}
		}
		responseTO.setStatus(Constant.RESPONSE_FAILURE);
		return responseTO;
	}
	

}
