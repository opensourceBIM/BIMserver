package org.bimwebserver.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimwebserver.BimWebServer;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;

import com.google.common.base.Charsets;

public class NotificationServlet extends HttpServlet {

	private JsonConverter converter;
	private BimWebServer bimWebServer;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bimWebServer = (BimWebServer)getServletContext().getAttribute("bimwebserver");
		converter = new JsonConverter(bimWebServer.getServicesInterfaces());
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Content-Type", "text/html");
		handleRequest(request, response);
	}

	private void handleRequest(HttpServletRequest httpRequest, HttpServletResponse response) {
		try {
			ServletInputStream inputStream = httpRequest.getInputStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			IOUtils.copy(inputStream, outputStream);
			JSONObject request = new JSONObject(new JSONTokener(new String(outputStream.toByteArray(), Charsets.UTF_8)));
			JSONObject requestObject = request.getJSONObject("request");

			response.setHeader("Content-Type", "application/json");
			
			String interfaceName = requestObject.getString("interface");
			String methodName = requestObject.getString("method");
			SMethod method = bimWebServer.getServiceInterface(interfaceName).getSMethod(methodName);
			if (method == null) {
				throw new UserException("Method " + methodName + " not found on " + interfaceName);
			}
			Object[] parameters = new Object[method.getParameters().size()];
			for (int i=0; i<method.getParameters().size(); i++) {
				SParameter parameter = method.getParameter(i);
				if (requestObject.has(parameter.getName())) {
					parameters[i] = converter.fromJson(parameter.getType(), parameter.getGenericType(), requestObject.get(parameter.getName()));
				}
			}

			try {
				Object result = method.invoke(bimWebServer.getService(interfaceName), parameters);
				JSONObject responseObject = new JSONObject();
				responseObject.put("response", converter.toJson(result));
				responseObject.write(response.getWriter());
			} catch (Exception e) {
				sendException(response, e);
			}
		} catch (Exception e) {
			sendException(response, e);
		}
	}

	private void sendException(HttpServletResponse response, Exception exception) {
		try {
			JSONObject responseObject = new JSONObject();
			JSONObject exceptionJson = new JSONObject();
			exceptionJson.put("message", exception.getMessage());
			responseObject.put("exception", exceptionJson);
			responseObject.write(response.getWriter());
		} catch (JSONException e) {
		} catch (IOException e) {
		}
	}
}