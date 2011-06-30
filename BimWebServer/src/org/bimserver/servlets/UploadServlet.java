package org.bimserver.servlets;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.bimserver.BimServer;
import org.bimserver.shared.ServiceException;
import org.bimserver.utils.InputStreamDataSource;
import org.bimserver.web.LoginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadServlet.class);
	private static final long serialVersionUID = 7852327471215749104L;
	private DiskFileItemFactory factory;

	public UploadServlet() {
		factory = new DiskFileItemFactory();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
		if (loginManager == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		BimServer bimServer = (BimServer) request.getServletContext().getAttribute("bimserver");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		long poid = -1;
		String comment = null;
		String type = null;
		if (isMultipart) {
			factory.setSizeThreshold(1024 * 1024 * 300); // 300 MB
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> items = (List<FileItem>) upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				InputStream in = null;
				long size = 0;
				String name = "";
				boolean merge = false;
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
						if ("poid".equals(item.getFieldName())) {
							poid = Long.parseLong(item.getString());
						}
						if ("comment".equals(item.getFieldName())) {
							comment = item.getString();
						}
						if ("type".equals(item.getFieldName())) {
							type = item.getString();
						}
						if ("merge".equals(item.getFieldName())) {
							merge = true;
						}
					} else {
						size = item.getSize();
						name = item.getName();
						in = item.getInputStream();
					}
				}
				if (poid != -1) {
					if (size == 0) {
						response.sendRedirect("project.jsp?poid=" + poid + "&message=Uploaded file empty, or no file uploaded at all");
					} else {
						final InputStream realStream = in;
						if (type.equals("ifc")) {
							try {
								InputStreamDataSource inputStreamDataSource = new InputStreamDataSource(realStream);
								inputStreamDataSource.setName(name);
								DataHandler ifcFile = new DataHandler(inputStreamDataSource);
								loginManager.getService().checkinAsync(poid, comment, size, ifcFile, merge);
								response.sendRedirect("project.jsp?poid=" + poid);
							} catch (ServiceException e) {
								if (e.getCause() instanceof OutOfMemoryError) {
									bimServer.getServerInfo().setOutOfMemory();
									response.sendRedirect(getServletContext().getContextPath());
									return;
								}
								if (e.getCause() != null) {
									response.sendRedirect("project.jsp?poid=" + poid + "&message=" + e.getCause().getMessage());
								} else {
									response.sendRedirect("project.jsp?poid=" + poid + "&message=" + e.getUserMessage());
								}
							}
//						} else if (type.equals("changeset")) {
//							try {
//								JAXBContext context = JAXBContext.newInstance(ChangeSet.class);
//								Unmarshaller unmarshaller = context.createUnmarshaller();
//								ChangeSet changeSet = (ChangeSet) unmarshaller.unmarshal(realStream);
//								loginManager.getService().processChangeSet(changeSet, poid, comment);
//								response.sendRedirect("project.jsp?poid=" + poid);
//							} catch (JAXBException e) {
//								LOGGER.error("", e);
//							} catch (UserException e) {
//								LOGGER.error("", e);
//							}
						}
					}
				} else {
					response.getWriter().println("ERROR no poid");
				}
			} catch (FileUploadException e) {
				LOGGER.error("", e);
			}
		}
	}
}