package com.perficient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.bo.RegistrationBO;
import com.perficient.to.ResponseTO;
import com.perficient.to.SignUpForm;


@Controller
public class RegistrationController {

	@Autowired
	private RegistrationBO iRegistrationBO;
			
	@RequestMapping(value="/saveSignUpDetails")
	public ModelAndView saveSignUpDetails(@ModelAttribute("iSignUpForm") SignUpForm signUpForm,RedirectAttributes  redirectAttributes){
		ModelAndView modelAndView = new ModelAndView("redirect:/getLoginPage.do");
		ResponseTO responseTO =  new ResponseTO();
		try {
			responseTO =  iRegistrationBO.saveDetails(signUpForm);
			if(responseTO != null && responseTO.getStatus()!= null && responseTO.getStatus().equalsIgnoreCase(ApplicationConstant.RESPONSE_SUCCESS)){
				
				redirectAttributes.addFlashAttribute("message", ApplicationConstant.SIGNUP_SUCCESS);
			}else{
				redirectAttributes.addFlashAttribute("message", ApplicationConstant.SIGNUP_FAILURE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", ApplicationConstant.APPLICATION_ERROR);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/checkMobileAlreadyNumberExist.do")
	@ResponseBody
	public String checkMobileAlreadyNumberExist(@RequestParam("mobileNumber") String mobileNumber){
		String response = null;
		try {
			response = iRegistrationBO.checkMobileAlreadyNumberExist(mobileNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
}
