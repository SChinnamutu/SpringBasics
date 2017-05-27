 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.bo.RequestBO
 *  com.perficient.bo.ViewAppointmentBO
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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.bo.RequestBO;
import com.perficient.bo.ViewAppointmentBO;
import com.perficient.to.AppointTO;
import com.perficient.to.RequestTO;
import com.perficient.to.ResponseTO;
import com.perficient.util.CommanUtil;

@Controller
public class RequestController {
	
    @Autowired
    private RequestBO iRequestBO;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private ViewAppointmentBO viewAppointmentBO;

    @RequestMapping(value={"/saveRequestDetials"})
    public ModelAndView saveRequestDetials(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("viewDetails");
        String doctorId = request.getParameter("doctorId");
        this.httpSession = request.getSession();
        List<AppointTO> tos = null;
        String loginUserId = null;
        try {
            loginUserId = this.httpSession.getAttribute("userId").toString();
            ResponseTO responseTO = this.iRequestBO.saveRequestDetials(loginUserId, doctorId);
            if (CommanUtil.isMandatory((String)responseTO.getStatus()) && !"".equalsIgnoreCase(responseTO.getStatus()) && responseTO.getStatus().equalsIgnoreCase("SUCCESS")) {
                modelAndView.addObject("message", (Object)"Your aapointment is fixed successfully");
            } else {
                modelAndView.addObject("message", (Object)responseTO.getResponseCodeDescription());
            }
        }
        catch (Exception e) {
            modelAndView = new ModelAndView("viewDetails");
            modelAndView.addObject("message", (Object)"Application is busy.Please try after some time");
        }
        tos = viewAppointmentBO.getAvailDoctorDetails();
        modelAndView.addObject("tos", (Object)tos);
        return modelAndView;
    }

    @RequestMapping(value={"/getRequestDetails.do"})
    public ModelAndView getRequestDetails(HttpServletRequest request) {
        ModelAndView  modelAndView = new ModelAndView("appointmentView");
        String userId = null;
        List<RequestTO> iRequestTOs = null;
        this.httpSession = request.getSession();
        try {
            userId = this.httpSession.getAttribute("userId").toString();
            iRequestTOs = this.iRequestBO.getRequestDetails(userId);
            modelAndView.addObject("tos", (Object)iRequestTOs);
        }
        catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("message", ApplicationConstant.APPLICATION_ERROR);
        }
        return modelAndView;
    }
}
