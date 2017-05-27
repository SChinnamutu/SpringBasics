package com.perficient.serviceController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.PerfConstant.Constant;
import com.perficient.bo.RegistrationBO;
import com.perficient.to.ResponseTO;
import com.perficient.util.ServiceCommanUtil;


@Controller
public class ServiceRegistrationController {

	@Autowired
	private RegistrationBO iSignUpBO;
			
	@RequestMapping(value="/serviceSaveSignUpDetails")
	@ResponseBody
	public String saveSignUpDetails(HttpServletRequest request) throws org.json.simple.parser.ParseException{
		ResponseTO responseTO =  new ResponseTO();
		String userName = request.getParameter("name");
		String pswd = request.getParameter("pswd");
		String mobileNumber = request.getParameter("mobileNumber");
		String email = request.getParameter("email");
		try {
			responseTO =  iSignUpBO.saveDetails(userName,pswd,mobileNumber,email);
			if(responseTO != null && responseTO.getStatus()!= null && responseTO.getStatus().equalsIgnoreCase(Constant.RESPONSE_SUCCESS)){
				responseTO.setResponseCodeDescription(Constant.SIGNUP_SUCCESS);
			}
		} catch (Exception e) {
			responseTO.setStatus(Constant.RESPONSE_SUCCESS);
			responseTO.setResponseCodeDescription(Constant.APPLICATION_ERROR);
		}
		return ServiceCommanUtil.convertToJson(responseTO);
	}
}
