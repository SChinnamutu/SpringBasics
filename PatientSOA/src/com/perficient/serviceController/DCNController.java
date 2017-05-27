package com.perficient.serviceController;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.PerfConstant.Constant;
import com.perficient.bo.LoginBO;
import com.perficient.to.ResponseTO;
import com.perficient.util.ServiceCommanUtil;


@Controller
public class DCNController {
	
	@Autowired
	private LoginBO iLoginBO;
	
	
	@RequestMapping(value="/serviceWriteDCN.do")
	@ResponseBody
	public  String validateLoginDetails(HttpServletRequest request,Model model) throws ParseException{
		ResponseTO responseTO  = null;
		String dcnList = request.getParameter("dcnList");
		try {
			responseTO = iLoginBO.readDCN(dcnList);
			if(responseTO != null && ServiceCommanUtil.isMandatory(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase(Constant.RESPONSE_SUCCESS)){
				responseTO.setResponseCodeDescription(Constant.DCN_RETRIVE_SUCCESS);
			}else if(responseTO != null && ServiceCommanUtil.isMandatory(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase(Constant.RESPONSE_PENDING)){
				responseTO.setResponseCodeDescription(Constant.DCN_REQUEST_PENDING);
			}else if(responseTO != null && ServiceCommanUtil.isMandatory(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase(Constant.RESPONSE_FAILURE)){
				responseTO.setResponseCodeDescription(Constant.FILE_NOT_EMPTY);
			}
		} catch (Exception e) {
			responseTO.setStatus(Constant.RESPONSE_FAILURE);
			responseTO.setResponseCodeDescription(Constant.APPLICATION_ERROR);
		}
		return ServiceCommanUtil.convertToJson(responseTO);
	}
	
	
	
	/*
	 * 
	 * @RequestMapping(value = "/criteriaForm", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody ResponseTO criteriaForm){
	    System.out.println(criteriaForm);
	    return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/serviceWriteDCN.do")
	@ResponseBody
	public  String serviceWriteDCN(HttpServletRequest request,Model model) throws ParseException{
		ResponseTO responseTO  = null;
		String uname = request.getParameter("names");
		String file = request.getParameter("file");
		System.out.println("Request is " + uname + " " + file);
		try {
			responseTO = iLoginBO.readDCN(uname);
			if(responseTO != null && ServiceCommanUtil.isMandatory(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase(ApplicationConstant.RESPONSE_SUCCESS)){
				responseTO.setResponseCodeDescription(ApplicationConstant.VALID_LOGIN_CREDINTIAL);
			}else{
				responseTO.setResponseCodeDescription(ApplicationConstant.INVALID_LOGIN_CREDINTIALS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseTO.setResponseCodeDescription(ApplicationConstant.APPLICATION_ERROR);
		}
		return ServiceCommanUtil.convertToJson(responseTO);
	}*/
}
