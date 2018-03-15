package org.bimserver.servlets;

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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

import javax.activation.DataHandler;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.bimbots.BimBotsException;
import org.bimserver.bimbots.BimBotsOutput;
import org.bimserver.bimbots.BimBotsServiceInterface;
import org.bimserver.bimbots.BimServerBimBotsInput;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OldQuery.Deep;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.SchemaName;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.utils.InputStreamDataSource;
import org.bimserver.webservices.authorization.AuthenticationException;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ServiceRunnerServlet extends SubServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRunnerServlet.class);
	
	public ServiceRunnerServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getRequestURI().endsWith("/servicelist")) {
			processServiceList(request, response);
			return;
		}
		String token = null;
		if (request.getHeader("Authorization") != null) {
			String a = request.getHeader("Authorization");
			if (a.startsWith("Bearer")) {
				token = a.substring(7);
			}
		}
		if (token == null) {
			token = request.getHeader("Token");
		}
		
		LOGGER.info("Token: " + token);
		
		String serviceName = request.getHeader("ServiceName");
		if (serviceName == null) {
			serviceName = request.getRequestURI();
			if (serviceName.startsWith("/services/")) {
				serviceName = serviceName.substring(10);
			}
		}
		LOGGER.info("ServiceName: " + serviceName);
		long serviceOid = Long.parseLong(serviceName);
		
		String inputType = request.getHeader("Input-Type");
		LOGGER.info("Input-Type: " + inputType);
		
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			Authorization authorization = Authorization.fromToken(getBimServer().getEncryptionKey(), token);
			User user = session.get(authorization.getUoid(), OldQuery.getDefault());
			if (user == null) {
				LOGGER.error("Service \"" + serviceName + "\" not found for this user");
				throw new UserException("No user found with uoid " + authorization.getUoid());
			}
			if (user.getState() == ObjectState.DELETED) {
				LOGGER.error("User has been deleted");
				throw new UserException("User has been deleted");
			}
			InternalServicePluginConfiguration foundService = null;
			UserSettings userSettings = user.getUserSettings();
			for (InternalServicePluginConfiguration internalServicePluginConfiguration : userSettings.getServices()) {
				if (internalServicePluginConfiguration.getOid() == serviceOid) {
					foundService = internalServicePluginConfiguration;
					break;
				}
			}
			if (foundService == null) {
				LOGGER.info("Service \"" + serviceName + "\" not found for this user");
				throw new ServletException("Service \"" + serviceName + "\" not found for this user");
			}
			PluginDescriptor pluginDescriptor = foundService.getPluginDescriptor();
			ServicePlugin servicePlugin = getBimServer().getPluginManager().getServicePlugin(pluginDescriptor.getPluginClassName(), true);
			if (servicePlugin instanceof BimBotsServiceInterface) {
				LOGGER.info("Found service " + servicePlugin);
				BimBotsServiceInterface bimBotsServiceInterface = (BimBotsServiceInterface)servicePlugin;
				try {
					if (getBimServer().getServerSettingsCache().getServerSettings().isStoreServiceRuns()) {
						LOGGER.info("Storing intermediate results");
						// When we store service runs, we can just use the streaming deserializer to stream directly to the database, after that we'll trigger the actual service
						
						// Create or find project and link user and service to project
						// Checkin stream into project
						// Trigger service
						
						ServiceInterface serviceInterface = getBimServer().getServiceFactory().get(authorization, AccessMethod.INTERNAL).get(ServiceInterface.class);
						SProject project = serviceInterface.addProject("tmp-" + new Random().nextInt(), "ifc2x3tc1");
						SDeserializerPluginConfiguration deserializer = serviceInterface.getSuggestedDeserializerForExtension("ifc", project.getOid());
						if (deserializer == null) {
							throw new BimBotsException("No deserializer found");
						}
						serviceInterface.checkin(project.getOid(), "Auto checkin", deserializer.getOid(), -1L, "s", new DataHandler(new InputStreamDataSource(request.getInputStream())), false, true);
						project = serviceInterface.getProjectByPoid(project.getOid());
						
						PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(project.getSchema());
						IfcModelInterface model = new BasicIfcModel(packageMetaData, null);
						try {
							Revision revision = session.get(project.getLastRevisionId(), OldQuery.getDefault());
							session.getMap(model, new OldQuery(packageMetaData, project.getId(), revision.getId(), revision.getOid(), null, Deep.NO));
						} catch (BimserverDatabaseException e) {
							e.printStackTrace();
						}
						
						BimServerBimBotsInput input = new BimServerBimBotsInput(getBimServer(), authorization.getUoid(), null, null, model);
						BimBotsOutput output = bimBotsServiceInterface.runBimBot(input, getBimServer().getSConverter().convertToSObject(foundService.getSettings()));
						
						SExtendedData extendedData = new SExtendedData();
						SFile file = new SFile();
						file.setData(output.getData());
						file.setFilename(output.getContentDisposition());
						file.setMime(output.getContentType());
						file.setSize(output.getData().length);
						Long fileId = serviceInterface.uploadFile(file);
						extendedData.setFileId(fileId);
						extendedData.setTitle(output.getTitle());
						SExtendedDataSchema extendedDataSchema = null;
						try {
							extendedDataSchema = serviceInterface.getExtendedDataSchemaByName(output.getSchemaName());
						} catch (UserException e) {
							extendedDataSchema = new SExtendedDataSchema();
							extendedDataSchema.setContentType(output.getContentType());
							extendedDataSchema.setName(output.getSchemaName());
							serviceInterface.addExtendedDataSchema(extendedDataSchema);
						}
						extendedData.setSchemaId(extendedDataSchema.getOid());
						serviceInterface.addExtendedDataToRevision(project.getLastRevisionId(), extendedData);
						
						response.setHeader("Output-Type", output.getSchemaName());
						response.setHeader("Data-Title", output.getTitle());
						response.setHeader("Data-Identifier", "" + project.getOid());
						response.setHeader("Content-Type", output.getContentType());
						response.setHeader("Content-Disposition", output.getContentDisposition());
						response.getOutputStream().write(output.getData());
					} else {
						// When we don't store the service runs, there is no other way than to just use the old deserializer and run the service from the EMF model
						LOGGER.info("NOT Storing intermediate results");

						DeserializerPlugin deserializerPlugin = getBimServer().getPluginManager().getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
						if (deserializerPlugin == null) {
							throw new BimBotsException("No deserializer plugin found");
						}
						
						byte[] data = IOUtils.toByteArray(request.getInputStream());
						SchemaName schema = SchemaName.valueOf(inputType);
						
						Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
						PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData("ifc2x3tc1");
						deserializer.init(packageMetaData);
						IfcModelInterface model = deserializer.read(new ByteArrayInputStream(data), schema.name(), data.length, null);
						
						BimServerBimBotsInput input = new BimServerBimBotsInput(getBimServer(), authorization.getUoid(), schema, data, model);
						BimBotsOutput output = bimBotsServiceInterface.runBimBot(input, getBimServer().getSConverter().convertToSObject(foundService.getSettings()));
						response.setHeader("Output-Type", output.getSchemaName());
						response.setHeader("Data-Title", output.getTitle());
						response.setHeader("Content-Type", output.getContentType());
						response.setHeader("Content-Disposition", output.getContentDisposition());
						response.getOutputStream().write(output.getData());
					}
				} catch (BimBotsException e) {
					LOGGER.error("", e);
				} catch (DeserializeException e) {
					LOGGER.error("", e);
				} catch (PluginException e) {
					LOGGER.error("", e);
				} catch (ServerException e) {
					LOGGER.error("", e);
				}
			} else {
				throw new ServletException("Service \"" + serviceName + "\" does not implement the BimBotsServiceInterface");
			}
		} catch (AuthenticationException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (UserException e) {
			LOGGER.error("", e);
		}
	}

	private void processServiceList(HttpServletRequest request, HttpServletResponse response) {
		BimDatabase database = getBimServer().getDatabase();
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode result = mapper.createObjectNode();
		ArrayNode array = mapper.createArrayNode();
		result.set("services", array);
		try (DatabaseSession session = database.createSession()) {
			for (PluginDescriptor pluginDescriptor : session.getAllOfType(StorePackage.eINSTANCE.getPluginDescriptor(), PluginDescriptor.class, OldQuery.getDefault())) {
				if (pluginDescriptor.getPluginInterfaceClassName().equals(ServicePlugin.class.getName())) {
					ServicePlugin servicePlugin = getBimServer().getPluginManager().getServicePlugin(pluginDescriptor.getPluginClassName(), true);
					if (servicePlugin instanceof BimBotsServiceInterface) {
						try {
							BimBotsServiceInterface bimBotsServiceInterface = (BimBotsServiceInterface)servicePlugin;
							
							ObjectNode descriptorJson = mapper.createObjectNode();
							descriptorJson.put("id", pluginDescriptor.getOid());
							descriptorJson.put("name", pluginDescriptor.getName());
							descriptorJson.put("description", pluginDescriptor.getDescription());
							descriptorJson.put("provider", getBimServer().getServerSettingsCache().getServerSettings().getName());
							descriptorJson.put("providerIcon", getBimServer().getServerSettingsCache().getServerSettings().getIcon());
							
							ArrayNode inputs = mapper.createArrayNode();
							ArrayNode outputs = mapper.createArrayNode();
							
							for (String schemaName : bimBotsServiceInterface.getAvailableInputs()) {
								inputs.add(schemaName);
							}
							for (String schemaName : bimBotsServiceInterface.getAvailableOutputs()) {
								outputs.add(schemaName);
							}
							
							descriptorJson.set("inputs", inputs);
							descriptorJson.set("outputs", outputs);
							
							ObjectNode oauth = mapper.createObjectNode();
							oauth.put("authorizationUrl", getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/oauth/authorize");
							oauth.put("registerUrl", getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/oauth/register");
							oauth.put("tokenUrl", getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/oauth/access");
							
							descriptorJson.set("oauth", oauth);
							descriptorJson.put("resourceUrl", getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/services");
							array.add(descriptorJson);
						} catch (Exception e) {
							LOGGER.error("", e);
						}
					}
				}
			}
			response.setContentType("application/json");
			response.getOutputStream().write(mapper.writeValueAsBytes(result));
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (JsonProcessingException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
}