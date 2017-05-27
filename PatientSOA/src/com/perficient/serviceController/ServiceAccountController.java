package com.perficient.serviceController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.PerfConstant.Constant;
import com.perficient.bo.AccountBO;
import com.perficient.to.AccountTO;
import com.perficient.to.ResponseTO;
import com.perficient.util.ServiceCommanUtil;

@Controller
public class ServiceAccountController {

	@Autowired
	private AccountBO iAccountBO;

	
	@RequestMapping(value="/serviceAccountDetails.do")
	@ResponseBody
	public String getAccountDetails(HttpServletRequest request) throws ParseException{
		ResponseTO responseTO = new ResponseTO();
		List<AccountTO> iAccountTOs = null;
		String userId = request.getParameter("userId");
		try {
			iAccountTOs = iAccountBO.getAccountDetails(userId);
			if(iAccountTOs != null && iAccountTOs.size() > 0){
				responseTO.setStatus(Constant.RESPONSE_SUCCESS);
				responseTO.setResponseData(ServiceCommanUtil.convertToJson(iAccountTOs));
				responseTO.setResponseCodeDescription(ServiceCommanUtil.convertToJson(responseTO));
			}else{
				responseTO.setStatus(Constant.RESPONSE_SUCCESS);
				responseTO.setResponseCodeDescription(ServiceCommanUtil.convertToJson(Constant.NO_DATA_FOUND));
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseTO.setStatus(Constant.RESPONSE_FAILURE);
		}
		return ServiceCommanUtil.convertToJson(responseTO);
	}
	
	@RequestMapping(value="/serviceAddAmount.do")
	@ResponseBody
	public String addAmount(HttpServletRequest request) throws ParseException{
		ResponseTO responseTO = null;
		String amount = request.getParameter("accountBalance");
		String remarks = request.getParameter("remarks");
		String userId = request.getParameter("userId");
		try {
			responseTO = iAccountBO.saveDetails(amount,remarks,userId);
			if(responseTO != null && responseTO.getStatus() != null && !"".equalsIgnoreCase(responseTO.getStatus())
					&& responseTO.getStatus().equalsIgnoreCase(Constant.RESPONSE_SUCCESS)){
				responseTO.setResponseCodeDescription(Constant.AMOUNT_ADDED_SUCCESSFULLY);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseTO.setResponseCodeDescription(Constant.APPLICATION_ERROR);
		}
		return ServiceCommanUtil.convertToJson(responseTO);
	}	
 
}
