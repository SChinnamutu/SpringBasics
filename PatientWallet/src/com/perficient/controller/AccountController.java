 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.bo.AccountBO
 *  com.perficient.to.ResponseTO
 *  com.perficient.util.CommanUtil
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.servlet.ModelAndView
 */
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

    @RequestMapping(value={"/getAccountDetails.do"})
    public ModelAndView getAccountDetails(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("accountView");
        String userId = null;
        ResponseTO responseTO = null;
        this.session = request.getSession();
        try {
            userId = this.session.getAttribute("userId").toString();
            responseTO = this.iAccountBO.getAccountDetails(userId);
            if (responseTO != null && !"".equalsIgnoreCase(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase("SUCCESS")) {
                modelAndView.addObject("iAccountTO", (Object)responseTO.getiAccountTOs());
                if (CommanUtil.isMandatory((String)responseTO.getResponseCodeDescription())) {
                    modelAndView.addObject("message", ApplicationConstant.INSUFFICIENT_WALLET_BALANCE);
                }
            }
        }
        catch (Exception e) {
            modelAndView.addObject("message",ApplicationConstant.APPLICATION_ERROR);
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value={"/addAmount.do"})
    public ModelAndView addAmount(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("redirect:/getAccountDetails.do");
        String amount = request.getParameter("accountBalance");
        String remarks = request.getParameter("remarks");
        String userId = null;
        try {
            this.session = request.getSession();
            userId = this.session.getAttribute("userId").toString();
            ResponseTO responseTO = this.iAccountBO.saveDetails(amount, remarks, userId);
            if (responseTO != null && responseTO.getStatus() != null && !"".equalsIgnoreCase(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase("SUCCESS")) {
                view.addObject("message", (Object)"SUCCESS");
            } else {
                view.addObject("message", (Object)"FAILURE");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            view.addObject("message", ApplicationConstant.APPLICATION_ERROR);
        }
        return view;
    }
}

