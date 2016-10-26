package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import javax.activation.DataHandler;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.utils.InputStreamDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UploadServlet extends SubServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadServlet.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public UploadServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getHeader("Origin") != null && !getBimServer().getServerSettingsCache().isHostAllowed(request.getHeader("Origin"))) {
			response.setStatus(403);
			return;
		}
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		
		String token = (String)request.getSession().getAttribute("token");
		
		ObjectNode result = OBJECT_MAPPER.createObjectNode();
		response.setContentType("text/json");
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			long poid = -1;
			String comment = null;
			if (isMultipart) {
				ServletFileUpload upload = new ServletFileUpload();
				FileItemIterator iter = upload.getItemIterator(request);
				InputStream in = null;
				String name = "";
				long deserializerOid = -1;
				boolean merge = false;
				boolean sync = false;
				String compression = null;
				String action = null;
				long topicId = -1;
				while (iter.hasNext()) {
					FileItemStream item = iter.next();
					if (item.isFormField()) {
						if ("action".equals(item.getFieldName())) {
							action = Streams.asString(item.openStream());
						} else if ("token".equals(item.getFieldName())) {
							token = Streams.asString(item.openStream());
						} else if ("poid".equals(item.getFieldName())) {
							poid = Long.parseLong(Streams.asString(item.openStream()));
						} else if ("comment".equals(item.getFieldName())) {
							comment = Streams.asString(item.openStream());
						} else if ("topicId".equals(item.getFieldName())) {
							topicId = Long.parseLong(Streams.asString(item.openStream()));
						} else if ("sync".equals(item.getFieldName())) {
							sync = Streams.asString(item.openStream()).equals("true");
						} else if ("merge".equals(item.getFieldName())) {
							merge = Streams.asString(item.openStream()).equals("true");
						} else if ("compression".equals(item.getFieldName())) {
							compression = Streams.asString(item.openStream());
						} else if ("deserializerOid".equals(item.getFieldName())) {
							deserializerOid = Long.parseLong(Streams.asString(item.openStream()));
						}
					} else {
						name = item.getName();
						in = item.openStream();
						
						if ("file".equals(action)) {
							ServiceInterface serviceInterface = getBimServer().getServiceFactory().get(token, AccessMethod.INTERNAL).get(ServiceInterface.class);
							SFile file = new SFile();
							byte[] data = IOUtils.toByteArray(in);
							file.setData(data);
							file.setSize(data.length);
							file.setFilename(name);
							file.setMime(item.getContentType());
							result.put("fileId", serviceInterface.uploadFile(file));
						} else if (poid != -1) {
							InputStream realStream = null;
							if ("gzip".equals(compression)) {
								realStream = new GZIPInputStream(in);
							} else if ("deflate".equals(compression)) {
								realStream = new InflaterInputStream(in);
							} else {
								realStream = in;
							}
							InputStreamDataSource inputStreamDataSource = new InputStreamDataSource(realStream);
							inputStreamDataSource.setName(name);
							DataHandler ifcFile = new DataHandler(inputStreamDataSource);
							
							if (token != null) {
								if (topicId == -1) {
									ServiceInterface service = getBimServer().getServiceFactory().get(token, AccessMethod.INTERNAL).get(ServiceInterface.class);
									long newTopicId = service.checkin(poid, comment, deserializerOid, -1L, name, ifcFile, merge, sync);
									result.put("topicId", newTopicId);
								} else {
									ServiceInterface service = getBimServer().getServiceFactory().get(token, AccessMethod.INTERNAL).get(ServiceInterface.class);
									long newTopicId = service.checkinInitiated(topicId, poid, comment, deserializerOid, -1L, name, ifcFile, merge, true);
									result.put("topicId", newTopicId);
								}
							}
						} else {
							result.put("exception", "No poid");
						}
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("", e);
			sendException(response, e);
			return;
		}
		response.getWriter().write(result.toString());
	}

	private void sendException(HttpServletResponse response, Exception exception) {
		try {
			ObjectNode responseObject = OBJECT_MAPPER.createObjectNode();
			ObjectNode exceptionJson = OBJECT_MAPPER.createObjectNode();
			exceptionJson.put("__type", exception.getClass().getSimpleName());
			if (exception.getMessage() == null) {
				exceptionJson.put("message", "Unknown exception");
			} else {
				exceptionJson.put("message", exception.getMessage());
			}
			responseObject.set("exception", exceptionJson);
			response.getWriter().write(responseObject.toString());
		} catch (IOException e) {
		}
	}
}
