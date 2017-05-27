 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.applicationConstant.ApplicationConstant
 *  com.perficient.bo.RegistrationBO
 *  com.perficient.to.ResponseTO
 *  com.perficient.to.SignUpForm
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.ModelAttribute
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package com.perficient.controller;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.bo.RegistrationBO;
import com.perficient.to.ResponseTO;
import com.perficient.to.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationBO iRegistrationBO;

    @RequestMapping(value={"/saveSignUpDetails"})
    public ModelAndView saveSignUpDetails(@ModelAttribute(value="iSignUpForm") SignUpForm signUpForm, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/getLoginPage.do");
        ResponseTO responseTO = new ResponseTO();
        try {
            responseTO = this.iRegistrationBO.saveDetails(signUpForm);
            if (responseTO != null && responseTO.getStatus() != null && responseTO.getStatus().equalsIgnoreCase("SUCCESS")) {
                redirectAttributes.addFlashAttribute("message", ApplicationConstant.SIGNUP_SUCCESS);
            } else {
                redirectAttributes.addFlashAttribute("message", ApplicationConstant.SIGNUP_FAILURE);
            }
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", (Object)"Application is busy.Please try after some time");
        }
        return modelAndView;
    }

    @RequestMapping(value={"/checkMobileAlreadyNumberExist.do"})
    @ResponseBody
    public String checkMobileAlreadyNumberExist(@RequestParam(value="mobileNumber") String mobileNumber) {
        String response = null;
        try {
            response = this.iRegistrationBO.checkMobileAlreadyNumberExist(mobileNumber);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}