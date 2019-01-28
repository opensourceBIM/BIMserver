package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.io.BufferedInputStream;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.activation.DataHandler;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.bimserver.BimServer;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.utils.ByteUtils;
import org.bimserver.utils.FakeClosingInputStream;
import org.bimserver.utils.InputStreamDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class BulkUploadServlet extends SubServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(BulkUploadServlet.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public BulkUploadServlet(BimServer bimServer, ServletContext servletContext) {
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
				while (iter.hasNext()) {
					FileItemStream item = iter.next();
					if (item.isFormField()) {
						if ("token".equals(item.getFieldName())) {
							token = Streams.asString(item.openStream());
						} else if ("poid".equals(item.getFieldName())) {
							poid = Long.parseLong(Streams.asString(item.openStream()));
						} else if ("comment".equals(item.getFieldName())) {
							comment = Streams.asString(item.openStream());
						}
					} else {
						name = item.getName();
						in = item.openStream();
						
						if (poid != -1) {
							ServiceInterface service = getBimServer().getServiceFactory().get(token, AccessMethod.INTERNAL).get(ServiceInterface.class);

							SProject mainProject = service.getProjectByPoid(poid);
							
							ZipInputStream zipInputStream = new ZipInputStream(in);
							ZipEntry nextEntry = zipInputStream.getNextEntry();
							while (nextEntry != null) {
								String fullfilename = nextEntry.getName();
								if (fullfilename.toLowerCase().endsWith(".ifc") || fullfilename.toLowerCase().endsWith("ifcxml") || fullfilename.toLowerCase().endsWith(".ifczip")) {
									BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
									byte[] initialBytes = ByteUtils.extractHead(bufferedInputStream, 4096);
									InputStreamDataSource inputStreamDataSource = new InputStreamDataSource(new FakeClosingInputStream(bufferedInputStream));
									inputStreamDataSource.setName(name);
									DataHandler ifcFile = new DataHandler(inputStreamDataSource);
									if (fullfilename.contains("/")) {
										String path = fullfilename.substring(0, fullfilename.lastIndexOf("/"));
										String filename = fullfilename.substring(fullfilename.lastIndexOf("/") + 1);
										String extension = filename.substring(filename.lastIndexOf(".") + 1);
										
										try {
											String schema = service.determineIfcVersion(initialBytes, fullfilename.toLowerCase().endsWith(".ifczip"));
											SProject project = getOrCreatePath(service, mainProject, mainProject, path, schema);
											SDeserializerPluginConfiguration deserializer = service.getSuggestedDeserializerForExtension(extension, project.getOid());
											
											service.checkinSync(project.getOid(), comment, deserializer.getOid(), -1L, filename, ifcFile, false);
										} catch (Exception e) {
											LOGGER.error(e.getMessage() + " (" + fullfilename + ")");
										}
									}
								} else {
									if (!nextEntry.isDirectory()) {
										LOGGER.info("Unknown fileextenstion " + fullfilename);
									}
								}
								nextEntry = zipInputStream.getNextEntry();
							}
							
//							DataHandler ifcFile = new DataHandler(inputStreamDataSource);
//							
//							if (token != null) {
//								if (topicId == -1) {
//									long newTopicId = service.checkin(poid, comment, deserializerOid, -1L, name, ifcFile, merge, sync);
//									result.put("topicId", newTopicId);
//								} else {
//									ServiceInterface service = getBimServer().getServiceFactory().get(token, AccessMethod.INTERNAL).get(ServiceInterface.class);
//									long newTopicId = service.checkinInitiated(topicId, poid, comment, deserializerOid, -1L, name, ifcFile, merge, true);
//									result.put("topicId", newTopicId);
//								}
//							}
						} else {
							result.put("exception", "No poid");
						}
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("", e);
//			sendException(response, e);
			return;
		}
		response.getWriter().write(result.toString());
	}
	
	private SProject getOrCreatePath(ServiceInterface service, SProject mainProject, SProject currentProject, String path, String schema) throws UserException, ServerException {
		String name = path;
		if (path.contains("/")) {
			name = path.substring(0, path.indexOf("/"));
		}
		SProject newProject = null;
		try {
			newProject = service.addProjectAsSubProject(name, currentProject.getOid(), schema);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			newProject = service.getSubProjectByName(currentProject.getOid(), name);
		}
		if (path.contains("/")) {
			return getOrCreatePath(service, mainProject, newProject, path.substring(path.indexOf("/") + 1), schema);
		}
		return newProject;
	}
}
