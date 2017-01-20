package org.bimserver.servlets;

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
import org.bimserver.utils.InputStreamDataSource;
import org.opensourcebim.bcf.utils.FakeClosingInputStream;
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
				long deserializerOid = -1;
				boolean sync = false;
				String action = null;
				long topicId = -1;
				while (iter.hasNext()) {
					FileItemStream item = iter.next();
					if (item.isFormField()) {
						if ("token".equals(item.getFieldName())) {
							token = Streams.asString(item.openStream());
						} else if ("poid".equals(item.getFieldName())) {
							poid = Long.parseLong(Streams.asString(item.openStream()));
						} else if ("comment".equals(item.getFieldName())) {
							comment = Streams.asString(item.openStream());
						} else if ("topicId".equals(item.getFieldName())) {
							topicId = Long.parseLong(Streams.asString(item.openStream()));
						} else if ("sync".equals(item.getFieldName())) {
							sync = Streams.asString(item.openStream()).equals("true");
						} else if ("deserializerOid".equals(item.getFieldName())) {
							deserializerOid = Long.parseLong(Streams.asString(item.openStream()));
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
									InputStreamDataSource inputStreamDataSource = new InputStreamDataSource(new FakeClosingInputStream(zipInputStream));
									inputStreamDataSource.setName(name);
									DataHandler ifcFile = new DataHandler(inputStreamDataSource);

									String path = fullfilename.substring(0, fullfilename.lastIndexOf("/"));
									String filename = fullfilename.substring(fullfilename.lastIndexOf("/") + 1);
									String extension = filename.substring(filename.lastIndexOf(".") + 1);

									SProject project = getOrCreatePath(service, mainProject, mainProject, path);
									SDeserializerPluginConfiguration deserializer = service.getSuggestedDeserializerForExtension(extension, project.getOid());
									
									service.checkin(project.getOid(), comment, deserializer.getOid(), -1L, filename, ifcFile, false, true);
								} else {
									LOGGER.info("Unknown fileextenstion " + fullfilename);
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
	
	private SProject getOrCreatePath(ServiceInterface service, SProject mainProject, SProject currentProject, String path) throws UserException, ServerException {
		String name = path;
		if (path.contains("/")) {
			name = path.substring(0, path.indexOf("/"));
		}
		SProject newProject = null;
		try {
			newProject = service.addProjectAsSubProject(name, currentProject.getOid(), currentProject.getSchema());
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			newProject = service.getSubProjectByName(currentProject.getOid(), name);
		}
		if (path.contains("/")) {
			return getOrCreatePath(service, mainProject, newProject, path.substring(path.indexOf("/") + 1));
		}
		return newProject;
	}
}
