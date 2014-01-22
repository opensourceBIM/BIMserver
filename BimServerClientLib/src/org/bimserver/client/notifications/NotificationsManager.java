package org.bimserver.client.notifications;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ProgressHandler;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.Bimsie1NotificationInterfaceAdaptor;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationInterface;
import org.bimserver.shared.json.ConvertException;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.json.ReflectorException;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.reflector.KeyValuePair;
import org.codehaus.jettison.json.JSONException;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

public class NotificationsManager extends NotificationsClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsManager.class);
	private final Map<Long, Set<ProgressHandler>> progressListeners = new HashMap<Long, Set<ProgressHandler>>();
	private String address;
	private SServicesMap servicesMap;
	private volatile boolean running;
	private BimServerClient bimServerClient;
	private long endpointid;
	private JsonConverter converter;
	private Bimsie1NotificationInterface service;
	private WebSocketClient webSocketClient;
	private WebSocketImpl webSocketImpl;

	public NotificationsManager(BimServerClient bimServerClient) {
		this.bimServerClient = bimServerClient;
		this.service = new Bimsie1NotificationInterfaceAdaptor(){
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
	
	public void start() {
		System.out.println("Starting websocket");
		webSocketClient = new WebSocketClient();
		try {
			webSocketClient.start();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		try {
			URI uri = URI.create("ws://" + address + "/stream");
			System.out.println(uri);
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

	public void startAndWaitForInit() {
		running = true;
		start();
	}

	public void unregisterNotifictionListener(Bimsie1NotificationInterface notificationInterface) {
		
	}

	public BimServerClient getBimServerClient() {
		return bimServerClient;
	}

	public long getEndpointid() {
		return endpointid;
	}
	
	public void setEndpointId(long endpointid) {
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
			LOGGER.error("", e);
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

	public void handleIncoming(JsonObject request) throws UserException, JSONException, ConvertException, IOException {
		String interfaceName = request.get("interface").getAsString();
		String methodName = request.get("method").getAsString();
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
			JsonObject parametersJson = request.getAsJsonObject("parameters");
			for (int i = 0; i < method.getParameters().size(); i++) {
				SParameter parameter = method.getParameter(i);
				if (parametersJson.has(parameter.getName())) {
					parameters[i] = new KeyValuePair(parameter.getName(), converter.fromJson(parameter.getType(), parameter.getGenericType(),
							parametersJson.get(parameter.getName())));
				} else {
					LOGGER.error("Missing parameters: " + method.getName() + " -> " + parameter.getName());
				}
			}
		}
		
		try {
			method.invoke(sService.getInterfaceClass(), service, parameters);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (ReflectorException e) {
			LOGGER.error("", e);
		}
	}
}