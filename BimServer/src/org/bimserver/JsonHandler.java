package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.reflector.KeyValuePair;
import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

public class JsonHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonHandler.class);
	private final BimServer bimServer;
	private final JsonConverter converter;

	public JsonHandler(BimServer bimServer) {
		this.bimServer = bimServer;
		this.converter = new JsonConverter(bimServer.getServicesMap());
	}

	public void execute(JsonObject incomingMessage, HttpServletRequest httpRequest, Writer out) {
		JsonWriter jsonWriter = new JsonWriter(out);
		try {
			jsonWriter.beginObject();
			String token = incomingMessage.has("token") ? incomingMessage.get("token").getAsString() : null;
			if (incomingMessage.has("request")) {
				jsonWriter.name("response");
				processSingleRequest(incomingMessage.getAsJsonObject("request"), token, httpRequest, jsonWriter);
			} else if (incomingMessage.has("requests")) {
				processMultiRequest(incomingMessage.getAsJsonArray("requests"), token, httpRequest, jsonWriter);
			}
		} catch (Throwable throwable) {
			handleThrowable(jsonWriter, throwable);
		} finally {
			try {
				jsonWriter.endObject();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
	}

	private void processMultiRequest(JsonArray requests, String jsonToken, HttpServletRequest httpRequest, JsonWriter out) throws Exception {
		out.name("responses");
		out.beginArray();
		for (int r = 0; r < requests.size(); r++) {
			try {
				processSingleRequest((JsonObject) requests.get(r), jsonToken, httpRequest, out);
			} catch (Exception e) {
				handleThrowable(out, e);
			}
		}
		out.endArray();
	}

	private void processSingleRequest(JsonObject request, String jsonToken, HttpServletRequest httpRequest, JsonWriter writer) throws Exception {
		long s = System.nanoTime();
		String interfaceName = request.get("interface").getAsString();
		String methodName = request.get("method").getAsString();
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

		PublicInterface service = getServiceInterface(httpRequest, bimServer, sService.getInterfaceClass(), methodName, jsonToken);
		String oldThreadName = Thread.currentThread().getName();
		Thread.currentThread().setName(interfaceName + "." + methodName);
		try {
			Recording recording = bimServer.getMetricsRegistry().startRecording(sService, method);

			Object result = method.invoke(sService.getInterfaceClass(), service, parameters);
			
			recording.finish();
			
			// When we have managed to get here, no exceptions have been thrown. We
			// can safely assume further serialization to JSON won't fail. So now we
			// can start streaming
			if (writer != null) {
				if (result == null) {
					writer.beginObject();
					writer.name("result");
					writer.beginObject();
					writer.endObject();
					writer.endObject();
				} else {
					writer.beginObject();
					writer.name("result");
					converter.toJson(result, writer);
					writer.endObject();
				}
			}
			long e = System.nanoTime();
			LOGGER.debug(interfaceName + "." + methodName + " " + ((e - s) / 1000000) + "ms");
		} finally {
			Thread.currentThread().setName(oldThreadName);
		}
	}

	private void handleThrowable(JsonWriter writer, Throwable throwable) {
		if (!(throwable instanceof ServiceException)) {
			LoggerFactory.getLogger(JsonHandler.class).error("", throwable);
		} else {
			if (LoggerFactory.getLogger(JsonHandler.class).isDebugEnabled()) {
				LoggerFactory.getLogger(JsonHandler.class).debug("", throwable);
			}
		}
		try {
			writer.beginObject();
			writer.name("exception");
			writer.beginObject();
			writer.name("__type");
			writer.value(throwable.getClass().getSimpleName());
			writer.name("message");
			writer.value(throwable.getMessage() == null ? throwable.toString() : throwable.getMessage());
			if (throwable instanceof ServiceException) {
				ServiceException serviceException = (ServiceException) throwable;
				if (serviceException.getErrorCode() != null) {
					writer.name("errorCode");
					writer.value(serviceException.getErrorCode().getCode());
				}
			}
			writer.endObject();
			writer.endObject();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	private <T extends PublicInterface> T getServiceInterface(HttpServletRequest httpRequest, BimServer bimServer, Class<T> interfaceClass, String methodName, String token)
			throws JSONException, UserException, ServerException {
		if (methodName.equals("login") || methodName.equals("autologin")) {
			return bimServer.getServiceFactory().get(AccessMethod.JSON).get(interfaceClass);
		}
		if (token == null) {
			token = httpRequest == null ? null : (String) httpRequest.getSession().getAttribute("token");
		}
		if (token == null) {
			return bimServer.getServiceFactory().get(AccessMethod.JSON).get(interfaceClass);
		}
		T service = bimServer.getServiceFactory().get(token, AccessMethod.JSON).get(interfaceClass);
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