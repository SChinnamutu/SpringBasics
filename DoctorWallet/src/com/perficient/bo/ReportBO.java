package com.perficient.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.perficient.daoImpl.ReportDAOImpl;
import com.perficient.pojo.PftUploadFileDetails;
import com.perficient.to.ResponseTO;


@Component
public class ReportBO {

	@Autowired
	private ReportDAOImpl reportDAOImpl;
	
	public ResponseTO saveFileDetails(String fileName, String userId) {
		PftUploadFileDetails details = new PftUploadFileDetails();
		details.setFileName(fileName);
		details.setUserId(Integer.parseInt(userId));
		return reportDAOImpl.saveFileDetails(details);
	}

	
	
}
