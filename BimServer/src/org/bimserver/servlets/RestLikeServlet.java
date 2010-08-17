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
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;

public class RestLikeServlet extends HttpServlet {

	private static final long serialVersionUID = 6286334261176028115L;

	private enum Action {
		REVISIONS, CHECKOUTS, PROJECTS
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceInterface service = (ServiceInterface) getServletContext().getAttribute("service");
		String[] urlParams = null;
		if (request.getPathInfo() == null) {
			urlParams = request.getQueryString().split("/");
		} else {
			urlParams = request.getPathInfo().split("/");
		}
		int pid = -1;
		int rid = -1;
		long oid = -1;
		String guid = null;
		ResultType resultType = ResultType.IFC;
		Action action = null;
		String className = null;
		try {
			if (urlParams != null) {
				for (String param : urlParams) {
					if (param.startsWith("pid=")) {
						pid = Integer.parseInt(param.substring(4));
					} else if (param.startsWith("rid=")) {
						rid = Integer.parseInt(param.substring(4));
					} else if (param.startsWith("oid=")) {
						oid = Integer.parseInt(param.substring(4));
					} else if (param.startsWith("guid=")) {
						guid = param.substring(5);
					} else if (param.startsWith("resultType=")) {
						resultType = ResultType.valueOf(param.substring(11).toUpperCase());
					} else if (param.startsWith("action=")) {
						action = Action.valueOf(param.substring(7).toUpperCase());
					} else if (param.startsWith("class=")) {
						className = param.substring(6);
					}
				}
			}
		} catch (NumberFormatException e) {
			response.getWriter().println("Some number was incorrectly formatted");
			return;
		}
		response.setContentType(resultType.getContentType());
		Token token;
//		try {
//			token = service.createAnonymousToken();
//			if (urlParams == null) {
//				writeObject(service.getAllProjects(token), response.getOutputStream());
//			} else {
//				if (pid != -1) {
//					// Get a specific project
//					if (rid != -1) {
//						// Get a specific revision
//						if (oid != -1) {
//							// Get a specific object
//							CheckoutResult downloadById = service.downloadByOid(token, roid, oid, resultType);
//							EmfSerializer serializer = (EmfSerializer)downloadById.getFile().getDataSource();
//							serializer.writeToOutputStream(response.getOutputStream());
//						} else {
//							if (guid != null) {
//								CheckoutResult downloadById = service.downloadByGuid(token, roid, guid, resultType);
//								EmfSerializer serializer = (EmfSerializer)downloadById.getFile().getDataSource();
//								serializer.writeToOutputStream(response.getOutputStream());
//							} else {
//								if (className != null) {
//									// Get all of class
//									CheckoutResult download = service.downloadOfType(token, roid, className, resultType);
//									EmfSerializer serializer = (EmfSerializer)download.getFile().getDataSource();
//									serializer.writeToOutputStream(response.getOutputStream());
//								} else {
//									// Get all objects
//									if (service.getRevision(token, pid, rid) == null) {
//										response.getWriter().println("Project " + pid + " has no revision " + rid);
//									} else {
//										CheckoutResult download = service.download(token, roid, resultType);
//										EmfSerializer serializer = (EmfSerializer)download.getFile().getDataSource();
//										serializer.writeToOutputStream(response.getOutputStream());
//									}
//								}
//							}
//						}
//					} else {
//						// Get the last revision
//						if (oid != -1) {
//							// Get a specific object
//							CheckoutResult downloadById = service.downloadByOid(token, pid, service.getLastRevision(token, pid).getId(), oid, resultType);
//							downloadById.getFile().writeTo(response.getOutputStream());
//						} else {
//							if (action == null) {
//								// Get all objects
//								SRevision lastRevision = service.getLastRevision(token, pid);
//								if (lastRevision == null) {
//									response.getWriter().println("Project " + pid + " has no revisions");
//								} else {
//									CheckoutResult download = service.download(token, pid, lastRevision.getId(), resultType);
//									EmfSerializer serializer = (EmfSerializer)download.getFile().getDataSource();
//									response.setHeader("Content-Disposition", "inline; filename=\"" + download.getProjectName() + "." + download.getRevisionNr() + "." + resultType.getDefaultExtension() + "\"");
//									serializer.writeToOutputStream(response.getOutputStream());
//								}
//							} else {
//								if (action == Action.CHECKOUTS) {
//									writeObject(service.getAllCheckoutsOfProject(token, pid), response.getOutputStream());
//								} else if (action == Action.REVISIONS) {
//									writeObject(service.getAllRevisionsOfProject(token, pid), response.getOutputStream());
//								} else if (action == Action.PROJECTS) {
//									writeObject(service.getAllProjects(token), response.getOutputStream());
//								}
//							}
//						}
//					}
//				}
//			}
//		} catch (UserException e) {
//			response.getWriter().print(e.getUserMessage());
//		} catch (SerializerException e) {
//			e.printStackTrace();
//		}
	}

	private void writeObject(Object object, OutputStream out) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass(), SProject.class, SCheckout.class, SRevision.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(object, out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}