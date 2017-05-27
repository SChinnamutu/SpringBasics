package com.perficient.serviceController;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.PerfConstant.Constant;
import com.perficient.bo.LoginBO;
import com.perficient.to.ResponseTO;
import com.perficient.util.ServiceCommanUtil;

@Controller
public class ServiceLoginController {

	@Autowired
	private LoginBO iLoginBO;
	
	//@Autowired
	//private ServiceValidityUtility iServiceValidityUtility;

	@RequestMapping(value="/serviceValidateLoginCredintials.do")
	@ResponseBody
	public  String validateLoginDetails(HttpServletRequest request) throws ParseException{
		//String serviceName = "serviceValidateLoginCredintials.do";
		ResponseTO responseTO  = null;
		String uname = request.getParameter("uname");
		String pswd = request.getParameter("pswd");
		//String errorJson = null;
		try {
			/*if( (errorJson = iServiceValidityUtility.validateInputParameter(request,serviceName)) != null){
				return errorJson;
			}*/
			responseTO = iLoginBO.validate(uname,pswd);
			if(responseTO != null && ServiceCommanUtil.isMandatory(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase(Constant.RESPONSE_SUCCESS)){
				responseTO.setResponseCodeDescription(Constant.VALID_LOGIN_CREDINTIAL);
			}else{
				responseTO.setResponseCodeDescription(Constant.INVALID_LOGIN_CREDINTIALS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseTO.setResponseCodeDescription(Constant.APPLICATION_ERROR);
		}
		return ServiceCommanUtil.convertToJson(responseTO);
	}
}
