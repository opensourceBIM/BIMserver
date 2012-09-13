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
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.web.LoginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 732025375536415841L;
	private static final Logger LOGGER = LoggerFactory.getLogger(DownloadServlet.class);

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
			if (loginManager == null) {
				loginManager = new LoginManager();
			}
			String serializerName = "Ifc2x3";
			if (request.getParameter("serializerName") != null) {
				serializerName = request.getParameter("serializerName");
			}
			SSerializer serializer = loginManager.getService().getSerializerByName(serializerName);
			int downloadId = -1;
			if (request.getParameter("longActionId") != null) {
				downloadId = Integer.parseInt(request.getParameter("longActionId"));
			} else if (request.getParameter("multiple") != null) {
				Set<Long> roids = new HashSet<Long>();
				for (Object key : request.getParameterMap().keySet()) {
					String keyString = (String) key;
					if (keyString.startsWith("download_")) {
						if (!request.getParameter(keyString).equals("[off]")) {
							roids.add(Long.parseLong(request.getParameter(keyString)));
						}
					}
				}
				downloadId = loginManager.getService().downloadRevisions(roids, serializerName, true);
			} else if (request.getParameter("compare") != null) {
				SCompareType sCompareType = SCompareType.valueOf(request.getParameter("type"));
				Long roid1 = Long.parseLong(request.getParameter("roid1"));
				Long roid2 = Long.parseLong(request.getParameter("roid2"));
				downloadId = loginManager.getService().downloadCompareResults(serializerName, roid1, roid2, Long.valueOf(request.getParameter("mcid")), sCompareType, true);
			} else {
				long roid = -1;
				if (request.getParameter("roid") == null) {
					if (request.getParameter("poid") != null) {
						long poid = Long.parseLong(request.getParameter("poid"));
						SProject projectByPoid = loginManager.getService().getProjectByPoid(poid);
						if (projectByPoid == null) {
							throw new UserException("Project with oid " + poid + " not found");
						}
						roid = projectByPoid.getLastRevisionId();
						if (roid == -1) {
							throw new UserException("No revisions");
						}
					} else {
						throw new UserException("A poid or roid is required for downloading");
					}
				} else {
					roid = Long.parseLong(request.getParameter("roid"));
				}
				if (request.getParameter("checkout") != null) {
					downloadId = loginManager.getService().checkout(roid, serializerName, true);
				} else {
					if (request.getParameter("classses") != null) {
						Set<String> classes = new HashSet<String>();
						for (String className : request.getParameter("classses").split(";")) {
							classes.add(className);
						}
						Set<Long> roids = new HashSet<Long>();
						roids.add(roid);
						downloadId = loginManager.getService().downloadByTypes(roids, classes, serializerName, false, true);
					} else if (request.getParameter("oids") != null) {
						Set<Long> oids = new HashSet<Long>();
						for (String oidString : request.getParameter("oids").split(";")) {
							oids.add(Long.parseLong(oidString));
						}
						Set<Long> roids = new HashSet<Long>();
						roids.add(roid);
						downloadId = loginManager.getService().downloadByOids(roids, oids, serializerName, true);
					} else if (request.getParameter("guids") != null) {
						Set<String> guids = new HashSet<String>();
						for (String guid : request.getParameter("guids").split(";")) {
							guids.add(guid);
						}
						Set<Long> roids = new HashSet<Long>();
						roids.add(roid);
						downloadId = loginManager.getService().downloadByGuids(roids, guids, serializerName, true);
					} else {
						downloadId = loginManager.getService().download(roid, serializerName, true, true);
					}
				}
			}
			if (downloadId == -1) {
				response.getWriter().println("No valid download");
				return;
			}
			SDownloadResult checkoutResult = loginManager.getService().getDownloadData(downloadId);
			DataSource dataSource = checkoutResult.getFile().getDataSource();
			if (request.getParameter("zip") != null && request.getParameter("zip").equals("on")) {
				if (serializer.getClassName().equals("IfcStepSerializer")) {
					response.setHeader("Content-Disposition", "inline; filename=\"" + checkoutResult.getFile().getName().replace(".ifc", ".ifczip") + "\"");
				} else {
					response.setHeader("Content-Disposition", "inline; filename=\"" + checkoutResult.getFile().getName() + ".zip" + "\"");
				}
				response.setContentType("application/zip");
				String name = checkoutResult.getProjectName() + "." + checkoutResult.getRevisionNr() + "." + serializer.getExtension();
				ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
				zipOutputStream.putNextEntry(new ZipEntry(name));
				InputStream in = dataSource.getInputStream();
				IOUtils.copy(in, zipOutputStream);
				in.close();
				zipOutputStream.finish();
			} else {
				if (request.getParameter("mime") == null) {
					response.setContentType(serializer.getContentType());
					response.setHeader("Content-Disposition", "inline; filename=\"" + dataSource.getName() + "." + serializer.getExtension() + "\"");
				} else {
					response.setContentType(request.getParameter("mime"));
				}
				InputStream in = dataSource.getInputStream();
				IOUtils.copy(in, response.getOutputStream());
				in.close();
				response.getOutputStream().flush();
			}
		} catch (NumberFormatException e) {
			LOGGER.error("", e);
			response.getWriter().println("Some number was incorrectly formatted");
		} catch (ServiceException e) {
			LOGGER.error("", e);
			response.getWriter().println(e.getUserMessage());
		}
	}
}