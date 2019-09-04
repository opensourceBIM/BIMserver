package org.bimserver;

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
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.webservices.ServiceMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonHandler.class);
	private final BimServer bimServer;
	private final JsonConverter converter;
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public JsonHandler(BimServer bimServer) {
		this.bimServer = bimServer;
		this.converter = new JsonConverter(bimServer.getServicesMap());
	}

	public void execute(ObjectNode incomingMessage, HttpServletRequest httpRequest, Writer out) {
		JsonFactory jsonFactory = new JsonFactory();
		JsonGenerator writer = null;
		try {
			writer = jsonFactory.createGenerator(out);
			writer.writeStartObject();
			String token = incomingMessage.has("token") ? incomingMessage.get("token").asText() : null;
			String oAuthCode = incomingMessage.has("oauthcode") ? incomingMessage.get("oauthcode").asText() : null;
			long messageId = incomingMessage.has("id") ? incomingMessage.get("id").asLong() : -1;
			if (messageId != -1) {
				writer.writeFieldName("id");
				writer.writeNumber(messageId);
			}
			if (incomingMessage.has("request")) {
				writer.writeFieldName("response");
				processSingleRequest((ObjectNode) incomingMessage.get("request"), token, oAuthCode, httpRequest, writer);
			} else if (incomingMessage.has("requests")) {
				processMultiRequest((ArrayNode) incomingMessage.get("requests"), token, oAuthCode, httpRequest, writer);
			}
		} catch (Throwable throwable) {
			if (throwable instanceof UserException) {

			} else {
				LOGGER.info(incomingMessage.toString());
				LOGGER.info("", throwable);
			}
			// throwable.printStackTrace();
			handleThrowable(writer, throwable);
		} finally {
			try {
				writer.writeEndObject();
				writer.close();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
	}

	private void processMultiRequest(ArrayNode requests, String jsonToken, String oAuthCode, HttpServletRequest httpRequest, JsonGenerator out) throws Exception {
		out.writeFieldName("responses");
		out.writeStartArray();
		for (int r = 0; r < requests.size(); r++) {
			try {
				processSingleRequest((ObjectNode) requests.get(r), jsonToken, oAuthCode, httpRequest, out);
			} catch (Exception e) {
				handleThrowable(out, e);
			}
		}
		out.writeEndArray();
	}

	private void processSingleRequest(ObjectNode request, String jsonToken, String oAuthCode, HttpServletRequest httpRequest, JsonGenerator writer) throws Exception {
		long s = System.nanoTime();
		if (!request.has("interface")) {
			throw new UserException("No \"interface\" parameter found in request");
		}
		String interfaceName = request.get("interface").asText();
		if (!request.has("method")) {
			throw new UserException("No \"method\" parameter found in request");
		}
		String methodName = request.get("method").asText();
		SService sService = bimServer.getServicesMap().getByName(interfaceName);
		if (sService == null) {
			sService = bimServer.getServicesMap().getBySimpleName(interfaceName);
		}
		if (sService == null) {
			throw new UserException("No service found with name " + interfaceName);
		}
		SMethod method = sService.getSMethod(methodName);
		if (method == null) {
			SMethod alternative = bimServer.getServicesMap().findMethod(methodName);
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
					parameters[i] = new KeyValuePair(parameter.getName(), converter.fromJson(parameter.getType(), parameter.getGenericType(), parametersJson.get(parameter.getName())));
				} else {
					LOGGER.error("Missing parameter: " + method.getName() + " -> " + parameter.getName());
					throw new UserException("Missing parameter: " + method.getName() + " -> " + parameter.getName());
				}
			}
		} else if (parameters.length > 0) {
			throw new UserException("Missing 'parameters' field, expected " + parameters.length + " parameters");
		}

		ServiceMap serviceMap = getServiceMap(httpRequest, bimServer, methodName, jsonToken, oAuthCode);
		PublicInterface service = getServiceInterface(httpRequest, bimServer, sService.getInterfaceClass(), methodName, jsonToken, serviceMap);
		String oldThreadName = Thread.currentThread().getName();
		Thread.currentThread().setName(interfaceName + "." + methodName);
		try {
			boolean isMonitor = serviceMap != null && serviceMap.getUser() != null && serviceMap.getUser().getUserType() == UserType.MONITOR;
			Recording recording = null;
			if (!isMonitor) {
				recording = bimServer.getMetricsRegistry().startRecording(sService, method);
			}

			Object result = method.invoke(sService.getInterfaceClass(), service, parameters);

			if (!isMonitor) {
				recording.finish();
			}

			// When we have managed to get here, no exceptions have been thrown.
			// We
			// can safely assume further serialization to JSON won't fail. So
			// now we
			// can start streaming
			if (writer != null) {
				if (result == null) {
					writer.writeStartObject();
					writer.writeFieldName("result");
					writer.writeStartObject();
					writer.writeEndObject();
					writer.writeEndObject();
				} else {
					writer.writeStartObject();
					writer.writeFieldName("result");
					JsonNode jsonResult = converter.toJson(result);
					OBJECT_MAPPER.writeValue(writer, jsonResult);
					writer.writeEndObject();
				}
			}
			long e = System.nanoTime();
			LOGGER.debug(interfaceName + "." + methodName + " " + ((e - s) / 1000000) + "ms");
		} finally {
			Thread.currentThread().setName(oldThreadName);
		}
	}

	private void handleThrowable(JsonGenerator writer, Throwable throwable) {
		if (!(throwable instanceof ServiceException)) {
			LoggerFactory.getLogger(JsonHandler.class).error("", throwable);
		} else {
			if (LoggerFactory.getLogger(JsonHandler.class).isDebugEnabled()) {
				LoggerFactory.getLogger(JsonHandler.class).debug("", throwable);
			}
		}
		try {
			writer.writeStartObject();
			writer.writeFieldName("exception");
			writer.writeStartObject();
			writer.writeFieldName("__type");
			writer.writeString(throwable.getClass().getSimpleName());
			writer.writeFieldName("message");
			writer.writeString(throwable.getMessage() == null ? throwable.toString() : throwable.getMessage());
			if (throwable instanceof ServiceException) {
				ServiceException serviceException = (ServiceException) throwable;
				if (serviceException.getErrorCode() != null) {
					writer.writeFieldName("errorType");
					writer.writeString(serviceException.getErrorCode().getClass().getSimpleName());
					writer.writeFieldName("errorCode");
					writer.writeNumber(serviceException.getErrorCode().getCode());
				}
			}
			writer.writeEndObject();
			writer.writeEndObject();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	private ServiceMap getServiceMap(HttpServletRequest httpRequest, BimServer bimServer, String methodName, String token, String oAuthCode) throws UserException {
		if (token == null) {
			token = httpRequest == null ? null : (String) httpRequest.getSession().getAttribute("token");
		}
		if (token == null) {
			token = oAuthCode;
		}
		if (token == null) {
			if (httpRequest != null) {
				try {
					OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(httpRequest, ParameterStyle.HEADER);
					token = oauthRequest.getAccessToken();
				} catch (OAuthSystemException e) {
				} catch (OAuthProblemException e) {
				}
			}
		}
		if (token == null) {
			return null;
		}
		ServiceMap serviceMap = bimServer.getServiceFactory().get(token, AccessMethod.JSON);
		return serviceMap;
	}
	
	private <T extends PublicInterface> T getServiceInterface(HttpServletRequest httpRequest, BimServer bimServer, Class<T> interfaceClass, String methodName, String token, ServiceMap serviceMap) throws UserException, ServerException {
		if (serviceMap == null) {
			return bimServer.getServiceFactory().get(AccessMethod.JSON).get(interfaceClass);
		}
		if (methodName.equals("login") || methodName.equals("autologin")) {
			return bimServer.getServiceFactory().get(AccessMethod.JSON).get(interfaceClass);
		}
		T service = serviceMap.get(interfaceClass);
		if (service == null) {
			service = bimServer.getServiceFactory().get(AccessMethod.JSON).get(interfaceClass);
			if (httpRequest != null) {
				httpRequest.getSession().setAttribute("token", token);
			}
		}
		return service;
	}

	public JsonConverter getJsonConverter() {
		return converter;
	}
}