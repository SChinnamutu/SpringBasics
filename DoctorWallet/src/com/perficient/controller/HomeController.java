package com.perficient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.to.Report;
import com.perficient.to.ServiceCreationForm;
import com.perficient.to.SignUpForm;

@Controller
public class HomeController {

	@RequestMapping(value="/getSignUpPage")
	public ModelAndView getSignUpPage(HttpServletRequest request){
		 ModelAndView modelAndView = new ModelAndView();
		 SignUpForm iSignUpForm = new SignUpForm();
		 modelAndView.setViewName("register");
		 modelAndView.addObject("iSignUpForm", iSignUpForm);
		 return modelAndView;
	}
	
	@RequestMapping(value="/getLoginPage.do")
	public ModelAndView getLoginPage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value="/uploadFiles.do")
	public ModelAndView uploadFiles(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		Report iReport =  new Report();
		modelAndView.setViewName("upload");
		modelAndView.addObject("iReport", iReport);
		return modelAndView;
	}
	
	@RequestMapping(value="/getServiceDetails.do")
	public ModelAndView getServiceDetails(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		ServiceCreationForm serviceCreationForm = new ServiceCreationForm();
		modelAndView.addObject("iServiceCreationForm", serviceCreationForm);
		modelAndView.setViewName("service");
		return modelAndView;
	}
}
