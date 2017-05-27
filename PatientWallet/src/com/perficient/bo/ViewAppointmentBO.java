 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.daoImpl.ViewAppointmentDAOImpl
 *  com.perficient.pojo.PftDoctorDetails
 *  com.perficient.to.AppointTO
 *  com.perficient.to.ResponseTO
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 *  org.springframework.stereotype.Service
 */
package com.perficient.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.daoImpl.ViewAppointmentDAOImpl;
import com.perficient.pojo.PftDoctorDetails;
import com.perficient.to.AppointTO;
import com.perficient.to.ResponseTO;

@Component
@Service
public class ViewAppointmentBO {
    @Autowired
    private ViewAppointmentDAOImpl iViewDAOImpl;

    public List<AppointTO> getAvailDoctorDetails() {
        List<PftDoctorDetails> details = this.iViewDAOImpl.getAvailDoctorDetails();
        return this.getDetails(details);
    }

    public List<AppointTO> getDetails(List<PftDoctorDetails> details) {
        ArrayList<AppointTO> appointTOs = new ArrayList<AppointTO>();
        for (PftDoctorDetails pftDoctorDetails : details) {
            AppointTO appointTO = new AppointTO();
            appointTO.setName(pftDoctorDetails.getDoctorName());
            appointTO.setLocation(pftDoctorDetails.getDoctorLocation());
            appointTO.setTime(pftDoctorDetails.getAppointments());
            appointTO.setDoctorId(pftDoctorDetails.getId());
            appointTO.setFees(pftDoctorDetails.getDoctorCharge());
            appointTO.setDate(pftDoctorDetails.getDoctorAvailDate());
            appointTO.setService(pftDoctorDetails.getService());
            appointTOs.add(appointTO);
        }
        return appointTOs;
    }

    public ResponseTO saveFixedTimeDetails(String userId, String doctorId) {
        PftDoctorDetails iPftDoctorDetails = this.iViewDAOImpl.getDoctorDetail(userId);
        iPftDoctorDetails.setStatus("Y");
        return this.iViewDAOImpl.updateDetails(iPftDoctorDetails);
    }
}
