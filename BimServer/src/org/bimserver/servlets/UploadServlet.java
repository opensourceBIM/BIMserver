package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.bimserver.BimServer;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.utils.InputStreamDataSource;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadServlet.class);
	private static final long serialVersionUID = 7852327471215749104L;
	private DiskFileItemFactory factory;

	public UploadServlet() {
		factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 500); // 500 MB
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BimServer bimServer = (BimServer) getServletContext().getAttribute("bimserver");
		if (request.getHeader("Origin") != null && !bimServer.isHostAllowed(request.getHeader("Origin"))) {
			response.setStatus(403);
			return;
		}
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		
		SToken token = (SToken)request.getSession().getAttribute("token");
		String tokenString = null;
		long tokenExpires = -1;
		
		JSONObject result = new JSONObject();
		response.setContentType("text/json");
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			long poid = -1;
			String comment = null;
			if (isMultipart) {
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = (List<FileItem>) upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				InputStream in = null;
				long size = 0;
				String name = "";
				long deserializerOid = -1;
				boolean merge = false;
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
						if ("tokenString".equals(item.getFieldName())) {
							tokenString = item.getString();
						}
						if ("tokenExpires".equals(item.getFieldName())) {
							tokenExpires = Long.parseLong(item.getString());
						}
						if ("poid".equals(item.getFieldName())) {
							poid = Long.parseLong(item.getString());
						}
						if ("comment".equals(item.getFieldName())) {
							comment = item.getString();
						}
						if ("merge".equals(item.getFieldName())) {
							merge = item.getString().equals("true");
						}
						if ("deserializerOid".equals(item.getFieldName())) {
							deserializerOid = Long.parseLong(item.getString());
						}
					} else {
						size = item.getSize();
						name = item.getName();
						in = item.getInputStream();
					}
				}
				if (poid != -1) {
					if (size == 0) {
						result.put("error", "Uploaded file empty, or no file uploaded at all");
					} else {
						InputStream realStream = in;
						InputStreamDataSource inputStreamDataSource = new InputStreamDataSource(realStream);
						inputStreamDataSource.setName(name);
						DataHandler ifcFile = new DataHandler(inputStreamDataSource);
						
						if (token == null && tokenString != null && tokenExpires != -1) {
							token = new SToken();
							token.setTokenString(tokenString);
							token.setExpires(tokenExpires);
						}
						if (token != null) {
							ServiceInterface service = bimServer.getServiceFactory().getService(ServiceInterface.class, token);
							long checkinId = service.checkin(poid, comment, deserializerOid, size, name, ifcFile, merge, false);
							result.put("checkinid", checkinId);
						}
					}
				} else {
					result.put("error", "No poid");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				result.put("error", (e.getMessage() == null ? "Unknown error" : e.getMessage()));
			} catch (JSONException e1) {
			}
		}
		try {
			result.write(response.getWriter());
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
	}
}