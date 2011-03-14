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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.ifc.EmfSerializer;
import org.bimserver.ifc.SerializerException;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.SCompareResult;
import org.bimserver.shared.SDownloadResult;
import org.bimserver.shared.ServiceException;
import org.bimserver.shared.UserException;
import org.bimserver.shared.SCompareResult.SCompareType;
import org.bimserver.shared.SCompareResult.SItem;
import org.bimserver.web.DownloadState;
import org.bimserver.web.JspHelper;
import org.bimserver.web.LoginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;

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
			if (!loginManager.getService().isLoggedIn()) {
				loginManager.getService().loginAnonymous();
			}
			ResultType resultType = ResultType.IFC;
			if (request.getParameter("resultType") != null) {
				resultType = ResultType.valueOf(request.getParameter("resultType"));
			}
			SDownloadResult checkoutResult = null;
			if (request.getParameter("longActionId") != null) {
				checkoutResult = loginManager.getService().getDownloadData(request.getParameter("longActionId"));
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
				checkoutResult = loginManager.getService().downloadProjects(roids, resultType);
			} else if (request.getParameter("clashes") != null) {
				SClashDetectionSettings sClashDetectionSettings = JspHelper.createSClashDetectionSettings(request);
				List<SEidClash> findClashes = loginManager.getService().findClashesByEid(sClashDetectionSettings);
				Set<Long> oids = new HashSet<Long>();
				for (SEidClash clash : findClashes) {
					oids.add(clash.getEid1());
					oids.add(clash.getEid2());
				}
				checkoutResult = loginManager.getService().downloadByOids(new HashSet<Long>(sClashDetectionSettings.getRevisions()), oids,
						resultType);
			} else if (request.getParameter("compare") != null) {
				SCompareType sCompareType = SCompareType.valueOf(request.getParameter("type"));
				Long roid1 = Long.parseLong(request.getParameter("roid1"));
				Long roid2 = Long.parseLong(request.getParameter("roid2"));
				SCompareResult compare = loginManager.getService().compare(roid1, roid2, sCompareType);
				Map<String, List<SItem>> items = compare.getItems();
				Set<Long> oids = new HashSet<Long>();
				for (String className : items.keySet()) {
					List<SItem> list = items.get(className);
					for (SItem item : list) {
						oids.add(item.dataObject.getOid());
					}
				}
				checkoutResult = loginManager.getService().downloadByOids(Sets.newHashSet(roid1, roid2), oids, resultType);
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
					} else if (request.getParameter("async") != null) {
						String actionID = loginManager.getService().download(roid, resultType, false);
						DownloadState dls = new DownloadState();
						dls.setState(loginManager.getService().getDownloadState(actionID));
						String contextPath = getServletContext().getContextPath();
						request.getSession(true).setAttribute("downloadStateBean", dls);
						getServletContext().getRequestDispatcher(contextPath + "/downloadprogress.jsp").forward(request, response);
						return;
					}
				}
			}
			EmfSerializer serializer = (EmfSerializer) checkoutResult.getFile().getDataSource();
			if (request.getParameter("zip") != null && request.getParameter("zip").equals("on")) {
				if (resultType == ResultType.IFC) {
					response.setHeader("Content-Disposition",
							"inline; filename=\"" + checkoutResult.getFile().getName().replace(".ifc", ".ifczip") + "\"");
				} else {
					response.setHeader("Content-Disposition", "inline; filename=\"" + checkoutResult.getFile().getName() + ".zip" + "\"");
				}
				response.setContentType("application/zip");
				String name = checkoutResult.getProjectName() + "." + checkoutResult.getRevisionNr() + "."
						+ resultType.getDefaultExtension();
				ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
				zipOutputStream.putNextEntry(new ZipEntry(name));
				try {
					serializer.writeToOutputStream(zipOutputStream);
				} catch (SerializerException e) {
					LOGGER.error("", e);
				}
				zipOutputStream.finish();
			} else {
				response.setContentType(resultType.getContentType());
				response.setHeader("Content-Disposition", "inline; filename=\"" + checkoutResult.getFile().getName() + "\"");
				try {
					serializer.writeToOutputStream(response.getOutputStream());
				} catch (SerializerException e) {
					LOGGER.error("", e);
				}
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