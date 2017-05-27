package com.perficient.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.bo.LoginBO;
import com.perficient.to.ResponseTO;
import com.perficient.util.CommanUtil;

@Controller
public class LoginController {

	@Autowired
	private LoginBO iLoginBO;

	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value="/validateLoginCredintials.do")
	public  ModelAndView validateLoginDetails(HttpServletRequest request) throws ParseException{
		ModelAndView modelAndView  = null;
		ResponseTO responseTO  = null;
		String uname = request.getParameter("uname");
		String pswd = request.getParameter("pswd");
		try {
			responseTO = iLoginBO.validate(uname,pswd);
			if(responseTO != null && CommanUtil.isMandatory(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase(ApplicationConstant.RESPONSE_SUCCESS)){
				httpSession.setAttribute("userId", responseTO.getUserId());
				httpSession.setAttribute("fullName", responseTO.getfName());
				modelAndView = new ModelAndView("redirect:/getRequestDetails.do");
			}else{
				modelAndView = new ModelAndView("errorLogin");
				modelAndView.addObject("message", ApplicationConstant.INVALID_LOGIN_CREDINTIALS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("errorLogin");
			modelAndView.addObject("message", ApplicationConstant.APPLICATION_ERROR);
		}	
		return modelAndView;
	}
}
