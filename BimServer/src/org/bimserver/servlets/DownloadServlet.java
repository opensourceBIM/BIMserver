package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.cache.FileInputStreamDataSource;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.EmfSerializerDataSource;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 732025375536415841L;
	private static final Logger LOGGER = LoggerFactory.getLogger(DownloadServlet.class);

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BimServer bimServer = (BimServer) getServletContext().getAttribute("bimserver");
		try {
			if (request.getHeader("Origin") != null && !bimServer.getServerSettingsCache().isHostAllowed(request.getHeader("Origin"))) {
				response.setStatus(403);
				return;
			}
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
			response.setHeader("Access-Control-Allow-Headers", "Content-Type");
			boolean useGzip = true;
			OutputStream outputStream = response.getOutputStream();
			boolean zip = request.getParameter("zip") != null && request.getParameter("zip").equals("on");
			if (useGzip && !zip) {
				response.setHeader("Content-Encoding", "gzip");
				outputStream = new GZIPOutputStream(response.getOutputStream());
			}
			String token = (String) request.getSession().getAttribute("token");

			if (token == null) {
				token = request.getParameter("token");
			}
			ServiceInterface serviceInterface = bimServer.getServiceFactory().get(token, AccessMethod.INTERNAL).get(ServiceInterface.class);
			PluginInterface pluginInterface = bimServer.getServiceFactory().get(token, AccessMethod.INTERNAL).get(PluginInterface.class);
			AdminInterface adminInterface = bimServer.getServiceFactory().get(token, AccessMethod.INTERNAL).get(AdminInterface.class);

			String action = request.getParameter("action");
			if (action != null) {
				if (action.equals("extendeddata")) {
					SExtendedData sExtendedData = serviceInterface.getExtendedData(Long.parseLong(request.getParameter("edid")));
					SFile file = serviceInterface.getFile(sExtendedData.getFileId());
					if (file.getMime() != null) {
						response.setContentType(file.getMime());
					}
					if (file.getFilename() != null) {
						response.setHeader("Content-Disposition", "inline; filename=\"" + file.getFilename() + "\"");
					}
					outputStream.write(file.getData());
					if (outputStream instanceof GZIPOutputStream) {
						((GZIPOutputStream) outputStream).finish();
					}
					outputStream.flush();
					return;
				} else if (action.equals("getfile")) {
					String type = request.getParameter("type");
					if (type.equals("proto")) {
						try {
							String protocolBuffersFile = adminInterface.getProtocolBuffersFile(request.getParameter("name"));
							outputStream.write(protocolBuffersFile.getBytes(Charsets.UTF_8));
							outputStream.flush();
						} catch (ServiceException e) {
							LOGGER.error("", e);
						}
					} else if (type.equals("serverlog")) {
						try {
							OutputStreamWriter writer = new OutputStreamWriter(outputStream);
							writer.write(adminInterface.getServerLog());
							writer.flush();
						} catch (ServerException e) {
							LOGGER.error("", e);
						} catch (UserException e) {
							LOGGER.error("", e);
						}
					}
				}
			} else {
				SSerializerPluginConfiguration serializer = null;
				if (request.getParameter("serializerOid") != null) {
					long serializerOid = Long.parseLong(request.getParameter("serializerOid"));
					serializer = pluginInterface.getSerializerById(serializerOid);
				} else {
					serializer = pluginInterface.getSerializerByName(request.getParameter("serializerName"));
				}
				long downloadId = -1;
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
					downloadId = serviceInterface.downloadRevisions(roids, serializer.getOid(), true);
				} else if (request.getParameter("compare") != null) {
					SCompareType sCompareType = SCompareType.valueOf(request.getParameter("type"));
					Long roid1 = Long.parseLong(request.getParameter("roid1"));
					Long roid2 = Long.parseLong(request.getParameter("roid2"));
					downloadId = serviceInterface.downloadCompareResults(serializer.getOid(), roid1, roid2, Long.valueOf(request.getParameter("mcid")), sCompareType, true);
				} else {
					long roid = -1;
					if (request.getParameter("roid") == null) {
						if (request.getParameter("poid") != null) {
							long poid = Long.parseLong(request.getParameter("poid"));
							SProject projectByPoid = serviceInterface.getProjectByPoid(poid);
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
						downloadId = serviceInterface.checkout(roid, serializer.getOid(), true);
					} else {
						if (request.getParameter("classses") != null) {
							Set<String> classes = new HashSet<String>();
							for (String className : request.getParameter("classses").split(";")) {
								classes.add(className);
							}
							Set<Long> roids = new HashSet<Long>();
							roids.add(roid);
							downloadId = serviceInterface.downloadByTypes(roids, classes, serializer.getOid(), false, true, true, true);
						} else if (request.getParameter("oids") != null) {
							Set<Long> oids = new HashSet<Long>();
							for (String oidString : request.getParameter("oids").split(";")) {
								oids.add(Long.parseLong(oidString));
							}
							Set<Long> roids = new HashSet<Long>();
							roids.add(roid);
							downloadId = serviceInterface.downloadByOids(roids, oids, serializer.getOid(), true, true);
						} else if (request.getParameter("guids") != null) {
							Set<String> guids = new HashSet<String>();
							for (String guid : request.getParameter("guids").split(";")) {
								guids.add(guid);
							}
							Set<Long> roids = new HashSet<Long>();
							roids.add(roid);
							downloadId = serviceInterface.downloadByGuids(roids, guids, serializer.getOid(), false, true);
						} else {
							downloadId = serviceInterface.download(roid, serializer.getOid(), true, true);
						}
					}
				}
				if (downloadId == -1) {
					response.getWriter().println("No valid download");
					return;
				}
				SDownloadResult checkoutResult = serviceInterface.getDownloadData(downloadId);
				if (checkoutResult == null) {
					LOGGER.error("Invalid downloadId: " + downloadId);
				} else {
					DataSource dataSource = checkoutResult.getFile().getDataSource();
					PluginConfiguration pluginConfiguration = new PluginConfiguration(pluginInterface.getPluginSettings(serializer.getOid()));
					if (zip) {
						if (pluginConfiguration.getString("ZipExtension") != null) {
							response.setHeader("Content-Disposition",
									"inline; filename=\"" + dataSource.getName() + "." + pluginConfiguration.getString(SerializerPlugin.ZIP_EXTENSION) + "\"");
						} else {
							response.setHeader("Content-Disposition", "inline; filename=\"" + dataSource.getName() + ".zip" + "\"");
						}
						response.setContentType("application/zip");
						String nameInZip = checkoutResult.getProjectName() + "." + checkoutResult.getRevisionNr() + "." + pluginConfiguration.getString(SerializerPlugin.EXTENSION);
						ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
						zipOutputStream.putNextEntry(new ZipEntry(nameInZip));
						if (dataSource instanceof FileInputStreamDataSource) {
							InputStream inputStream = ((FileInputStreamDataSource) dataSource).getInputStream();
							IOUtils.copy(inputStream, zipOutputStream);
							inputStream.close();
						} else {
							((EmfSerializerDataSource) dataSource).writeToOutputStream(zipOutputStream);
						}
						try {
							zipOutputStream.finish();
						} catch (IOException e) {
							// Sometimes it's already closed, that's no problem
						}
					} else {
						if (request.getParameter("mime") == null) {
							response.setContentType(pluginConfiguration.getString(SerializerPlugin.CONTENT_TYPE));
							response.setHeader("Content-Disposition",
									"inline; filename=\"" + dataSource.getName() + "." + pluginConfiguration.getString(SerializerPlugin.EXTENSION) + "\"");
						} else {
							response.setContentType(request.getParameter("mime"));
						}
						try {
							if (dataSource instanceof FileInputStreamDataSource) {
								InputStream inputStream = ((FileInputStreamDataSource) dataSource).getInputStream();
								IOUtils.copy(inputStream, outputStream);
								inputStream.close();
							} else {
								((EmfSerializerDataSource) dataSource).writeToOutputStream(outputStream);
							}
						} catch (SerializerException e) {
							LOGGER.error("", e);
						}
					}
				}
			}
			if (outputStream instanceof GZIPOutputStream) {
				((GZIPOutputStream) outputStream).finish();
			}
			outputStream.flush();
		} catch (NumberFormatException e) {
			LOGGER.error("", e);
			response.getWriter().println("Some number was incorrectly formatted");
		} catch (ServiceException e) {
			LOGGER.error("", e);
			response.getWriter().println(e.getUserMessage());
		} catch (EOFException e) {
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}