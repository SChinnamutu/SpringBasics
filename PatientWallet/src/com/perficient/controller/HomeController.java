 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.bo.AccountBO
 *  com.perficient.to.Report
 *  com.perficient.to.SignUpForm
 *  com.perficient.util.CommanUtil
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 *  org.json.simple.parser.ParseException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 */
package com.perficient.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.bo.AccountBO;
import com.perficient.to.Report;
import com.perficient.to.SignUpForm;
import com.perficient.util.CommanUtil;

@Controller
public class HomeController {
    @Autowired
    private AccountBO iAccountBO;

    @RequestMapping(value={"/getSignUpPage"})
    public ModelAndView getSignUpPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        SignUpForm iSignUpForm = new SignUpForm();
        modelAndView.setViewName("register");
        modelAndView.addObject("iSignUpForm", (Object)iSignUpForm);
        return modelAndView;
    }

    @RequestMapping(value={"/getLoginPage.do"})
    public ModelAndView getLoginPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value={"/uploadFiles.do"})
    public ModelAndView uploadFiles(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Report iReport = new Report();
        try {
            modelAndView.addObject("iReport", (Object)iReport);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("upload");
        return modelAndView;
    }

    @RequestMapping(value={"/getReportDoctor.do"})
    @ResponseBody
    public String getReportDoctor(HttpServletRequest request) throws ParseException {
        Report iReport = null;
        HttpSession httpSession = null;
        ArrayList<String> doctors = new ArrayList<String>();
        try {
            httpSession = request.getSession();
            String userId = httpSession.getAttribute("userId").toString();
            iReport = this.iAccountBO.getReportDoctor(userId);
            doctors.addAll(iReport.getDoctors());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return CommanUtil.convertToJson(doctors);
    }
}

