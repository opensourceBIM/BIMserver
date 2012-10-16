package org.bimserver;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.codehaus.jettison.json.JSONException;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

public class JsonHandler {
	private BimServer bimServer;
	private JsonConverter converter;

	public JsonHandler(BimServer bimServer) {
		this.bimServer = bimServer;
		converter = new JsonConverter(bimServer.getServicesMap());
	}

	public void execute(JsonObject incomingMessage, HttpServletRequest httpRequest, Writer out) throws IOException, JSONException {
		JsonWriter jsonWriter = new JsonWriter(out);
		JsonObject token = incomingMessage.has("token") ? incomingMessage.getAsJsonObject("token") : null;
		if (incomingMessage.has("request")) {
			jsonWriter.beginObject();
			jsonWriter.name("response");
			processSingleRequest(incomingMessage.getAsJsonObject("request"), token, httpRequest, jsonWriter);
			jsonWriter.endObject();
		} else if (incomingMessage.has("requests")) {
			processMultiRequest(incomingMessage.getAsJsonArray("requests"), token, httpRequest, jsonWriter);
		}
	}

	private void processMultiRequest(JsonArray requests, JsonObject token, HttpServletRequest httpRequest, JsonWriter out) throws IOException, JSONException {
		out.beginObject();
		out.name("responses");
		out.beginArray();
		for (int r = 0; r < requests.size(); r++) {
			processSingleRequest((JsonObject) requests.get(r), token, httpRequest, out);
		}
		out.endArray();
		out.endObject();
	}

	private void processSingleRequest(JsonObject request, JsonObject token, HttpServletRequest httpRequest, JsonWriter writer) {
		try {
			String interfaceName = request.get("interface").getAsString();
			@SuppressWarnings("unchecked")
			Class<? extends PublicInterface> clazz = (Class<? extends PublicInterface>) Class.forName("org.bimserver.shared.interfaces." + interfaceName);
			String methodName = request.get("method").getAsString();
			SService sService = bimServer.getServicesMap().get(interfaceName);
			if (sService == null) {
				throw new UserException("No service found with name " + interfaceName);
			}
			SMethod method = sService.getSMethod(methodName);
			if (method == null) {
				throw new UserException("Method " + methodName + " not found on " + interfaceName);
			}
			Object[] parameters = new Object[method.getParameters().size()];
			if (request.has("parameters")) {
				JsonObject parametersJson = request.getAsJsonObject("parameters");
				for (int i = 0; i < method.getParameters().size(); i++) {
					SParameter parameter = method.getParameter(i);
					if (parametersJson.has(parameter.getName())) {
						parameters[i] = converter.fromJson(parameter.getType(), parameter.getGenericType(), parametersJson.get(parameter.getName()));
					}
				}
			}

			Object service = getServiceInterface(httpRequest, bimServer, clazz, methodName, token);
			Object result = method.invoke(service, parameters);
			
			// When we have managed to get here, no exceptions have been thrown. We can safely assume further serialization to JSON won't fail. So now we can start streaming
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
		} catch (Exception exception) {
			LoggerFactory.getLogger(JsonHandler.class).error("", exception);
			try {
				writer.beginObject();
				writer.name("exception");
				writer.beginObject();
				writer.name("__type");
				writer.value(exception.getClass().getSimpleName());
				writer.name("message");
				writer.value(exception.getMessage());
				writer.endObject();
				writer.endObject();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private <T extends PublicInterface> T getServiceInterface(HttpServletRequest httpRequest, BimServer bimServer, Class<T> interfaceClass, String methodName, JsonObject jsonToken) throws JSONException, UserException, ServerException {
		SToken token = httpRequest == null ? null : (SToken) httpRequest.getSession().getAttribute("token");
		if (methodName.equals("login") || methodName.equals("autologin")) {
			return bimServer.getServiceFactory().newServiceMap(AccessMethod.INTERNAL, "").get(interfaceClass);
		}
		T service = null;
		if (token == null) {
			// There is no token in the HTTP Session, but we also allow the user
			// to not use sessions and provide the token in the json request
			if (jsonToken != null) {
				token = new SToken();
				token.setTokenString(jsonToken.get("tokenString").getAsString());
				token.setExpires(jsonToken.get("expires").getAsLong());
				service = bimServer.getServiceFactory().getService(interfaceClass, token);
				token = service.getCurrentToken();
			}
		} else {
			service = bimServer.getServiceFactory().getService(interfaceClass, token);
		}
		if (service == null) {
			service = bimServer.getServiceFactory().newServiceMap(AccessMethod.INTERNAL, "").get(interfaceClass);
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