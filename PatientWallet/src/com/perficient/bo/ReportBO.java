package com.perficient.bo;

import com.perficient.daoImpl.ReportDAOImpl;
import com.perficient.pojo.PftUploadFileDetails;
import com.perficient.to.ResponseTO;
import java.sql.Blob;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ReportBO {
	
    @Autowired
    private ReportDAOImpl reportDAOImpl;

    public ResponseTO saveFileDetails(String fileName, String userId, Blob blob, String contentType, String doctorId) {
        PftUploadFileDetails details = new PftUploadFileDetails();
        details.setFileName(fileName);
        details.setUserId(Integer.parseInt(userId));
        details.setContent(blob);
        details.setContentType(contentType);
        details.setCreated(new Date());
        details.setDoctorId(Integer.parseInt(doctorId));
        return this.reportDAOImpl.saveFileDetails(details);
    }
}