package org.bimserver;

import javax.servlet.http.HttpServletRequest;

import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonHandler {
	private BimServer bimServer;
	private JsonConverter converter;

	public JsonHandler(BimServer bimServer) {
		this.bimServer = bimServer;
		converter = new JsonConverter(bimServer.getServiceInterfaces());
	}
	
	public JSONObject execute(JSONObject request, HttpServletRequest httpRequest) throws JSONException, ServiceException {
		JSONObject requestObject = request.getJSONObject("request");


		ServiceInterface service = getServiceInterface(httpRequest, bimServer, request);
		
		String interfaceName = requestObject.getString("interface");
		String methodName = requestObject.getString("method");
		SService sService = bimServer.getServiceInterface(interfaceName);
		SMethod method = sService.getSMethod(methodName);
		if (method == null) {
			throw new UserException("Method " + methodName + " not found on " + interfaceName);
		}
		Object[] parameters = new Object[method.getParameters().size()];
		for (int i=0; i<method.getParameters().size(); i++) {
			SParameter parameter = method.getParameter(i);
			if (requestObject.has(parameter.getName())) {
				parameters[i] = converter.fromJson(parameter.getType(), requestObject.get(parameter.getName()));
			}
		}

		Object result = method.invoke(service, parameters);
		JSONObject responseObject = new JSONObject();
		if (result == null) {
			responseObject.put("response", new JSONObject());
		} else {
			responseObject.put("response", converter.toJson(result));
		}
		
		return responseObject;
	}

	private ServiceInterface getServiceInterface(HttpServletRequest httpRequest, BimServer bimServer, JSONObject request) throws JSONException, UserException,
			ServerException {
		SToken token = httpRequest == null ? null : (SToken) httpRequest.getSession().getAttribute("token");
		ServiceInterface service = null;
		if (token == null) {
			// There is no token in the HTTP Session, but we also allow the user to not use sessions and provide the token in the json request
			if (request.has("token")) {
				JSONObject jsonToken = request.getJSONObject("token");
				token = new SToken();
				token.setTokenString(jsonToken.getString("tokenString"));
				token.setExpires(jsonToken.getLong("expires"));
				service = bimServer.getServiceFactory().getService(token);
			}
		} else {
			service = bimServer.getServiceFactory().getService(token);
		}
		if (service == null) {
			service = bimServer.getServiceFactory().newService(AccessMethod.INTERNAL, "");
			if (httpRequest != null) {
				httpRequest.getSession().setAttribute("token", service.getCurrentToken());
			}
		}
		return service;
	}

	public JsonConverter getJsonConverter() {
		return converter;
	}
}