 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.daoImpl.AccountDAOImpl
 *  com.perficient.daoImpl.ReportDAOImpl
 *  com.perficient.pojo.PftAccountDetails
 *  com.perficient.pojo.PftAppointmentDetails
 *  com.perficient.to.AccountTO
 *  com.perficient.to.Report
 *  com.perficient.to.ResponseTO
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 *  org.springframework.stereotype.Service
 */
package com.perficient.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.daoImpl.AccountDAOImpl;
import com.perficient.daoImpl.ReportDAOImpl;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.pojo.PftAppointmentDetails;
import com.perficient.to.AccountTO;
import com.perficient.to.Report;
import com.perficient.to.ResponseTO;

@Component
@Service
public class AccountBO {
    
	@Autowired
    private AccountDAOImpl iAccountDAOImpl;
    @Autowired
    private ReportDAOImpl reportDAOImpl;

    public ResponseTO saveDetails(String amount, String remarks, String userId) {
        PftAccountDetails pftAccountDetails = this.iAccountDAOImpl.getUserSpecificAccountDetails(new BigDecimal(userId));
        pftAccountDetails.setAccountBalance(new Double(amount).doubleValue());
        pftAccountDetails.setRemarks(remarks);
        pftAccountDetails.setAccountName("INFOGEM");
        pftAccountDetails.setPftUserId(new BigDecimal(userId));
        return this.iAccountDAOImpl.saveDetails(pftAccountDetails);
    }

    public ResponseTO getAccountDetails(String userId) {
        ResponseTO responseTO = new ResponseTO();
        List<PftAccountDetails> iPftAccountDetails = this.iAccountDAOImpl.getAccountDetails(new BigDecimal(userId));
        ArrayList<AccountTO> iAccountTOs = new ArrayList<AccountTO>();
        PftAccountDetails iPftAccountDetail = null;
        Iterator<PftAccountDetails> iterator = iPftAccountDetails.iterator();
        while (iterator.hasNext()) {
            AccountTO accountTO = new AccountTO();
            iPftAccountDetail = (PftAccountDetails)iterator.next();
            accountTO.setAccountBalance(String.valueOf(iPftAccountDetail.getAccountBalance()));
            accountTO.setRemarks(iPftAccountDetail.getRemarks());
            accountTO.setAccountName(iPftAccountDetail.getAccountName());
            accountTO.setAccountNumber(iPftAccountDetail.getAccountNumber());
            if (iPftAccountDetail.getAccountBalance() >= 0.0) {
                accountTO.setIsAmountAvailable("Y");
            } else {
                responseTO.setResponseCodeDescription("Insufficient Wallet Balance. Please recharge your account.");
            }
            iAccountTOs.add(accountTO);
        }
        responseTO.setiAccountTOs(iAccountTOs);
        responseTO.setStatus("SUCCESS");
        return responseTO;
    }

    public Report getReportDoctor(String doctorId) {
        Report report = new Report();
        ArrayList<String> ids = new ArrayList<String>();
        List<PftAppointmentDetails> iPftUploadFileDetails = this.reportDAOImpl.getReportDoctor(doctorId);
        for (PftAppointmentDetails pftUploadFileDetails : iPftUploadFileDetails) {
            ids.add(String.valueOf(pftUploadFileDetails.getDoctorId()));
        }
        report.setDoctors(ids);
        return report;
    }
}
