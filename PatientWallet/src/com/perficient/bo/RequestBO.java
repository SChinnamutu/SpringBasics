 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.daoImpl.AccountDAOImpl
 *  com.perficient.daoImpl.RequestDAOImpl
 *  com.perficient.daoImpl.ViewAppointmentDAOImpl
 *  com.perficient.pojo.PftAccountDetails
 *  com.perficient.pojo.PftAppointmentDetails
 *  com.perficient.pojo.PftDoctorDetails
 *  com.perficient.to.RequestTO
 *  com.perficient.to.ResponseTO
 *  com.perficient.util.CommanUtil
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 *  org.springframework.stereotype.Service
 */
package com.perficient.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.daoImpl.AccountDAOImpl;
import com.perficient.daoImpl.RequestDAOImpl;
import com.perficient.daoImpl.ViewAppointmentDAOImpl;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.pojo.PftAppointmentDetails;
import com.perficient.pojo.PftDoctorDetails;
import com.perficient.to.RequestTO;
import com.perficient.to.ResponseTO;
import com.perficient.util.CommanUtil;

@Component
@Service
public class RequestBO {
    @Autowired
    private RequestDAOImpl iRequestDAOImpl;
    @Autowired
    private ViewAppointmentDAOImpl viewAppointmentDAOImpl;
    @Autowired
    private AccountDAOImpl accountDAOImpl;

    public List<RequestTO> getRequestDetails(String userId) {
        List<PftAppointmentDetails> iPftAppointDetails = this.iRequestDAOImpl.getAppointDetails(new BigDecimal(userId));
        ArrayList<RequestTO> iAppointTOs = new ArrayList<RequestTO>();
        PftAppointmentDetails iPftAppointDetail = null;
        Iterator<PftAppointmentDetails> iterator = iPftAppointDetails.iterator();
        while (iterator.hasNext()) {
            RequestTO requestTO = new RequestTO();
            iPftAppointDetail = (PftAppointmentDetails)iterator.next();
            requestTO.setDoctorId(iPftAppointDetail.getDoctorId());
            requestTO.setDoctorName(iPftAppointDetail.getDoctorName());
            requestTO.setDoctorLocation(iPftAppointDetail.getDoctorLocation());
            requestTO.setFixedTime(iPftAppointDetail.getFixedTime());
            requestTO.setAppointmentDate(CommanUtil.convertDateToFormat((Date)iPftAppointDetail.getAppointmentDate(), (String)"dd/MM/yyyy"));
            requestTO.setStatus(iPftAppointDetail.getStatus());
            requestTO.setRaisedDate(CommanUtil.convertDateToFormat((Date)iPftAppointDetail.getRaisedDate(), (String)"dd/MM/yyyy HH:mm:ss"));
            iAppointTOs.add(requestTO);
        }
        return iAppointTOs;
    }

    public ResponseTO saveRequestDetials(String loginUserId, String doctorId) {
        List<PftAccountDetails> accountDetails = this.accountDAOImpl.getAccountDetails(new BigDecimal(loginUserId));
        PftDoctorDetails pftDoctorDetails = null;
        ResponseTO responseTO = new ResponseTO();
        for (PftAccountDetails pftAccountDetails : accountDetails) {
            if (pftAccountDetails == null) continue;
            pftDoctorDetails = this.viewAppointmentDAOImpl.getDoctorDetail(doctorId);
            if (pftAccountDetails.getAccountBalance() >= (double)pftDoctorDetails.getDoctorCharge()) {
                PftAppointmentDetails pftAppointDetails = new PftAppointmentDetails();
                pftAppointDetails.setDoctorName(pftDoctorDetails.getDoctorName());
                pftAppointDetails.setDoctorLocation(pftDoctorDetails.getDoctorLocation());
                pftAppointDetails.setPmadUserId(new BigDecimal(loginUserId));
                pftAppointDetails.setDoctorId(pftDoctorDetails.getDoctorId());
                pftAppointDetails.setRaisedDate(new Date());
                pftAppointDetails.setAppointmentDate(CommanUtil.convertStringToDate((String)pftDoctorDetails.getDoctorAvailDate(), (String)"dd-MM-yyyy"));
                pftAppointDetails.setFixedTime(pftDoctorDetails.getAppointments());
                pftAppointDetails.setStatus("Pending");
                pftAppointDetails.setAppointmentDate(new Date());
                pftAccountDetails.setAccountBalance(pftAccountDetails.getAccountBalance() - (double)pftDoctorDetails.getDoctorCharge());
                this.iRequestDAOImpl.save(pftAppointDetails);
                pftDoctorDetails.setStatus("N");
                this.iRequestDAOImpl.attachDirty(pftDoctorDetails);
                return this.accountDAOImpl.updateDetails(pftAccountDetails);
            }
            responseTO.setStatus("FAILURE");
            responseTO.setResponseCodeDescription("Insufficient Wallet Balance. Please recharge your account.");
        }
        return responseTO;
    }
}
 