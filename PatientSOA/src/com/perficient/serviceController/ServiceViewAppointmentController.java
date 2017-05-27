package com.perficient.serviceController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.PerfConstant.Constant;
import com.perficient.bo.viewAppointmentBO;
import com.perficient.to.AppointTO;
import com.perficient.to.ResponseTO;
import com.perficient.util.ServiceCommanUtil;


@Controller
public class ServiceViewAppointmentController {

	
	@Autowired
	private viewAppointmentBO iViewBO;
	
	@RequestMapping(value="/serviceAllDetails.do")
	@ResponseBody
	public String viewAppointmentDetails(HttpServletRequest  request) throws ParseException{
		ResponseTO responseTO = new ResponseTO();
		List<AppointTO> tos = null;
		try {
			tos =  iViewBO.retriveDetails();
			responseTO.setStatus(Constant.RESPONSE_SUCCESS);
			responseTO.setResponseData(ServiceCommanUtil.convertToJson(tos));
		} catch (Exception e) {
			e.printStackTrace();
			responseTO.setStatus(Constant.RESPONSE_FAILURE);
		} 
		return ServiceCommanUtil.convertToJson(responseTO);
	}

	
}
