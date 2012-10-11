package org.bimserver;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONWriter;

public class JsonHandler {
	private BimServer bimServer;
	private JsonConverter converter;

	public JsonHandler(BimServer bimServer) {
		this.bimServer = bimServer;
		converter = new JsonConverter(bimServer.getServicesMap());
	}

	public void execute(JSONObject incomingMessage, HttpServletRequest httpRequest, Writer out) throws JSONException {
		JSONWriter jsonWriter = new JSONWriter(out);
		if (incomingMessage.has("request")) {
			processSingleRequest(incomingMessage.getJSONObject("request"), httpRequest, jsonWriter);
		} else if (incomingMessage.has("requests")) {
			processMultiRequest(incomingMessage.getJSONArray("requests"), httpRequest, jsonWriter);
		}
	}

	private void processMultiRequest(JSONArray requests, HttpServletRequest httpRequest, JSONWriter out) throws JSONException {
		out.object();
		out.key("responses");
		out.array();
		for (int r = 0; r < requests.length(); r++) {
			processSingleRequest(requests.getJSONObject(r), httpRequest, out);
		}
		out.endArray();
		out.endObject();
	}

	private void processSingleRequest(JSONObject request, HttpServletRequest httpRequest, JSONWriter writer) throws JSONException {
		try {
			String interfaceName = request.getString("interface");
			@SuppressWarnings("unchecked")
			Class<? extends PublicInterface> clazz = (Class<? extends PublicInterface>) Class.forName("org.bimserver.shared.interfaces." + interfaceName);
			String methodName = request.getString("method");
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
				JSONObject parametersJson = request.getJSONObject("parameters");
				for (int i = 0; i < method.getParameters().size(); i++) {
					SParameter parameter = method.getParameter(i);
					if (parametersJson.has(parameter.getName())) {
						parameters[i] = converter.fromJson(parameter.getType(), parameter.getGenericType(), parametersJson.get(parameter.getName()));
					}
				}
			}

			Object service = getServiceInterface(httpRequest, bimServer, clazz, request);
			Object result = method.invoke(service, parameters);
			
			// When we have managed to get here, no exceptions have been thrown. We can safely assume further serialization to JSON won't fail. So now we can start streaming
			if (writer != null) {
				if (result == null) {
					writer.key("result");
					writer.object();
					writer.endObject();
				} else {
					converter.toJson(result, writer);
				}
			}
		} catch (Exception exception) {
			JSONObject responseObject = new JSONObject();
			ServiceException serviceException = (ServiceException)exception;
			JSONObject exceptionJson = new JSONObject();
			exceptionJson.put("message", exception.getMessage());
			exceptionJson.put("__type", serviceException.getClass().getSimpleName());
			responseObject.put("exception", exceptionJson);
		}
	}

	private <T extends PublicInterface> T getServiceInterface(HttpServletRequest httpRequest, BimServer bimServer, Class<T> interfaceClass, JSONObject request) throws JSONException, UserException, ServerException {
		SToken token = httpRequest == null ? null : (SToken) httpRequest.getSession().getAttribute("token");
		T service = null;
		if (token == null) {
			// There is no token in the HTTP Session, but we also allow the user
			// to not use sessions and provide the token in the json request
			if (request.has("token")) {
				JSONObject jsonToken = request.getJSONObject("token");
				token = new SToken();
				token.setTokenString(jsonToken.getString("tokenString"));
				token.setExpires(jsonToken.getLong("expires"));
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