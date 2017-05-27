package com.perficient.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.bo.ReportBO;
import com.perficient.bo.RequestBO;
import com.perficient.to.Report;
import com.perficient.to.ResponseTO;


@Controller
public class ReportController {

	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ReportBO iReportBO;
	
	@Autowired
 	private RequestBO iRequestBO;
	 
 	@RequestMapping(value="/saveReports.do")
    public ModelAndView uploadResources( HttpServletRequest request,  @ModelAttribute Report report){
 		ModelAndView modelAndView = new ModelAndView("uploadReport");
        String fileName = null;
        String userId = session.getAttribute("userId").toString();
        List<MultipartFile> files = report.getImages();
		if (null != files && files.size() > 0)  {
		    for (MultipartFile multipartFile : files) {
		        fileName = multipartFile.getOriginalFilename();
		    }
		}
		iReportBO.saveFileDetails(fileName,userId);
		report.setStatus(ApplicationConstant.FILE_UPLOAD_SUCCESS);
        report.setName(fileName);
        modelAndView.addObject("iReport", report);
        return modelAndView;
    }

 	@RequestMapping(value="/downloadReport.do")
	public void downloadReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ResponseTO responseTO = null;
		String userId = request.getParameter("id");
		FileInputStream inStream = null;
		OutputStream  outputStream = null;
		try {
			responseTO = iRequestBO.getFileDetails(userId);
			File downloadFile = convertBlobToFile(responseTO.getBlob(),responseTO.getfName());
	        inStream = new FileInputStream(downloadFile);
	        String mimeType = "application/octet-stream";
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	        outputStream = response.getOutputStream();
	        byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	        while ((bytesRead = inStream.read(buffer)) != -1) {
	        	outputStream.write(buffer, 0, bytesRead);
	        }
	        inStream.close();
	        inStream.close();     
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			inStream.close();
			inStream.close();
		}
 	 }
 	
	 public File convertBlobToFile(Blob blob,String fileName){
		 File file = null;
		 int len = 0;
		try {
			 file = new File(fileName);
			 InputStream in = blob.getBinaryStream();
			 OutputStream out = new FileOutputStream(file);
			 byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
			 while ((len = in.read(buff)) != -1) {
			     out.write(buff, 0, len);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	 }
}
