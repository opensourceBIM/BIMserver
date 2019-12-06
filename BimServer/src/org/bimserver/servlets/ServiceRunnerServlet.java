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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.bimbots.BimBotsOutput;
import org.bimserver.bimbots.BimBotsServiceInterface;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.notifications.TopicKey;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.AuthenticationException;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.RunServiceAuthorization;
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
		if (token == null) {
			response.sendError(403, "Token required");
		}
		
		String serviceName = request.getHeader("ServiceName");
		if (serviceName == null) {
			serviceName = request.getRequestURI();
			LOGGER.info("Request URI: " + serviceName);
			if (serviceName.startsWith("/services/")) {
				serviceName = serviceName.substring(10);
			}
		}
		if (serviceName == null || serviceName.trim().contentEquals("") || serviceName.trim().contentEquals("/") || serviceName.contentEquals("/services") || serviceName.contentEquals("/services/")) {
			// Get it from the token
			try {
				Authorization authorization = Authorization.fromToken(getBimServer().getEncryptionKey(), token);
				LOGGER.info("Authorization: " + authorization);
				if (authorization instanceof RunServiceAuthorization) {
					RunServiceAuthorization runServiceAuthorization = (RunServiceAuthorization)authorization;
					serviceName = "" + runServiceAuthorization.getSoid();
					LOGGER.info("Got SOID from token (" + serviceName + ")");
				}
			} catch (AuthenticationException e) {
				LOGGER.error("", e);
			}
		}
		LOGGER.info("ServiceName: " + serviceName);
		long serviceOid = Long.parseLong(serviceName);
		
		String inputType = request.getHeader("Input-Type");
		LOGGER.info("Input-Type: " + inputType);
		
		Set<String> acceptedFlows = new LinkedHashSet<>();
		if (request.getHeader("Accept-Flow") == null) {
			// Default
			acceptedFlows.add("SYNC");
		} else {
			String[] flows = request.getHeader("Accept-Flow").split(",");
			for (String flow : flows) {
				acceptedFlows.add(flow);
			}
		}
		
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
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
				EndPoint endPoint = getBimServer().getEndPointManager().get(token);
				InputStream inputStream = request.getInputStream();
				String contextId = request.getHeader("Context-Id");
				if (endPoint == null || !acceptedFlows.contains("ASYNC_WS")) {
					// Don't use a websocket, so synchronously process bimbot
					BimBotsOutput bimBotsOutput = new BimBotRunner(getBimServer(), inputStream, contextId, inputType, authorization, foundService, bimBotsServiceInterface).runBimBot();

					response.setContentLength(bimBotsOutput.getData().length);
					response.setHeader("Output-Type", bimBotsOutput.getSchemaName());
					response.setHeader("Data-Title", bimBotsOutput.getTitle());
					response.setHeader("Content-Type", bimBotsOutput.getContentType());
					response.setHeader("Content-Disposition", bimBotsOutput.getContentDisposition());
					if (bimBotsOutput.getContextId() != null) {
						response.setHeader("Context-Id", bimBotsOutput.getContextId());
					}
					response.getOutputStream().write(bimBotsOutput.getData());
				} else {
					TopicKey topicKey = new TopicKey();
					response.setHeader("Output-Type", "Async");
					response.setHeader("Topic-Id", "" + topicKey.getId());
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					IOUtils.copy(inputStream, baos);
					// When storing bimbot runs, a streaming deserialzer is used later in the process, memory usage can be reduced by 
					// streaming the data, but that would require the http socket to stay open (and the response witheld), which is not an option, hence the copy.
					
					// TODO this can only start as soon as the response has been sent
					getBimServer().getExecutorService().submit(new BimBotRunner(getBimServer(), new ByteArrayInputStream(baos.toByteArray()), contextId, inputType, authorization, foundService, bimBotsServiceInterface, endPoint.getStreamingSocketInterface(), topicKey.getId(), endPoint.getEndPointId()));
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
		ArrayNode capabilities = mapper.createArrayNode();
		capabilities.add("WEBSOCKET");
		result.set("capabilities", capabilities);
		result.set("services", array);
		try (DatabaseSession session = database.createSession(OperationType.READ_ONLY)) {
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
							String siteAddress = getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress();
							oauth.put("authorizationUrl", siteAddress + "/oauth/authorize");
							oauth.put("registerUrl", siteAddress + "/oauth/register");
							oauth.put("tokenUrl", siteAddress + "/oauth/access");
							
							descriptorJson.set("oauth", oauth);
							descriptorJson.put("resourceUrl", siteAddress + "/services");
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