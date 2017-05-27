 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.daoImpl.LoginDAOImpl
 *  com.perficient.pojo.PftUserDetails
 *  com.perficient.to.ResponseTO
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 *  org.springframework.stereotype.Service
 */
package com.perficient.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.daoImpl.LoginDAOImpl;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ResponseTO;

@Component
@Service
public class LoginBO {
    @Autowired
    private LoginDAOImpl iLoginDAOImpl;

    public ResponseTO validate(String uname, String pswd) {
        ResponseTO responseTO = new ResponseTO();
        List<PftUserDetails> iPftUserDetails = this.iLoginDAOImpl.validate(uname, pswd);
        if (iPftUserDetails != null && iPftUserDetails.size() > 0) {
            responseTO.setStatus("SUCCESS");
            responseTO.setUserId(String.valueOf(((PftUserDetails)iPftUserDetails.get(0)).getUserId()));
            responseTO.setfName(((PftUserDetails)iPftUserDetails.get(0)).getName());
            return responseTO;
        }
        responseTO.setStatus("FAILURE");
        return responseTO;
    }
}
