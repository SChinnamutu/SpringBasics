package com.perficient.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.bo.ServciceCreationBO;
import com.perficient.to.ServiceCreationForm;


@Controller
public class ServiceCreationController {

	@Autowired
	private ServciceCreationBO iServiceCreationBO;
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value="/saveServiceDetail.do")
	public ModelAndView saveServiceDetail(HttpServletRequest request,@ModelAttribute("iServiceCreationForm") ServiceCreationForm serviceCreationForm, final RedirectAttributes redirectAttributes){
		ModelAndView modelAndView = new ModelAndView("redirect:/getServiceDetails.do");
		httpSession = request.getSession();
		String response = null;
		String userId = null;
		try {
			userId = httpSession.getAttribute("userId").toString();
			response =  iServiceCreationBO.saveServiceCreationDetails(serviceCreationForm, userId);
			redirectAttributes.addFlashAttribute("message", response);
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", ApplicationConstant.APPLICATION_ERROR);
		}
		return modelAndView;
	}
	
}
