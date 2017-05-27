 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.bo.ViewAppointmentBO
 *  com.perficient.to.ResponseTO
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

import com.perficient.bo.ViewAppointmentBO;
import com.perficient.to.AppointTO;
import com.perficient.to.ResponseTO;

@Controller
public class ViewAppointmentController {
    @Autowired
    private ViewAppointmentBO iViewAppointmentBO;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping(value={"/getAllDetails.do"})
    public ModelAndView viewAppointmentDetails(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("viewDetails");
        List<AppointTO> tos = null;
        this.httpSession = request.getSession();
        try {
            tos = this.iViewAppointmentBO.getAvailDoctorDetails();
            modelAndView.addObject("tos", (Object)tos);
            modelAndView.addObject("fullName", this.httpSession.getAttribute("fullName"));
        }
        catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("message", (Object)"Application is busy.Please try after some time");
        }
        return modelAndView;
    }

    @RequestMapping(value={"/saveFixedTimeDetails.do"})
    public ModelAndView saveTimieDetails(HttpServletRequest request) {
        String doctorId = request.getParameter("doctorId");
        ModelAndView view = new ModelAndView("redirect:/getAllDetails");
        ResponseTO responseTO = new ResponseTO();
        try {
            this.httpSession = request.getSession();
            responseTO = this.iViewAppointmentBO.saveFixedTimeDetails(this.httpSession.getAttribute("userId").toString(), doctorId);
            view.addObject("message", (Object)responseTO.getStatus());
        }
        catch (Exception e) {
            e.printStackTrace();
            view.addObject("message", (Object)"Application is busy.Please try after some time");
        }
        return view;
    }
}
