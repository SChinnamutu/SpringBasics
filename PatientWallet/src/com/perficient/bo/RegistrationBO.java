 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.daoImpl.AccountDAOImpl
 *  com.perficient.daoImpl.RegistrationDAOimpl
 *  com.perficient.pojo.PftAccountDetails
 *  com.perficient.pojo.PftUserDetails
 *  com.perficient.to.ResponseTO
 *  com.perficient.to.SignUpForm
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 *  org.springframework.stereotype.Service
 */
package com.perficient.bo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.daoImpl.AccountDAOImpl;
import com.perficient.daoImpl.RegistrationDAOimpl;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ResponseTO;
import com.perficient.to.SignUpForm;

@Component
@Service
public class RegistrationBO {
    
	@Autowired
    private RegistrationDAOimpl iRegistrationDAOimpl;
    
	@Autowired
    private AccountDAOImpl iAccountDAOImpl;

    public ResponseTO saveDetails(SignUpForm iSignUpForm) {
        PftUserDetails pftUserDetails = new PftUserDetails();
        pftUserDetails.setName(iSignUpForm.getName());
        pftUserDetails.setPassword(iSignUpForm.getPswd());
        pftUserDetails.setEmail(iSignUpForm.getEmail());
        pftUserDetails.setMobileNumber(iSignUpForm.getMobilenumber());
        pftUserDetails.setRoleId("2");
        iRegistrationDAOimpl.saveDetails(pftUserDetails);
        PftAccountDetails pftAccountDetails = new PftAccountDetails();
        pftAccountDetails.setAccountName("INFOGEM");
        pftAccountDetails.setAccountBalance(100000.0);
        pftAccountDetails.setRemarks("None");
        pftAccountDetails.setPftUserId(new BigDecimal(pftUserDetails.getUserId()));
        pftAccountDetails.setAccountNumber("31394180414");
        return this.iAccountDAOImpl.saveDetails(pftAccountDetails);
    }

    public String checkMobileAlreadyNumberExist(String mobileNumber) {
        List<PftUserDetails> iPftUserDetails = iRegistrationDAOimpl.getUserDetails(mobileNumber);
        if (iPftUserDetails.size() > 0) {
            return "SUCCESS";
        }
        return "FAILURE";
    }
}
