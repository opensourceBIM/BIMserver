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

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataSource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.notifications.ProgressTopic;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.ExtendedDataSource;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.ServiceMap;
import org.bimserver.webservices.impl.BcfCache;
import org.opensourcebim.bcf.BcfException;
import org.opensourcebim.bcf.BcfFile;
import org.opensourcebim.bcf.ReadOptions;
import org.opensourcebim.bcf.TopicFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class DownloadServlet extends SubServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(DownloadServlet.class);

	public DownloadServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String acceptEncoding = request.getHeader("Accept-Encoding");
			boolean useGzip = false;
			if (acceptEncoding != null && acceptEncoding.contains("gzip")) {
				useGzip = true;
			}
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
			long topicId = -1;
			if (request.getParameter("topicId") != null) {
				topicId = Long.parseLong(request.getParameter("topicId"));
			}
			ServiceMap serviceMap = getBimServer().getServiceFactory().get(token, AccessMethod.INTERNAL);

			String action = request.getParameter("action");
			if (action != null) {
				if (action.equals("extendeddata")) {
					SExtendedData sExtendedData = serviceMap.getServiceInterface().getExtendedData(Long.parseLong(request.getParameter("edid")));
					SFile file = serviceMap.getServiceInterface().getFile(sExtendedData.getFileId());
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
							String protocolBuffersFile = serviceMap.getAdminInterface().getProtocolBuffersFile(request.getParameter("name"));
							outputStream.write(protocolBuffersFile.getBytes(Charsets.UTF_8));
							outputStream.flush();
						} catch (ServiceException e) {
							LOGGER.error("", e);
						}
					} else if (type.equals("serverlog")) {
						try {
							OutputStreamWriter writer = new OutputStreamWriter(outputStream);
							writer.write(serviceMap.getAdminInterface().getServerLog());
							writer.flush();
						} catch (ServerException e) {
							LOGGER.error("", e);
						} catch (UserException e) {
							LOGGER.error("", e);
						}
					}
				} else if (action.equals("getBcfImage")) {
					long extendedDataId = Long.parseLong(request.getParameter("extendedDataId"));
					String topicUuid = request.getParameter("topicUuid");
					String name = request.getParameter("name");
					BcfFile bcfFile = BcfCache.INSTANCE.get(extendedDataId);
					if (bcfFile == null) {
						SExtendedData extendedData = serviceMap.getServiceInterface().getExtendedData(extendedDataId);
						long fileId = extendedData.getFileId();
						SFile file = serviceMap.getServiceInterface().getFile(fileId);
						try {
							bcfFile = BcfFile.read(new ByteArrayInputStream(file.getData()), new ReadOptions(false));
							BcfCache.INSTANCE.put(extendedDataId, bcfFile);
						} catch (BcfException e) {
							e.printStackTrace();
						}
					}
					TopicFolder topicFolder = bcfFile.getTopicFolder(topicUuid);
					if (topicFolder != null) {
						byte[] data = topicFolder.getSnapshot(topicUuid + "/" + name);
						if (data != null) {
							response.setContentType("image/png");
							IOUtils.write(data, outputStream);
							if (outputStream instanceof GZIPOutputStream) {
								((GZIPOutputStream) outputStream).finish();
							}
							outputStream.flush();
							return;
						}
					}
				}
			} else {
				if (request.getParameter("topicId") != null) {
					topicId = Long.parseLong(request.getParameter("topicId"));
				}
				if (topicId == -1) {
					response.getWriter().println("No valid topicId");
					return;
				}
				SDownloadResult checkoutResult = serviceMap.getServiceInterface().getDownloadData(topicId);
				if (checkoutResult == null) {
					LOGGER.error("Invalid topicId: " + topicId);
				} else {
					DataSource dataSource = checkoutResult.getFile().getDataSource();
					PluginConfiguration pluginConfiguration = getBimServer().getPluginSettingsCache().getPluginSettings(checkoutResult.getSerializerOid());

					final ProgressTopic progressTopic = getBimServer().getNotificationsManager().getProgressTopic(topicId);

					ProgressReporter progressReporter = new ProgressReporter() {
						private long lastMax;
						private long lastProgress;
						private int stage = 3;
						private Date start = new Date();
						private String title = "Downloading...";
						
						@Override
						public void update(long progress, long max) {
							if (progressTopic != null) {
								LongActionState ds = StoreFactory.eINSTANCE.createLongActionState();
								ds.setStart(start);
								ds.setState(progress == max ? ActionState.FINISHED : ActionState.STARTED);
								ds.setTitle(title);
								ds.setStage(stage);
								ds.setProgress((int) Math.round(100.0 * progress / max));

								progressTopic.stageProgressUpdate(ds);
								
								this.lastMax = max;
								this.lastProgress = progress;
							}
						}

						@Override
						public void setTitle(String title) {
							if (progressTopic != null) {
								stage++;
								this.title = title;
								LongActionState ds = StoreFactory.eINSTANCE.createLongActionState();
								ds.setStart(new Date());
								ds.setState(lastProgress == lastMax ? ActionState.FINISHED : ActionState.STARTED);
								ds.setTitle(title);
								ds.setStage(stage);
								ds.setProgress((int) Math.round(100.0 * lastProgress / lastMax));

								progressTopic.stageProgressUpdate(ds);
							}
						}
					};

					try {
						if (zip) {
							if (pluginConfiguration.getString("ZipExtension") != null) {
								response.setHeader("Content-Disposition", "inline; filename=\"" + dataSource.getName() + "." + pluginConfiguration.getString(SerializerPlugin.ZIP_EXTENSION) + "\"");
							} else {
								response.setHeader("Content-Disposition", "inline; filename=\"" + dataSource.getName() + ".zip" + "\"");
							}
							response.setContentType("application/zip");

							String nameInZip = dataSource.getName() + "." + pluginConfiguration.getString(SerializerPlugin.EXTENSION);
							ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
							zipOutputStream.putNextEntry(new ZipEntry(nameInZip));
							
							processDataSource(zipOutputStream, dataSource, progressReporter);
							try {
								zipOutputStream.finish();
							} catch (IOException e) {
								// Sometimes it's already closed, that's no problem
							}
						} else {
							if (request.getParameter("mime") == null) {
								response.setContentType(pluginConfiguration.getString(SerializerPlugin.CONTENT_TYPE));
								response.setHeader("Content-Disposition", "inline; filename=\"" + dataSource.getName() + "." + pluginConfiguration.getString(SerializerPlugin.EXTENSION) + "\"");
							} else {
								response.setContentType(request.getParameter("mime"));
							}
							processDataSource(outputStream, dataSource, progressReporter);
						}
					} catch (SerializerException s) {
						if (s.getCause() != null && s.getCause() instanceof IOException) {
							
						} else {
							LOGGER.error("", s);
						}

						LongActionState ds = StoreFactory.eINSTANCE.createLongActionState();
						ds.setStart(new Date());
						ds.setState(ActionState.AS_ERROR);
						ds.setTitle(s.getMessage());
						ds.setProgress(-1);
						ds.setStage(3);
						ds.getErrors().add(s.getMessage());

						progressTopic.stageProgressUpdate(ds);
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

	private void processDataSource(OutputStream outputStream, DataSource dataSource, ProgressReporter progressReporter) throws Exception {
		if (dataSource instanceof ExtendedDataSource) {
			((ExtendedDataSource) dataSource).writeToOutputStream(outputStream, progressReporter);
		} else {
			throw new SerializerException("Unsupported datasource type: " + dataSource);
		}
	}
}