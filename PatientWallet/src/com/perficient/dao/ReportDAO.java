package com.perficient.dao;

import com.perficient.pojo.PftUploadFileDetails;
import com.perficient.to.ResponseTO;



public interface ReportDAO {

	ResponseTO saveFileDetails(PftUploadFileDetails details);
	
}
