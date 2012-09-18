package org.bimserver.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ConvertException;
import org.bimserver.shared.JsonConverter;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;

import com.google.common.base.Charsets;

public class JsonApiServlet extends HttpServlet {
	private static final long serialVersionUID = 186486233172374336L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BimServer bimServer = (BimServer) getServletContext().getAttribute("bimserver");
		SService sService = bimServer.getServiceInterfaceService();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Content-Type", "text/html");
		try {
			PrintWriter writer = response.getWriter();
			if (request.getParameter("doc") != null) {
				writeDocumentation(request, bimServer, sService, writer);
			} else {
				handleRequest(request, response, bimServer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handleRequest(HttpServletRequest httpRequest, HttpServletResponse response, BimServer bimServer) {
		JsonConverter converter = new JsonConverter(bimServer.getServiceInterfaceService());
		try {
			ServletInputStream inputStream = httpRequest.getInputStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			IOUtils.copy(inputStream, outputStream);
			JSONObject request = new JSONObject(new JSONTokener(new String(outputStream.toByteArray(), Charsets.UTF_8)));
			JSONObject requestObject = request.getJSONObject("request");

			ServiceInterface service = getServiceInterface(httpRequest, bimServer, request);
			response.setHeader("Content-Type", "application/json");
			
			// TODO get the actual ServiceInterface in a generic way (using "interface")
			SMethod method = bimServer.getServiceInterfaceService().getSMethod(requestObject.getString("method"));
			Object[] parameters = new Object[method.getParameters().size()];
			for (int i=0; i<method.getParameters().size(); i++) {
				SParameter parameter = method.getParameter(i);
				try {
					if (requestObject.has(parameter.getName())) {
						parameters[i] = converter.fromJson(parameter.getType(), requestObject.get(parameter.getName()));
					}
				} catch (ConvertException e) {
					e.printStackTrace();
				}
			}
			
			try {
				Object result = method.invoke(service, parameters);
				JSONObject responseObject = new JSONObject();
				responseObject.put("response", converter.toJson(result));
				responseObject.write(response.getWriter());
			} catch (Exception e) {
				JSONObject responseObject = new JSONObject();
				JSONObject exceptionJson = new JSONObject();
				exceptionJson.put("message", e.getMessage());
				responseObject.put("exception", exceptionJson);
				responseObject.write(response.getWriter());
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		}
	}

	private ServiceInterface getServiceInterface(HttpServletRequest httpRequest, BimServer bimServer, JSONObject request) throws JSONException, UserException,
			ServerException {
		Token token = (Token) httpRequest.getSession().getAttribute("token");
		ServiceInterface service = null;
		if (token == null) {
			// There is no token in the HTTP Session, but we also allow the user to not use sessions and provide the token in the json request
			if (request.has("token")) {
				JSONObject jsonToken = request.getJSONObject("token");
				token = new Token(jsonToken.getString("token"), jsonToken.getLong("expires"));
				service = bimServer.getServiceFactory().getService(token);
			}
		} else {
			service = bimServer.getServiceFactory().getService(token);
		}
		if (service == null) {
			service = bimServer.getServiceFactory().newService(AccessMethod.INTERNAL, "");
			httpRequest.getSession().setAttribute("token", service.getCurrentToken());
		}
		return service;
	}

	private void writeDocumentation(HttpServletRequest request, BimServer bimServer, SService sService, PrintWriter writer) {
		String siteAddress = "";
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			siteAddress = bimServer.getServerSettings(session).getSiteAddress();
		} finally {
			session.close();
		}
		writeHeader(writer);
		writer.println("<h1>BIMserver JSON API Documentation</h1>");
		writeMenu(writer, sService);
		writer.println("<div class=\"main\">");
		String show = request.getParameter("show");
		if (show == null) {
			writeAllMethodsDocumentation(writer, request, sService, bimServer, siteAddress);
		} else if (show.equals("method")) {
			writeMethodDocumentation(writer, request, sService.getSMethod(request.getParameter("name")), bimServer, siteAddress);
		} else if (show.equals("type")) {
			writeTypeDocumentation(writer, sService.getSType(request.getParameter("name")), bimServer);
		}
		writer.println("</div>");
		writeFooter(writer);
	}
	
	private void writeMenu(PrintWriter writer, SService sService) {
		writer.println("<div class=\"menu\">");
		List<SMethod> methods = new ArrayList<SMethod>(sService.getMethods());
		Collections.sort(methods, new Comparator<SMethod>(){
			@Override
			public int compare(SMethod o1, SMethod o2) {
				return o1.getName().compareTo(o2.getName());
			}});
		writer.println("<h2>Methods</h2>");
		writer.println("<ul>");
		for (SMethod sMethod : methods) {
			writer.println("<li>");
			writer.println("<a href=\"#" + sMethod.getName() + "\">" + sMethod.getName() + "</a>");
			writer.println("</li>");
		}
		writer.println("</ul>");
		writer.println("<h2>Objects</h2>");
		writer.println("<ul>");
		for (SClass sType : sService.getTypes()) {
			if (sType.getName().contains("org.bimserver")) {
				writer.println("<li>");
				writer.println("<a href=\"#" + sType.getName() + "\">" + sType.getSimpleName() + "</a>");
				writer.println("</li>");
			}
		}
		writer.println("</ul>");
		writer.println("</div>");
	}

	private void writeHeader(PrintWriter writer) {
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>BIMserver JSON API Documentation</title>");
		writer.println("<style>");
		writer.println("* {font: 13px/1.5 'Helvetica Neue', Arial, 'Liberation Sans', FreeSans, sans-serif; color: #333}");
		writer.println(".jsondoc {width: 900px; margin-left: auto; margin-right: auto}");
		writer.println("th {text-align: left}");
		writer.println(".method {border-bottom: 1px solid #eeeeee; margin-bottom: 20px}");
		writer.println("h1 {font-size: 3em}");
		writer.println("h2 {font-size: 2em}");
		writer.println("h3 {font-size: 1em; font-weight: bold; margin: 0}");
		writer.println("a {text-decoration: none}");
		writer.println(".menu {float: left; width: 300px; overflow: hidden}");
		writer.println(".main {float: left; width: 600px}");
		writer.println(".menu ul {padding-left: 5px}");
		writer.println(".menu li {list-style: none}");
		writer.println(".method table {width: 100%}");
		writer.println(".method td:first-child {width: 30%}");
		writer.println(".method td:last-child {width: 70%}");
		writer.println(".method td {border-top: 1px solid #eeeeee; padding-top: 10px; padding-bottom: 10px}");
		writer.println("</style>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<div class=\"jsondoc\">");
	}

	private void writeFooter(PrintWriter writer) {
		writer.println("</div>");
		writer.println("</body>");
	}
	
	private void writeTypeDocumentation(PrintWriter writer, SClass sType, BimServer bimServer) {
		writer.println("<pre>");
		if (sType.isEnum()) {
			writer.println(sType.getSimpleName() + " (Enum): ");
			writer.print("  ");
			for (String value : sType.getEnumValues()) {
				writer.print("\"" + value + "\"");
				if (sType.getEnumValues().get(sType.getEnumValues().size() - 1) != value) {
					writer.print(" | ");
				}
			}
		} else {
			writer.println(sType.getSimpleName() + " (Class): ");
			if (!sType.getSubClasses().isEmpty()) {
				writer.println("SubTypes: ");
				for (SClass subType : sType.getSubClasses()) {
					writer.println("  " + getJsonTypeName(subType));
				}
			}
			writer.println("{");
			writer.println("  __type: \"" + sType.getSimpleName() + "\"");
			for (SField sField : sType.getFields()) {
				if (sField.isAggregate()) {
					writer.print("  " + sField.getName() + ": [" + getJsonTypeName(sField.getGenericType()) + "]");
				} else {
					writer.print("  " + sField.getName() + ": " + getJsonTypeName(sField.getType()));
				}
				if (sField != sType.getFields().get(sType.getFields().size() - 1)) {
					writer.println(", ");
				} else {
					writer.println();
				}
			}
			writer.println("}");
		}
		writer.println("</pre>");
	}

	private void writeAllMethodsDocumentation(PrintWriter writer, HttpServletRequest request, SService sService, BimServer bimServer, String siteAddress) {
		List<SMethod> methods = new ArrayList<SMethod>(sService.getMethods());
		Collections.sort(methods, new Comparator<SMethod>(){
			@Override
			public int compare(SMethod o1, SMethod o2) {
				return o1.getName().compareTo(o2.getName());
			}});
		for (SMethod sMethod : methods) {
			writeMethodDocumentation(writer, request, sMethod, bimServer, siteAddress);
		}
	}

	private void writeMethodDocumentation(PrintWriter writer, HttpServletRequest request, SMethod sMethod, BimServer bimServer, String siteAddress) {
		writer.println("<div class=\"method\">");
		writer.println("<a name=\"" + sMethod.getName() + "\" href=\"#" + sMethod.getName() + "\"><h1>GET " + sMethod.getName() + "</h1></a>");
//		writer.println("<h1>GET " + sMethod.getName() + "</h1>");
		writer.println(sMethod.getDoc());
		writer.println("<h2>Resource URL</h2>");
		writer.println(siteAddress + request.getServletPath() + "/" + sMethod.getName());
		writer.println("<h2>Parameters</h2>");
		if (sMethod.getParameters().isEmpty()) {
			writer.println("No parameters");
		} else {
			writer.println("<table>");
			writer.println("<tr><th>Name</th><th>Description</th></tr>");
			for (SParameter sParameter : sMethod.getParameters()) {
				writer.print("<tr><td><h3>" + sParameter.getName() + "</h3>" + getJsonTypeName(sParameter.getType()) + "</td><td>" + sParameter.getDoc() + "</td></tr>");
			}
			writer.println("</table>");
		}
		
		writer.println("<h2>Response</h2>");
		if (sMethod.getReturnType() == null || sMethod.getReturnType().getName().equals("void")) {
			writer.println("No response");
		} else {
			writer.println("<pre>");
			writer.print("response: ");
			SClass returnType = sMethod.getReturnType();
			writer.println(getJsonTypeName(returnType));
			writer.println("</pre>");
		}

		writer.println("</div>");
	}

	public String getJsonTypeName(SClass sClass) {
		String javaTypeName = sClass.getName();
		if (javaTypeName.equals("java.lang.Long") || javaTypeName.equals("long")) {
			return "long";
		} else if (javaTypeName.equals("java.lang.Integer")) {
			return "int";
		} else if (javaTypeName.equals("java.lang.Boolean")) {
			return "boolean";
		} else if (javaTypeName.equals("java.lang.Double")) {
			return "double";
		} else if (javaTypeName.equals("java.lang.String")) {
			return "String";
		} else if (javaTypeName.equals("java.util.Date")) {
			return "Date";
		} else if (javaTypeName.equals("void")) {
			return "void";
		} else {
			return "<a href=\"?doc&show=type&name=" + javaTypeName + "\">" + sClass.getSimpleName() + "</a>";
		}
	}
}