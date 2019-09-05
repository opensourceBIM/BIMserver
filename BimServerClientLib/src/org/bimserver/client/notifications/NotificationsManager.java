package org.bimserver.client.notifications;

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

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.plugins.services.NotificationsManagerInterface;
import org.bimserver.plugins.services.ProgressHandler;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.NotificationInterfaceAdaptor;
import org.bimserver.shared.json.ConvertException;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.ReflectorException;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class NotificationsManager extends NotificationsClient implements NotificationsManagerInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsManager.class);
	private final Map<Long, Set<ProgressHandler>> progressListeners = java.util.Collections.synchronizedMap(new HashMap<>());
	private String address;
	private SServicesMap servicesMap;
	private volatile boolean running;
	private BimServerClient bimServerClient;
	private Long endpointid;
	private JsonConverter converter;
	private NotificationInterface service;
	private WebSocketClient webSocketClient;
	private WebSocketImpl webSocketImpl;

	public NotificationsManager(BimServerClient bimServerClient) {
		this.bimServerClient = bimServerClient;
		this.service = new NotificationInterfaceAdaptor(){
			@Override
			public void progress(Long topicId, SLongActionState state) throws UserException, ServerException {
				Set<ProgressHandler> set = progressListeners.get(topicId);
				if (set != null) {
					for (ProgressHandler progressHandler : set) {
						progressHandler.progress(state);
					}
				}
			}
		};
	}
	
	public void setBinaryMessageListener(long topicId, BinaryMessageListener binaryMessageListener) {
		webSocketImpl.setBinaryMessageListener(topicId, binaryMessageListener);
	}
	
	public void start() {
		webSocketClient = new WebSocketClient();
		try {
			webSocketClient.start();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		try {
			address = address.replace("http://", "ws://").replace("https://", "wss://");
			URI uri = URI.create(address + "/stream");
			webSocketImpl = new WebSocketImpl(this);
			ClientUpgradeRequest request = new ClientUpgradeRequest();
			webSocketClient.connect(webSocketImpl, uri, request);
			webSocketImpl.waitForEndpointId();
			running = true;
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public void connect(SServicesMap servicesMap, String address) {
		this.servicesMap = servicesMap;
		this.address = address;
		this.converter = new JsonConverter(servicesMap);
	}

	public void send(JsonNode jsonNode) {
		this.webSocketImpl.send(jsonNode);
	}
	
	public void disconnect() {
		running = false;
		if (webSocketImpl != null) {
			webSocketImpl.close();
		}
		if (webSocketClient != null) {
			try {
				webSocketClient.stop();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			webSocketClient.destroy();
		}
	}

	public boolean isRunning() {
		return running;
	}

	public synchronized void startAndWaitForInit() {
		start();
	}

	public void unregisterNotifictionListener(NotificationInterface notificationInterface) {
		
	}

	public BimServerClient getBimServerClient() {
		return bimServerClient;
	}

	public Long getEndpointid() {
		return endpointid;
	}
	
	public void setEndpointId(Long endpointid) {
		this.endpointid = endpointid;
	}

	public void unregisterProgressHandler(Long topicId, ProgressHandler progressHandler) {
		try {
			if (!progressListeners.containsKey(topicId)) {
				progressListeners.put(topicId, new HashSet<ProgressHandler>());
			}
			progressListeners.get(topicId).remove(progressHandler);
			bimServerClient.getRegistry().unregisterProgressHandler(topicId, getEndpointid());
		} catch (UserException e) {
//			LOGGER.error("", e);
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (PublicInterfaceNotFoundException e) {
			LOGGER.error("", e);
		}
	}
	
	public void registerProgressHandler(Long topicId, ProgressHandler progressHandler) {
		try {
			if (!progressListeners.containsKey(topicId)) {
				progressListeners.put(topicId, new HashSet<ProgressHandler>());
			}
			progressListeners.get(topicId).add(progressHandler);
			bimServerClient.getRegistry().registerProgressHandler(topicId, getEndpointid());
		} catch (UserException e) {
			LOGGER.error("", e);
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (PublicInterfaceNotFoundException e) {
			LOGGER.error("", e);
		}
	}

	public void handleIncoming(ObjectNode request) throws UserException, ConvertException, IOException {
		// TODO copied code from JsonHandler
		String interfaceName = request.get("interface").asText();
		String methodName = request.get("method").asText();
		SService sService = servicesMap.getByName(interfaceName);
		if (sService == null) {
			sService = servicesMap.getBySimpleName(interfaceName);
		}
		if (sService == null) {
			throw new UserException("No service found with name " + interfaceName);
		}
		SMethod method = sService.getSMethod(methodName);
		if (method == null) {
			SMethod alternative = servicesMap.findMethod(methodName);
			if (alternative == null) {
				throw new UserException("Method " + methodName + " not found on " + interfaceName);
			} else {
				throw new UserException("Method " + methodName + " not found on " + interfaceName + " (suggestion: " + alternative.getService().getSimpleName() + ")");
			}
		}
		KeyValuePair[] parameters = new KeyValuePair[method.getParameters().size()];
		if (request.has("parameters")) {
			ObjectNode parametersJson = (ObjectNode) request.get("parameters");
			for (int i = 0; i < method.getParameters().size(); i++) {
				SParameter parameter = method.getParameter(i);
				if (parametersJson.has(parameter.getName())) {
					parameters[i] = new KeyValuePair(parameter.getName(), converter.fromJson(parameter.getType(), parameter.getGenericType(),
							parametersJson.get(parameter.getName())));
				} else {
					LOGGER.error("Missing parameters: " + method.getName() + " -> " + parameter.getName());
				}
			}
		} else {
			throw new UserException("Missing 'parameters' field");
		}
		
		try {
			method.invoke(sService.getInterfaceClass(), service, parameters);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (ReflectorException e) {
			LOGGER.error("", e);
		}
	}

	public void socketIsClosed() {
//		LOGGER.info("WebSocket is closed");
		this.running = false;
		this.endpointid = null;
	}
}