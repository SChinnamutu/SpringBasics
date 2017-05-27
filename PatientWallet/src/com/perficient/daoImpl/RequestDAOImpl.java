 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.dao.RequestDAO
 *  com.perficient.pojo.PftAppointmentDetails
 *  com.perficient.pojo.PftDoctorDetails
 *  javax.persistence.EntityManager
 *  javax.persistence.PersistenceContext
 *  javax.persistence.Query
 *  org.springframework.stereotype.Component
 *  org.springframework.transaction.annotation.Transactional
 */
package com.perficient.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.pojo.PftAppointmentDetails;
import com.perficient.pojo.PftDoctorDetails;

@Component
@Transactional
public class RequestDAOImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public PftDoctorDetails saveRequestDetials(String doctorId) {
        PftDoctorDetails iPftDoctorDetail = null;
        Query query = null;
        try {
            query = this.entityManager.createQuery("from PftDoctorDetails where doctorId=:doctorId");
            query.setParameter("doctorId", (Object)doctorId);
            iPftDoctorDetail = (PftDoctorDetails)query.getSingleResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return iPftDoctorDetail;
    }

    public void attachDirty(PftDoctorDetails pftDoctorDetails) {
        try {
            this.entityManager.merge((Object)pftDoctorDetails);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public void attachDirty(PftAccountDetails pftAccountDetails) {
        try {
            this.entityManager.merge((Object)pftAccountDetails);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void attachDirty(PftAppointmentDetails pftAppointmentDetails) {
        try {
            this.entityManager.merge((Object)pftAppointmentDetails);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    
    public void save(PftAppointmentDetails pftAppointDetails) {
        try {
            this.entityManager.persist((Object)pftAppointDetails);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
	public List<PftAppointmentDetails> getAppointDetails(BigDecimal userId) {
        List<PftAppointmentDetails> iPftAppointDetails = null;
        Query query = null;
        try {
            query = this.entityManager.createQuery("from PftAppointmentDetails where pmadUserId=:userId");
            query.setParameter("userId", (Object)userId);
            iPftAppointDetails = query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return iPftAppointDetails;
    }
    
    @SuppressWarnings("unchecked")
	public List<PftAppointmentDetails> getAppointDetails() {
        List<PftAppointmentDetails> iPftAppointDetails = null;
        Query query = null;
        try {
            query = this.entityManager.createQuery("from PftAppointmentDetails and status !=:status");
           // query.setParameter("userId", (Object)userId);
            query.setParameter("status", ApplicationConstant.AVAILABLE);
            iPftAppointDetails = query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return iPftAppointDetails;
    }
}
