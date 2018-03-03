package com.example.web.servlet.lob.binary;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.mail.internet.ContentType;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.example.jpa.beans.lob.binary.BinaryLobEmployeeDemoBean;

public class BinaryLobEmployeeDemoServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(BinaryLobEmployeeDemoServlet.class);

	@EJB
	private BinaryLobEmployeeDemoBean binaryLobEmployeeDemoBean;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		if (ServletFileUpload.isMultipartContent(request)) {

			LOGGER.info("reqest is multipart");

			try {
				// Create a factory for disk-based file items
				FileItemFactory factory = new DiskFileItemFactory();

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);

				// Parse the request
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem fileItem : items) {
					if (!fileItem.isFormField()) {
						LOGGER.info("fileItem.isFormField() : " + fileItem.isFormField());
						LOGGER.info("FieldName : " + fileItem.getFieldName());
						LOGGER.info("FileName : " + fileItem.getName());
						LOGGER.info("File Size : " + fileItem.getSize());
						LOGGER.info("File Size : " + fileItem.getSize() + " bytes");
						LOGGER.info("File extension : " + FilenameUtils.getExtension(fileItem.getName()));
						LOGGER.info("File content Type : " + fileItem.getContentType());

						LOGGER.info("file bytes as :: " + fileItem.get());
						binaryLobEmployeeDemoBean.create(fileItem.get());
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		} else {
			LOGGER.info("reqest is NOT multipart");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer employeeId = Integer.parseInt(req.getParameter("employeeId"));
		byte[] empProfilePicBytes = binaryLobEmployeeDemoBean.getEmployeeProfilePic(employeeId);
		ServletOutputStream outputStream = null;
		try {
			outputStream = resp.getOutputStream();
			outputStream.write(empProfilePicBytes);
			
			resp.setContentLength(empProfilePicBytes.length);
			resp.setContentType("image/jpeg");
		} catch (Exception e) {
			LOGGER.error("Error while writing bytes to servlet output stream", e);
		} finally {
			if (outputStream != null) {
				outputStream.flush();
				outputStream.close();
			}
		}
	}
}
