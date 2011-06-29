//package org.bimserver.servlets;
//
///******************************************************************************
// * (c) Copyright bimserver.org 2009
// * Licensed under GNU GPLv3
// * http://www.gnu.org/licenses/gpl-3.0.txt
// * For more information mail to license@bimserver.org
// *
// * Bimserver.org is free software: you can redistribute it and/or modify 
// * it under the terms of the GNU General Public License as published by 
// * the Free Software Foundation, either version 3 of the License, or
// * (at your option) any later version.
// *
// * Bimserver.org is distributed in the hope that it will be useful, but 
// * WITHOUT ANY WARRANTY; without even the implied warranty of 
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
// * General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License a 
// * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
// *****************************************************************************/
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//
//import org.bimserver.ifc.EmfSerializer;
//import org.bimserver.ifc.SerializerException;
//import org.bimserver.interfaces.objects.SCheckout;
//import org.bimserver.interfaces.objects.SList;
//import org.bimserver.interfaces.objects.SProject;
//import org.bimserver.interfaces.objects.SRevision;
//import org.bimserver.shared.ResultType;
//import org.bimserver.shared.SDownloadResult;
//import org.bimserver.shared.ServiceInterface;
//import org.bimserver.shared.Token;
//import org.bimserver.shared.UserException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class RestLikeServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 6286334261176028115L;
//	private static final Logger LOGGER = LoggerFactory.getLogger(RestLikeServlet.class);
//
//	private enum Action {
//		REVISIONS, CHECKOUTS, PROJECTS
//	}
//
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServiceInterface service = (ServiceInterface) getServletContext().getAttribute("service");
//		String[] urlParams = null;
//		if (request.getPathInfo() != null) {
//			urlParams = request.getPathInfo().split("/");
//		} else if (request.getQueryString() != null) {
//			urlParams = request.getQueryString().split("/");
//		}
//		long poid = -1;
//		long roid = -1;
//		long oid = -1;
//		String guid = null;
//		ResultType resultType = ResultType.TEXT;
//		Action action = null;
//		String className = null;
//		try {
//			if (urlParams != null) {
//				for (String param : urlParams) {
//					if (param.startsWith("poid=")) {
//						poid = Long.parseLong(param.substring(5));
//					} else if (param.startsWith("roid=")) {
//						roid = Long.parseLong(param.substring(5));
//					} else if (param.startsWith("oid=")) {
//						oid = Integer.parseInt(param.substring(4));
//					} else if (param.startsWith("guid=")) {
//						guid = param.substring(5);
//					} else if (param.startsWith("resultType=")) {
//						resultType = ResultType.valueOf(param.substring(11).toUpperCase());
//					} else if (param.startsWith("action=")) {
//						action = Action.valueOf(param.substring(7).toUpperCase());
//					} else if (param.startsWith("class=")) {
//						className = param.substring(6);
//					}
//				}
//			}
//		} catch (NumberFormatException e) {
//			response.getWriter().println("Some number was incorrectly formatted");
//			return;
//		}
//		response.setContentType(resultType.getContentType());
//		try {
//			Token token = service.createAnonymousToken();
//			if (urlParams == null) {
//				writeObject(response, service.getAllProjects(token), response.getOutputStream());
//			} else {
//				if (poid != -1) {
//					// Get a specific project
//					if (roid != -1) {
//						// Get a specific revision
//						if (oid != -1) {
//							// Get a specific object'
//							SDownloadResult downloadById = service.downloadByOids(token, createSet(roid), createSet(oid), resultType);
//							EmfSerializer serializer = (EmfSerializer)downloadById.getFile().getDataSource();
//							serializer.writeToOutputStream(response.getOutputStream());
//						} else {
//							if (guid != null) {
//								SDownloadResult downloadById = service.downloadByGuids(token, createSet(roid), createSet(guid), resultType);
//								EmfSerializer serializer = (EmfSerializer)downloadById.getFile().getDataSource();
//								serializer.writeToOutputStream(response.getOutputStream());
//							} else {
//								if (className != null) {
//									// Get all of class
//									SDownloadResult download = service.downloadOfType(token, roid, className, resultType);
//									EmfSerializer serializer = (EmfSerializer)download.getFile().getDataSource();
//									serializer.writeToOutputStream(response.getOutputStream());
//								} else {
//									// Get all objects
//									if (service.getRevision(token, roid) == null) {
//										response.getWriter().println("Project " + poid + " has no revision " + roid);
//									} else {
//										SDownloadResult download = service.download(token, roid, resultType);
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
//							SProject sProject = service.getProjectByPoid(token, poid);
//							SDownloadResult downloadById = service.downloadByOids(token, createSet(poid), createSet(service.getRevision(token, sProject.getLastRevisionId()).getId()), resultType);
//							downloadById.getFile().writeTo(response.getOutputStream());
//						} else {
//							if (action == null) {
//								// Get all objects
//								SProject sProject = service.getProjectByPoid(token, poid);
//								if (sProject.getLastRevisionId() == -1) {
//									response.getWriter().println("Project " + poid + " has no revisions");
//								} else {
//									SDownloadResult download = service.download(token, sProject.getLastRevisionId(), resultType);
//									EmfSerializer serializer = (EmfSerializer)download.getFile().getDataSource();
//									response.setHeader("Content-Disposition", "inline; filename=\"" + download.getProjectName() + "." + download.getRevisionNr() + "." + resultType.getDefaultExtension() + "\"");
//									serializer.writeToOutputStream(response.getOutputStream());
//								}
//							} else {
//								if (action == Action.CHECKOUTS) {
//									writeObject(response, service.getAllCheckoutsOfProject(token, poid), response.getOutputStream());
//								} else if (action == Action.REVISIONS) {
//									writeObject(response, service.getAllRevisionsOfProject(token, poid), response.getOutputStream());
//								} else if (action == Action.PROJECTS) {
//									writeObject(response, service.getAllProjects(token), response.getOutputStream());
//								}
//							}
//						}
//					}
//				}
//			}
//		} catch (UserException e) {
//			response.getWriter().print(e.getUserMessage());
//		} catch (SerializerException e) {
//			LOGGER.error("", e);
//		}
//	}
//
//	private Set<String> createSet(String value) {
//		HashSet<String> hashSet = new HashSet<String>();
//		hashSet.add(value);
//		return hashSet;
//	}
//	
//	private Set<Long> createSet(long value) {
//		HashSet<Long> hashSet = new HashSet<Long>();
//		hashSet.add(value);
//		return hashSet;
//	}
//	
//	private void writeObject(HttpServletResponse response, Object object, OutputStream out) {
//		try {
//			response.setContentType("text/xml");
//			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass(), SProject.class, SCheckout.class, SRevision.class, SList.class);
//			Marshaller marshaller = jaxbContext.createMarshaller();
//			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//			if (object instanceof List<?>) {
//				SList sList = new SList();
//				List<?> list = (List<?>)object;
//				sList.setList(list);
//				marshaller.marshal(sList, out);
//			} else {
//				marshaller.marshal(object, out);
//			}
//		} catch (JAXBException e) {
//			LOGGER.error("", e);
//		}
//	}
//}