package com.perficient.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.bo.AccountBO;
import com.perficient.to.ResponseTO;
import com.perficient.util.CommanUtil;

@Controller
public class AccountController {

	@Autowired
	private AccountBO iAccountBO;

	@Autowired
	private HttpSession session;
	
	
	@RequestMapping(value="/getAccountDetails.do")
	public ModelAndView getAccountDetails(HttpServletRequest request){
		ModelAndView  modelAndView  = new ModelAndView("accountView");
		String userId = null;
		ResponseTO responseTO = null;
		session = request.getSession();
		try {
			userId = session.getAttribute("userId").toString();
			responseTO = iAccountBO.getAccountDetails(userId);
			if(responseTO != null && !"".equalsIgnoreCase(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase(ApplicationConstant.RESPONSE_SUCCESS)){
				modelAndView.addObject("iAccountTO", responseTO.getiAccountTOs());
				if(CommanUtil.isMandatory(responseTO.getResponseCodeDescription())){
					modelAndView.addObject("message", ApplicationConstant.INSUFFICIENT_WALLET_BALANCE);
				}
			}
		} catch (Exception e) {
			modelAndView.addObject("message", ApplicationConstant.APPLICATION_ERROR);
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/addAmount.do")
	public ModelAndView addAmount(HttpServletRequest request){
		ModelAndView  view  = new ModelAndView("redirect:/getAccountDetails.do");
		String amount = request.getParameter("accountBalance");
		String remarks = request.getParameter("remarks");
		String userId = null;
		try {
			session = request.getSession();
			userId = session.getAttribute("userId").toString();
			ResponseTO responseTO = iAccountBO.saveDetails(amount,remarks,userId);
			if(responseTO != null && responseTO.getStatus() != null && !"".equalsIgnoreCase(responseTO.getStatus())
					&& responseTO.getStatus().equalsIgnoreCase(ApplicationConstant.RESPONSE_SUCCESS)){
				view.addObject("message", ApplicationConstant.RESPONSE_SUCCESS);
			}else{
				view.addObject("message", ApplicationConstant.RESPONSE_FAILURE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			view.addObject("message", ApplicationConstant.APPLICATION_ERROR);
		}
		return view;
	}	
 
}
