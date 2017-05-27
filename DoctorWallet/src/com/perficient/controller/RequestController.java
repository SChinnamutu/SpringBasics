package com.perficient.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.bo.RequestBO;
import com.perficient.to.RequestTO;
import com.perficient.to.ResponseTO;
import com.perficient.to.SignUpForm;
import com.perficient.util.CommanUtil;

@Controller
public class RequestController {

	@Autowired
	private RequestBO iRequestBO;
	
	@Autowired
	private HttpSession httpSession;
	
	
	@RequestMapping(value="/getRequestDetails.do")
	public ModelAndView getRequestDetails(HttpServletRequest request){
		ModelAndView  modelAndView  = new ModelAndView("appointmentView");	
		String userId = null;
		List<RequestTO> iRequestTOs = null;
		httpSession = request.getSession();
		try {
			userId = httpSession.getAttribute("userId").toString();
			iRequestTOs = iRequestBO.getRequestDetails(userId);
			modelAndView.addObject("tos", iRequestTOs);
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("message", ApplicationConstant.APPLICATION_ERROR);
		}
		SignUpForm signUpForm = new SignUpForm();
		modelAndView.addObject("signUpForm", signUpForm);
		return modelAndView;
	}
	
	

	@RequestMapping(value="/declineRequest.do")
	public ModelAndView declineRequest(HttpServletRequest request, final RedirectAttributes redirectAttributes){
		ModelAndView modelAndView  = new ModelAndView("redirect:/getRequestDetails.do");	
		String requestId = null;
		ResponseTO responseTO = null;
		try {
			requestId =  request.getParameter("id");
			responseTO = iRequestBO.declineRequest(requestId);
			if(responseTO != null && CommanUtil.isMandatory(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase(ApplicationConstant.RESPONSE_SUCCESS)){
				redirectAttributes.addFlashAttribute("message", ApplicationConstant.REQUEST_DECLINE_SUCCESS);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", ApplicationConstant.APPLICATION_ERROR);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/acceptRequest.do")
	public ModelAndView acceptRequest(HttpServletRequest request, final RedirectAttributes redirectAttributes){
		ModelAndView modelAndView  = new ModelAndView("redirect:/getRequestDetails.do");	
		String requestId = null;
		ResponseTO responseTO = null;
		try {
			requestId =  request.getParameter("id");
			responseTO = iRequestBO.acceptRequest(requestId);
			if(responseTO != null && CommanUtil.isMandatory(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase(ApplicationConstant.RESPONSE_SUCCESS)){
				redirectAttributes.addFlashAttribute("message", ApplicationConstant.REQUEST_ACCEPT_SUCCESS);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", ApplicationConstant.APPLICATION_ERROR);
		}
		return modelAndView;
	}
	
}
