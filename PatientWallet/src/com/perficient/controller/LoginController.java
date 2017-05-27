 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.bo.LoginBO
 *  com.perficient.to.ResponseTO
 *  com.perficient.util.CommanUtil
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 *  org.json.simple.parser.ParseException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.servlet.ModelAndView
 */
package com.perficient.controller;

import com.perficient.bo.LoginBO;
import com.perficient.to.ResponseTO;
import com.perficient.util.CommanUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private LoginBO iLoginBO;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping(value={"/validateLoginCredintials.do"})
    public ModelAndView validateLoginDetails(HttpServletRequest request) throws ParseException {
        ModelAndView modelAndView = null;
        ResponseTO responseTO = null;
        String uname = request.getParameter("uname");
        String pswd = request.getParameter("pswd");
        try {
            responseTO = this.iLoginBO.validate(uname, pswd);
            if (responseTO != null && CommanUtil.isMandatory((String)responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase("SUCCESS")) {
                this.httpSession.setAttribute("userId", (Object)responseTO.getUserId());
                this.httpSession.setAttribute("fullName", (Object)responseTO.getfName());
                modelAndView = new ModelAndView("redirect:/getAllDetails.do");
            } else {
                modelAndView = new ModelAndView("errorLogin");
                modelAndView.addObject("message", (Object)"Please enter the valid login credintials.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("errorLogin");
            modelAndView.addObject("message", (Object)"Application is busy.Please try after some time");
        }
        return modelAndView;
    }
}
