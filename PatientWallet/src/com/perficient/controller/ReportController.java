 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.bo.ReportBO
 *  com.perficient.to.Report
 *  com.perficient.to.ResponseTO
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.ModelAttribute
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.multipart.MultipartFile
 *  org.springframework.web.servlet.ModelAndView
 */
package com.perficient.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.bo.ReportBO;
import com.perficient.to.Report;

@Controller
public class ReportController {
    @Autowired
    private HttpSession session;
    @Autowired
    private ReportBO iReportBO;

    @RequestMapping(value={"/saveReports.do"})
    public ModelAndView uploadResources(HttpServletRequest request, @ModelAttribute Report report) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("uploadReport");
        String fileName = null;
        Blob blob = null;
        String contentType = null;
        String userId = this.session.getAttribute("userId").toString();
        String doctorId = request.getParameter("doctorId");
        try {
        	List<MultipartFile> files = report.getImages();
            if (files != null && files.size() > 0) {
                for (MultipartFile multipartFile : files) {
                    fileName = multipartFile.getOriginalFilename();
                    contentType = multipartFile.getContentType();
                    blob = this.getBlobData(multipartFile);
                    this.iReportBO.saveFileDetails(fileName, userId, blob, contentType, doctorId);
                }
            }
            report.setStatus("Files are uploaded successfully.");
        }
        catch (IOException e) {
            e.printStackTrace();
            report.setStatus("Application is busy.Please try after some time");
        }
        report.setName(fileName);
        modelAndView.addObject("iReport", (Object)report);
        return modelAndView;
    }

    public Blob getBlobData(MultipartFile file) throws IOException, SQLException {
        byte[] bytes = file.getBytes();
        return new SerialBlob(bytes);
    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
 