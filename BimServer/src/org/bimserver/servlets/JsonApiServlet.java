package org.bimserver.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.BimServer;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;

public class JsonApiServlet extends HttpServlet {
	private static final long serialVersionUID = 186486233172374336L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		writeDocumentation(request, response);
	}

	private void writeDocumentation(HttpServletRequest request, HttpServletResponse response) {
		BimServer bimServer = (BimServer) getServletContext().getAttribute("bimserver");
		SService sService = bimServer.getServiceInterfaceService();
		response.setHeader("Content-Type", "text/html");
		try {
			PrintWriter writer = response.getWriter();
			
			if (request.getParameter("doc") != null) {
				String show = request.getParameter("show");
				if (show == null) {
					writeAllMethodsDocumentation(writer, sService);
				} else if (show.equals("method")) {
					writeMethodDocumentation(writer, sService.getSMethod(request.getParameter("name")));
				} else if (show.equals("type")) {
					writeTypeDocumentation(writer, sService.getSType(request.getParameter("name")));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeTypeDocumentation(PrintWriter writer, SClass sType) {
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

	private void writeAllMethodsDocumentation(PrintWriter writer, SService sService) {
		List<SMethod> methods = new ArrayList<SMethod>(sService.getMethods());
		Collections.sort(methods, new Comparator<SMethod>(){
			@Override
			public int compare(SMethod o1, SMethod o2) {
				return o1.getName().compareTo(o2.getName());
			}});
		for (SMethod sMethod : methods) {
			writeMethodDocumentation(writer, sMethod);
		}
	}

	private void writeMethodDocumentation(PrintWriter writer, SMethod sMethod) {
		writer.println("<div>");
		writer.println("<a href=\"?doc&show=method&name=" + sMethod.getName() + "\">" + sMethod.getName() + "</a>");
		writer.println("<pre>");
		writer.println("request: {");
		for (SParameter sParameter : sMethod.getParameters()) {
			writer.print("  " + sParameter.getName() + ": " + getJsonTypeName(sParameter.getType()));
			if (sParameter != sMethod.getParameters().get(sMethod.getParameters().size()-1)) {
				writer.println(", ");
			} else {
				writer.println();
			}
		}
		writer.println("}");
		writer.println("</pre>");
		
		writer.println("<pre>");
		writer.print("response: ");
		SClass returnType = sMethod.getReturnType();
		writer.println(getJsonTypeName(returnType));
		writer.println("</pre>");

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
		} else if (javaTypeName.equals("java.lang.String")) {
			return "String";
		} else if (javaTypeName.equals("java.util.Date")) {
			return "Date";
		} else if (javaTypeName.equals("void")) {
			return "void";
		} else {
			return "<a href=\"?doc&show=type&name=" + javaTypeName + "\">" + javaTypeName + "</a>";
		}
	}
}