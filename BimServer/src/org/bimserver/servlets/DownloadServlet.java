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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.LoginManager;
import org.bimserver.ifc.EmfSerializer;
import org.bimserver.ifc.SerializerException;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.SDownloadResult;
import org.bimserver.shared.UserException;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 732025375536415841L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
			if (loginManager == null) {
				loginManager = new LoginManager();
			}
			if (!loginManager.isLoggedIn()) {
				loginManager.loginAnonymous();
			}
			ResultType resultType = ResultType.IFC;
			if (request.getParameter("resultType") != null) {
				resultType = ResultType.valueOf(request.getParameter("resultType"));
			}
			SDownloadResult checkoutResult = null;
			if (request.getParameter("multiple") != null) {
				Set<Long> roids = new HashSet<Long>();
				for (Object key : request.getParameterMap().keySet()) {
					String keyString = (String) key;
					if (keyString.startsWith("download_")) {
						if (!request.getParameter(keyString).equals("[off]")) {
							roids.add(Long.parseLong(request.getParameter(keyString)));
						}
					}
				}
				checkoutResult = loginManager.getService().downloadProjects(roids, resultType);
			} else if (request.getParameter("clashes") != null) {
				SClashDetectionSettings sClashDetectionSettings = new SClashDetectionSettings();
				sClashDetectionSettings.setMargin(Float.parseFloat(request.getParameter("margin")));
				String[] ignoredSplit = request.getParameter("ignore").split(";");
				for (String ignore : ignoredSplit) {
					sClashDetectionSettings.getIgnoredClasses().add(ignore);
				}
				String[] revisions = request.getParameter("revisions").split(";");
				sClashDetectionSettings.setRevisions(new ArrayList<Long>());
				for (String revisionOidString : revisions) {
					sClashDetectionSettings.getRevisions().add(Long.parseLong(revisionOidString));
				}
				List<SEidClash> findClashes = loginManager.getService().findClashesByEid(sClashDetectionSettings);
				Set<Long> eids = new HashSet<Long>();
				for (SEidClash clash : findClashes) {
					eids.add(clash.getEid1());
					eids.add(clash.getEid2());
				}
				checkoutResult = loginManager.getService().downloadByOids(new HashSet<Long>(sClashDetectionSettings.getRevisions()), eids, resultType);
			} else {
				long roid = -1;
				if (request.getParameter("roid") == null) {
					roid = loginManager.getService().getProjectByPoid(Long.parseLong(request.getParameter("poid"))).getLastRevisionId();
				} else {
					roid = Long.parseLong(request.getParameter("roid"));
				}
				if (request.getParameter("checkout") != null) {
					checkoutResult = loginManager.getService().checkout(roid, resultType);
				} else {
					if (request.getParameter("class") != null) {
						checkoutResult = loginManager.getService().downloadOfType(roid, request.getParameter("class"), resultType);
					} else if (request.getParameter("oids") != null) {
						Set<Long> oids = new HashSet<Long>();
						for (String oidString : request.getParameter("oids").split(";")) {
							oids.add(Long.parseLong(oidString));
						}
						Set<Long> roids = new HashSet<Long>();
						roids.add(roid);
						checkoutResult = loginManager.getService().downloadByOids(roids, oids, resultType);
					} else if (request.getParameter("guids") != null) {
						Set<String> guids = new HashSet<String>();
						for (String guid : request.getParameter("guids").split(";")) {
							guids.add(guid);
						}
						Set<Long> roids = new HashSet<Long>();
						roids.add(roid);
						checkoutResult = loginManager.getService().downloadByGuids(roids, guids, resultType);
					} else if (request.getParameter("multiple") != null) {
					} else {
						checkoutResult = loginManager.getService().download(roid, resultType);
					}
				}
			}
			EmfSerializer serializer = (EmfSerializer) checkoutResult.getFile().getDataSource();
			if (request.getParameter("zip") != null && request.getParameter("zip").equals("on")) {
				if (resultType == ResultType.IFC) {
					response.setHeader("Content-Disposition", "inline; filename=\"" + checkoutResult.getFile().getName().replace(".ifc", ".ifczip") + "\"");
				} else {
					response.setHeader("Content-Disposition", "inline; filename=\"" + checkoutResult.getFile().getName() + ".zip" + "\"");
				}
				response.setContentType("application/zip");
				String name = checkoutResult.getProjectName() + "." + checkoutResult.getRevisionNr() + "." + resultType.getDefaultExtension();
				ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
				zipOutputStream.putNextEntry(new ZipEntry(name));
				try {
					serializer.writeToOutputStream(zipOutputStream);
				} catch (SerializerException e) {
					e.printStackTrace();
				}
				zipOutputStream.finish();
			} else {
				response.setContentType(resultType.getContentType());
				response.setHeader("Content-Disposition", "inline; filename=\"" + checkoutResult.getFile().getName() + "\"");
				try {
					serializer.writeToOutputStream(response.getOutputStream());
				} catch (SerializerException e) {
					e.printStackTrace();
				}
				response.getOutputStream().flush();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().println("Some number was incorrectly formatted");
		} catch (UserException e) {
			response.getWriter().println(e.getUserMessage());
		}
	}
}