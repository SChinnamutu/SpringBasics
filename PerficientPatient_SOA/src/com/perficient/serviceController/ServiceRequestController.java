package com.perficient.serviceController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.PerfConstant.Constant;
import com.perficient.bo.RequestBO;
import com.perficient.to.RequestTO;
import com.perficient.to.ResponseTO;
import com.perficient.util.ServiceCommanUtil;

@Controller
public class ServiceRequestController {

	@Autowired
	private RequestBO iRequestBO;
	
	@RequestMapping(value="/serviceSaveRequestDetials")
	@ResponseBody
	public String saveRequestDetials(HttpServletRequest request) throws ParseException{
		ResponseTO responseTO  = null;
		String doctorId = request.getParameter("doctorId");
		String userId = request.getParameter("userId");
		try {
			responseTO = iRequestBO.saveRequestDetials(userId,doctorId);
			if(ServiceCommanUtil.isMandatory(responseTO.getStatus()) && !"".equalsIgnoreCase(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase(Constant.RESPONSE_SUCCESS)){
				responseTO.setStatus(Constant.RESPONSE_SUCCESS);
				responseTO.setResponseCodeDescription(Constant.REQUEST_SUCCCESS);
			}
		} catch (Exception e) {
			responseTO.setStatus(Constant.RESPONSE_FAILURE);
			responseTO.setResponseCodeDescription(Constant.REQUEST_FAILURE);
		}
		return ServiceCommanUtil.convertToJson(responseTO);
	}
	
	@RequestMapping(value="/serviceRequestDetails.do")
	@ResponseBody
	public String getRequestDetails(HttpServletRequest request) throws ParseException{
		String userId,merchantKey = null;
		List<RequestTO> iRequestTOs = null;
		ResponseTO responseTO = new ResponseTO();
		userId = request.getParameter("userId");
		merchantKey = request.getParameter("merchantKey");
		iRequestTOs = iRequestBO.getRequestDetails(merchantKey,userId);
		responseTO.setStatus(Constant.RESPONSE_SUCCESS);
		if(iRequestTOs != null && iRequestTOs.size() > 0){
			responseTO.setResponseData(ServiceCommanUtil.convertToJson(iRequestTOs));
		}else{
			responseTO.setResponseData("No Data Found");
		}
		return ServiceCommanUtil.convertToJson(responseTO);
	}
	
}
